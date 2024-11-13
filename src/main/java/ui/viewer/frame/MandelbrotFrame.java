package ui.viewer.frame;

import model.fractal.ComputingUnit;
import model.fractal.Pixel;
import model.profile.Profile;
import ui.Scene;
import ui.menu.MenuFrame;
import ui.viewer.panel.CanvasPanel;
import ui.viewer.panel.ViewerHeaderPanel;
import util.FileUtils;
import ui.menu.MenuFrame;

import javax.swing.*;
import java.util.List;


/**
 * The {@code MandelbrotFrame} class represents the main frame of the Mandelbrot set viewer application.
 * It extends the {@link Scene} class and provides functionality for displaying the Mandelbrot fractal,
 * zooming in/out, and panning the fractal view.
 *
 * It uses the selected {@link Profile} to initialize the {@link ComputingUnit} which calculates the
 * Mandelbrot fractal and its pixels to be displayed on the {@link CanvasPanel}.
 *
 * <p>This frame allows interaction by zooming in, zooming out, and moving in all four directions
 * within the fractal view. It also provides a header with controls and displays the fractal on the canvas.</p>
 *
 * @see Scene
 * @see ComputingUnit
 * @see CanvasPanel
 * @see ViewerHeaderPanel
 * @see Profile
 */
public class MandelbrotFrame extends Scene {
    private ViewerHeaderPanel headerPanel;
    private CanvasPanel canvasPanel;
    private ComputingUnit computer;


    /**
     * Constructs a new {@code MandelbrotFrame} with the specified main menu.
     * It initializes the computing unit based on the selected profile and sets up
     * the frame's components (header, canvas, etc.).
     *
     * @param mainMenu The main menu frame that this viewer frame is linked to
     */
    public MandelbrotFrame(MenuFrame mainMenu){
        super(mainMenu);

        //Get chosen profile for computing unit
        Profile choosenProfile = FileUtils.getChoosenProfile();


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

    /**
     * Updates the canvas with the new list of pixels calculated by the {@link ComputingUnit}.
     *
     * @param pixels The list of pixels representing the Mandelbrot fractal
     */
    public void updateCanvas(List<Pixel> pixels) {
        canvasPanel.setPixels(pixels);
    }

    /**
     * Moves the fractal view upwards.
     * Connects the computer with the canvas
     */
    public void moveToUp(){
        computer.moveUpwards();
        updateCanvas(computer.getPixels());
    }

    /**
     * Moves the fractal view downwards.
     * Connects the computer with the canvas
     */
    public void moveToDown(){
        computer.moveDownwards();
        updateCanvas(computer.getPixels());
    }

    /**
     * Moves the fractal view to the left.
     * Connects the computer with the canvas
     */
    public void moveToLeft(){
        computer.moveLeftwards();
        updateCanvas(computer.getPixels());
    }

    /**
     * Moves the fractal view to the right.
     * Connects the computer with the canvas
     */
    public void moveToRight(){
        computer.moveRightwards();
        updateCanvas(computer.getPixels());
    }

    /**
     * Zooms in on the fractal view.
     * Connects the computer with the canvas
     */
    public void zoomToIn(){
        computer.zoomIn();
        updateCanvas(computer.getPixels());
    }

    /**
     * Zooms out of the fractal view.
     * Connects the computer with the canvas
     */
    public void zoomToOut(){
        computer.zoomOut();
        updateCanvas(computer.getPixels());
    }


}
