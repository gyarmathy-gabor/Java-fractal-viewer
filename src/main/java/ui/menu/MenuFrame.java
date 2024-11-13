package ui.menu;

import model.profile.Profile;
import ui.viewer.frame.MandelbrotFrame;
import ui.settings.frame.SettingsFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Represents the main menu frame of the application. This frame provides
 * options to start a new fractal visualization (Play), adjust settings (Settings),
 * or exit the application (Exit).
 */
public class MenuFrame extends JFrame {
   private JButton playButton;
   private JButton settingsButton;
   private JButton exitButton;
   private JPanel buttonsPanel;


    /**
     * Constructs the main menu frame, setting up the window, layout, and buttons.
     * Initializes the play, settings, and exit buttons and their associated actions.
     */
    public MenuFrame(){
        setTitle("Main Menu");
        setSize(900,650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //Buttons Panel
        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20,20,20,20);

        //Play button
        playButton = new JButton("Play");
        playButton.setPreferredSize(new Dimension(200,50));
        gbc.gridx = 0;
        gbc.gridy = 0;
        buttonsPanel.add(playButton,gbc);

        //Settings button
        settingsButton = new JButton("Settings");
        playButton.setPreferredSize(new Dimension(200,50));
        gbc.gridx = 0;
        gbc.gridy = 1;
        buttonsPanel.add(settingsButton,gbc);

        //Exit button
        exitButton = new JButton("Exit");
        playButton.setPreferredSize(new Dimension(200,50));
        gbc.gridx = 0;
        gbc.gridy = 2;
        buttonsPanel.add(exitButton,gbc);

        //Action listener for Play button
        playButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){

                if(!Profile.isThereAnyProfileInUse()){
                    JOptionPane.showMessageDialog(MenuFrame.this,
                            "Please setup your profile inside settings!",
                            "Warning",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }
                setVisible(false);
                MandelbrotFrame frame = new MandelbrotFrame(MenuFrame.this);

            }
        });
        //Action listener for Settings button
        settingsButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                setVisible(false);
                SettingsFrame settingsFrame = new SettingsFrame(MenuFrame.this);
                //setVisible(true); //If they leave back into menu make this logic work inside the settings
            }
        });

        //Action listener for Exit button
        exitButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });

        add(buttonsPanel);
        setVisible(true);


    }
}
