import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuFrame extends JFrame {
   private JButton playButton;
   private JButton animationButton;
   private JButton settingsButton;
   private JButton exitButton;
   private JPanel buttonsPanel;


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

        //Animation Button
        animationButton = new JButton("Animation");
        animationButton.setPreferredSize(new Dimension(200,50));
        gbc.gridx = 0;
        gbc.gridy = 1;
        buttonsPanel.add(animationButton,gbc);

        //Settings button
        settingsButton = new JButton("Settings");
        playButton.setPreferredSize(new Dimension(200,50));
        gbc.gridx = 0;
        gbc.gridy = 2;
        buttonsPanel.add(settingsButton,gbc);

        //Exit button
        exitButton = new JButton("Exit");
        playButton.setPreferredSize(new Dimension(200,50));
        gbc.gridx = 0;
        gbc.gridy = 3;
        buttonsPanel.add(exitButton,gbc);


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

        animationButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Profile active = FileUtils.getChoosenProfile();


                if(active.getFractalType()!=Fractal.JULIA){
                    JOptionPane.showMessageDialog(MenuFrame.this,
                            "Please use a profile with julia fractal type set",
                            "Warning",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }
                setVisible(false);
                AnimationFrame frame = new AnimationFrame(MenuFrame.this);

            }
        });

        settingsButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                setVisible(false);
                SettingsFrame settingsFrame = new SettingsFrame(MenuFrame.this);
                //setVisible(true); //If they leave back into menu make this logic work inside the settings
            }
        });


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
