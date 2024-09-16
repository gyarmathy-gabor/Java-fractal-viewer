import javax.swing.*;

public class MandelbrotFrame extends JFrame {
    public MandelbrotFrame(){
        //Basic initialization
        this.setSize(800,800);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null); //set the layout to manual

        //Adding canvas
        Canvas canvas = new Canvas();
        this.add(canvas);
        canvas.setBounds(0,50,800,750);


        this.setVisible(true);
    }
}
