import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {


    public MainMenu(){
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
            public void actionPerformed(ActionEvent e){
                MandelbrotFrame frame = new MandelbrotFrame();
                dispose();
            }
        });

        settingsButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Settings settings = new Settings();
                dispose();
            }
        });


        exitButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });

        add(panel);
        setVisible(true);


    }
}
