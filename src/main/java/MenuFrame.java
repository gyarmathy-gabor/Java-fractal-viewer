import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuFrame extends JFrame {


    public MenuFrame(){
        setTitle("Main Menu");
        setSize(900,650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //Button Panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20,20,20,20);

        //Play button
        JButton playButton = new JButton("Play");
        playButton.setPreferredSize(new Dimension(200,50));
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(playButton,gbc);

        //Settings button
        JButton settingsButton = new JButton("Settings");
        playButton.setPreferredSize(new Dimension(200,50));
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(settingsButton,gbc);

        //Exit button
        JButton exitButton = new JButton("Exit");
        playButton.setPreferredSize(new Dimension(200,50));
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(exitButton,gbc);


        playButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                setVisible(false);
                MandelbrotFrame frame = new MandelbrotFrame();
                setVisible(true); //If they leave back into menu
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

        add(panel);
        setVisible(true);


    }
}
