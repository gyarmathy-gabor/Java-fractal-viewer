import javax.swing.*;

public class MandelbrotFrame extends JFrame {
    public MandelbrotFrame(){
        this.setSize(800,800);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Adding canvas
        Canvas canvas = new Canvas();
        this.add(canvas);

        this.setVisible(true);
    }
}
