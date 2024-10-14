import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class SettingsHeaderPanel extends HeaderPanel{
    Profile profiles[];

    public SettingsHeaderPanel(JFrame parentFrame){
        super(parentFrame);


        profiles = new Profile[1];



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


    }
}
