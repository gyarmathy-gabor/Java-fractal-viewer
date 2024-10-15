import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SettingsHeaderPanel extends HeaderPanel {
    private Profile[] profiles;
    private JTextField profileNameTextField;
    private JComboBox<Profile> profileList;
    private JButton saveProfileButton;
    private JButton deleteProfileButton;

    public SettingsHeaderPanel(JFrame parentFrame) {
        super(parentFrame);
        initializeProfiles();
        initializeUIComponents();
        setupListeners((SettingsFrame) parentFrame);
    }

    private void initializeProfiles() {
        List<Profile> profilesList = FileUtils.readProfiles();
        profiles = profilesList != null ? profilesList.toArray(new Profile[0]) : new Profile[0];
    }

    private void initializeUIComponents() {
        setLayout(null);

        // Profiles JComboBox
        profileList = new JComboBox<>(profiles);
        profileList.setBounds(600, 0, 200, 50);
        add(profileList);

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

    private void setupListeners(SettingsFrame settingsFrame) {
        // Save profile button action listener
        saveProfileButton.addActionListener(e -> {
            Profile profile = createProfile(settingsFrame);
            FileUtils.saveProfile(profile);
            updateProfileList(profile);
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

    private Profile createProfile(SettingsFrame settingsFrame) {
        return new Profile(
                getGivenNameOfProfile(),
                settingsFrame.getParametersPanel().getMaxIterations(),
                settingsFrame.getParametersPanel().getEscapeRadius(),
                settingsFrame.getColormapsPanel().getChosenColormap(),
                settingsFrame.getSetsPanel().getFractalChoice()
        );
    }

    private void updateProfileList(Profile newProfile) {
        // Update profiles array and JComboBox
        List<Profile> list = FileUtils.readProfiles();
        profiles = list.toArray(new Profile[0]);
        profileList.addItem(newProfile);
        profileList.setSelectedItem(newProfile);
    }

    private void updateSettingsFromProfile(SettingsFrame settingsFrame, Profile profile) {
        settingsFrame.getParametersPanel().setTextFieldEscapeRadius(profile.getEscapeRadius());
        settingsFrame.getParametersPanel().setTextFieldMaxIterations(profile.getMaxIter());
        settingsFrame.getColormapsPanel().setMaps(profile.getColormap());
        settingsFrame.getSetsPanel().setSets(profile.getFractalType());
    }

    private void deleteProfile(int idx) {
        Profile toDelete = profiles[idx];
        FileUtils.deleteProfile(toDelete);
        refreshProfileList();
    }

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

    public String getGivenNameOfProfile() {
        return profileNameTextField.getText().isEmpty() ? "Default" : profileNameTextField.getText().trim();
    }
}
