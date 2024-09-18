import javax.swing.*;
import java.util.List;

public class MandelbrotFrame extends JFrame {
    private Canvas canvas;
    private ComputingUnit computer;

    public MandelbrotFrame(){

        //Logic
        computer = new ComputingUnit();
        computer.calculateMandelbrot();


        //Basic initialization
        setTitle("Mandelbrot set viewer");
        this.setSize(900,650);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null); //set the layout to manual

        //Adding canvas
        this.canvas = new Canvas();
        this.add(canvas);
        canvas.setBounds(0,50,900,600);

        this.setVisible(true);

        updateCanvas(computer.getPixels());
    }

    public void updateCanvas(List<Pixel> pixels) {
        canvas.setPixels(pixels);
        //canvas.repaint();
    }
}
