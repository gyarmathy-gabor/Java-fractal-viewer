import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class SettingsHeaderPanel extends HeaderPanel{
    Profile profiles[];

    private JTextField profileNameTextField;
    private JComboBox profileList;
    private JButton saveProfileButton;

    public SettingsHeaderPanel(JFrame parentFrame){
        super(parentFrame);


        List<Profile> profilesList = FileUtils.readProfiles();
        if(profilesList==null){
            profiles = new Profile[0];
        }
        else{
            profiles = profilesList.toArray(new Profile[0]);
        }



        //Save profile button
        saveProfileButton = new JButton("Save");
        saveProfileButton.setBounds(800,0,100,50);
        add(saveProfileButton);

        //Profiles combobox
        profileList = new JComboBox(profiles);
        profileList.setBounds(600,0,200,50);
        add(profileList);

        //Give name text-field
        profileNameTextField = new JTextField("");
        profileNameTextField.setBounds(300,0,300,50);
        add(profileNameTextField);



        saveProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SettingsFrame settingsFrame = (SettingsFrame) parentFrame;

                //Make profile
                Profile profile = new Profile(
                        getGivenNameOfProfile(),
                        settingsFrame.getParametersPanel().getMaxIterations(),
                        settingsFrame.getParametersPanel().getEscapeRadius(),
                        settingsFrame.getColormapsPanel().getChosenColormap(),
                        settingsFrame.getSetsPanel().getFractalChoice()
                );

                //Give profile over
                FileUtils.saveProfile(profile);
            }
        });
    }

    public String getGivenNameOfProfile(){

        if(profileNameTextField.getText().isEmpty()){
            return "Default";
        }

        return profileNameTextField.getText().trim();
    }

}
