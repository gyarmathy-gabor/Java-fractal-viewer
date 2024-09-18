import javax.swing.*;
import java.awt.*;

public class Settings extends JFrame {
    public Settings(){
        setTitle("Settings");
        setSize(900,650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        //button just for debugging
        JButton testbutton = new JButton();
        testbutton.setPreferredSize(new Dimension(200,50));
        add(testbutton);

        setVisible(true);
    }
}
