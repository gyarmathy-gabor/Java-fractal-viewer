import javax.swing.*;
import java.util.List;

public class MandelbrotFrame extends Scene {
    private ViewerHeaderPanel headerPanel;
    private CanvasPanel canvasPanel;
    private ComputingUnit computer;



    public MandelbrotFrame(MenuFrame mainMenu){
        super(mainMenu);

        //Get choosen profile for computing unit
        Profile choosenProfile =FileUtils.getChoosenProfile();


        //Logic
        computer = new ComputingUnit(choosenProfile);
        computer.calculateFractal();


        //Basic initialization
        setTitle("Mandelbrot set viewer");
        this.setSize(900,650);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null); //set the layout to manual
        setLocationRelativeTo(null);

        //Adding header
        headerPanel = new ViewerHeaderPanel(this,choosenProfile);
        headerPanel.setBounds(0,0,900,50);
        add(headerPanel);


        //Adding canvas
        this.canvasPanel = new CanvasPanel(choosenProfile.getMaxIter(),choosenProfile.getColormap());
        this.add(canvasPanel);
        canvasPanel.setBounds(0,50,900,600);

        this.setVisible(true);

        updateCanvas(computer.getPixels());
    }

    public void updateCanvas(List<Pixel> pixels) {
        canvasPanel.setPixels(pixels);
        //canvas.repaint();
    }
}
