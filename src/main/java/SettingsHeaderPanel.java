import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class SettingsHeaderPanel extends HeaderPanel{
    Profile profiles[];

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
        JButton saveProfileButton = new JButton("Save");
        saveProfileButton.setBounds(800,0,100,50);
        add(saveProfileButton);

        //Profiles combobox
        JComboBox profileList = new JComboBox(profiles);
        profileList.setBounds(600,0,200,50);
        add(profileList);

        //Give name text-field
        JTextField profileNameTextField = new JTextField("");
        profileNameTextField.setBounds(300,0,300,50);
        add(profileNameTextField);



        saveProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Make profile


                //Give profile over
                    //  FileUtils.saveProfile(HERE);
            }
        });
    }
}
