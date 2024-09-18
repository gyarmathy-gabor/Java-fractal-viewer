import javax.swing.*;
import java.util.List;

public class MandelbrotFrame extends JFrame {
    private Canvas canvas;

    public MandelbrotFrame(){
        setTitle("Mandelbrot set viewer");
        //Basic initialization
        this.setSize(900,650);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null); //set the layout to manual

        //Adding canvas
        this.canvas = new Canvas();
        this.add(canvas);
        canvas.setBounds(0,50,900,600);

        this.setVisible(true);
    }

    public void updateCanvas(List<Pixel> pixels) {
        canvas.setPixels(pixels);
        //canvas.repaint();
    }
}
