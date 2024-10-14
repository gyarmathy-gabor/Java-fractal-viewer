import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HeaderPanel extends JPanel {
    private JFrame parentFrame; //Hogy ki tudjunk belőle lépni vissza a menübe

    public HeaderPanel(JFrame parentFrame){
        setLayout(null);
        setSize(900,50);
        this.parentFrame = parentFrame;

        this.setBackground(Color.GRAY);

        //Return to menu button
        JButton returnToMenuButton = new JButton("Back to menu");
        returnToMenuButton.setBounds(0,0,100,50);
        add(returnToMenuButton);



        returnToMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parentFrame.dispose();
            }
        });
    }
}
