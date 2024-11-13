package ui.settings.panel;

import model.profile.Profile;
import ui.HeaderPanel;
import ui.settings.frame.SettingsFrame;
import util.FileUtils;

import javax.swing.*;
import java.util.List;

/**
 * Represents the header panel in the settings screen of the application.
 * This panel provides UI components for managing profiles, including selecting, saving, and deleting profiles.
 * It also includes input fields to specify the profile name and buttons for interaction.
 */
public class SettingsHeaderPanel extends HeaderPanel {
    private Profile[] profiles;
    private JTextField profileNameTextField;
    private JComboBox<Profile> profileList;
    private JButton saveProfileButton;
    private JButton deleteProfileButton;

    /**
     * Constructor that initializes the settings header panel.
     * @param parentFrame The parent frame (SettingsFrame) that this panel belongs to.
     */
    public SettingsHeaderPanel(JFrame parentFrame) {
        super(parentFrame);
        initializeProfiles();
        initializeUIComponents();
        setupListeners((SettingsFrame) parentFrame);
    }

    /**
     * Initializes the list of profiles by reading them from a file.
     */
    private void initializeProfiles() {
        List<Profile> profilesList = FileUtils.readProfiles();
        profiles = profilesList != null ? profilesList.toArray(new Profile[0]) : new Profile[0];
    }

    /**
     * Initializes the UI components, including the profile selection combo box,
     * profile name text field, save and delete profile buttons.
     */
    private void initializeUIComponents() {
        setLayout(null);

        // Profiles JComboBox
        profileList = new JComboBox<>(profiles);
        profileList.setBounds(600, 0, 200, 50);
        add(profileList);
        profileList.setSelectedIndex(-1);

        // Profile name JTextField
        profileNameTextField = new JTextField();
        profileNameTextField.setBounds(300, 0, 300, 50);
        add(profileNameTextField);

        // Save profile JButton
        saveProfileButton = new JButton("Save");
        saveProfileButton.setBounds(800, 0, 100, 50);
        add(saveProfileButton);

        // Delete profile JButton
        deleteProfileButton = new JButton("Delete");
        deleteProfileButton.setBounds(200, 0, 100, 50);
        add(deleteProfileButton);
    }

    /**
     * Sets up the action listeners for the buttons and profile selection.
     * Handles saving a new profile, selecting an existing profile, and deleting a profile.
     * @param settingsFrame The parent SettingsFrame.
     */
    private void setupListeners(SettingsFrame settingsFrame) {
        // Save profile button action listener
        saveProfileButton.addActionListener(e -> {
            Profile profile = createProfile(settingsFrame);

            if (!profileExists(profile)) {
                FileUtils.saveProfile(profile);
                updateProfileList(profile);
            }
            else{
                JOptionPane.showMessageDialog(this, "Profile already exists!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Profile selection action listener
        profileList.addActionListener(e -> {
            int idx = profileList.getSelectedIndex();
            if (idx >= 0 && idx < profiles.length) {
                updateSettingsFromProfile(settingsFrame, profiles[idx]);
            }
        });

        // Delete profile button action listener
        deleteProfileButton.addActionListener(e -> {
            int idx = profileList.getSelectedIndex();
            if (idx != -1) {
                deleteProfile(idx);
            }
        });
    }

    /**
     * Checks if a profile already exists in the list of profiles.
     * @param newProfile The profile to check.
     * @return true if the profile already exists, false otherwise.
     */
    private boolean profileExists(Profile newProfile) {
        // Check if the profile with the same name exists in the current profiles
        for (Profile profile : profiles) {
            if (profile.hasSameName(newProfile)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Creates a new profile using the current settings from the SettingsFrame.
     * @param settingsFrame The parent SettingsFrame.
     * @return A new Profile object.
     */
    private Profile createProfile(SettingsFrame settingsFrame) {
        return new Profile(
                getGivenNameOfProfile(),
                settingsFrame.getParametersPanel().getMaxIterations(),
                settingsFrame.getParametersPanel().getEscapeRadius(),
                settingsFrame.getColormapsPanel().getChosenColormap(),
                settingsFrame.getSetsPanel().getFractalChoice()
        );
    }

    /**
     * Updates the profile list and the JComboBox with the newly saved profile.
     * @param newProfile The profile that was just saved.
     */
    private void updateProfileList(Profile newProfile) {
        // Update profiles array and JComboBox
        List<Profile> list = FileUtils.readProfiles();
        profiles = list.toArray(new Profile[0]);
        profileList.addItem(newProfile);
        profileList.setSelectedItem(newProfile);
    }

    /**
     * Updates the settings panel with the data from the selected profile.
     * @param settingsFrame The SettingsFrame to update.
     * @param profile The profile whose settings should be applied.
     */
    private void updateSettingsFromProfile(SettingsFrame settingsFrame, Profile profile) {
        settingsFrame.getParametersPanel().setTextFieldEscapeRadius(profile.getEscapeRadius());
        settingsFrame.getParametersPanel().setTextFieldMaxIterations(profile.getMaxIter());
        settingsFrame.getColormapsPanel().setMaps(profile.getColormap());
        settingsFrame.getSetsPanel().setSets(profile.getFractalType());
        profileNameTextField.setText(profile.toString());
        setProfileActive(profile);
    }

    /**
     * Deletes the selected profile from the list of profiles.
     * @param idx The index of the profile to delete.
     */
    private void deleteProfile(int idx) {
        Profile toDelete = profiles[idx];
        FileUtils.deleteProfile(toDelete);
        refreshProfileList();
    }

    /**
     * Refreshes the profile list in the JComboBox after a profile has been deleted or added.
     */
    private void refreshProfileList() {
        List<Profile> list = FileUtils.readProfiles();
        profiles = list.toArray(new Profile[0]);
        profileList.removeAllItems();
        for (Profile profile : profiles) {
            profileList.addItem(profile);
        }
        if (profiles.length > 0) {
            profileList.setSelectedIndex(Math.min(profileList.getSelectedIndex(), profiles.length - 1));
        } else {
            profileList.setSelectedIndex(-1); // If list is empty index -1 means no selection
        }
    }

    /**
     * Retrieves the name of the profile to be saved.
     * @return The profile name, defaulting to "Default" if empty.
     */
    public String getGivenNameOfProfile() {
        return profileNameTextField.getText().isEmpty() ? "Default" : profileNameTextField.getText().trim();
    }

    /**
     * Marks the given profile as the active profile in the system.
     * This function will update the "active" flag of the profile in the saved profiles.
     * @param profile The profile to set as active.
     */
    public void setProfileActive(Profile profile){
        //Get profiles
        List<Profile> profiles = FileUtils.readProfiles();


        //Make every profile's active bool false
        for(Profile p : profiles){
            p.setIsProfileInUse(false);
        }
        //Make the current profile's active bool true
        for(Profile p : profiles){
            if(p.hasSameName(profile)){p.setIsProfileInUse(true);}
        }
        //Save every profile
        FileUtils.writeProfiles(profiles);
    }
}
