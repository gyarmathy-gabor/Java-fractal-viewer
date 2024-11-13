package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Represents the header panel displayed at the top of a JFrame.
 * The header contains a button that allows the user to return to the main menu by closing the current frame.
 * The panel has a fixed size and background color, and the button is positioned at the left side of the panel.
 * For each Scene it has different type of buttons, and options other than the exit button.
 */
public class HeaderPanel extends JPanel {
    //Reference to the parent frame that this header panel belongs to.
    private JFrame parentFrame;

    /**
     * Constructs a new HeaderPanel for a given parent frame.
     * Sets up the layout, size, background color, and the action listener for the "Back to menu" button.
     *
     * @param parentFrame The JFrame that this header panel belongs to. It will be disposed of when the button is clicked.
     */
    public HeaderPanel(JFrame parentFrame){
        setLayout(null);
        setSize(900,50);
        this.parentFrame = parentFrame;

        this.setBackground(Color.GRAY);

        //Return to menu button
        JButton returnToMenuButton = new JButton("Back to menu");
        returnToMenuButton.setBounds(0,0,100,50);
        add(returnToMenuButton);


        //Add action listener for the button to return to the main menu
        returnToMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parentFrame.dispose();
            }
        });
    }
}
