package model.fractal;

import model.profile.Profile;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The {@code ComputingUnit} class is responsible for computing fractal images based on the chosen fractal type
 * (Mandelbrot, Julia, or Burning Ship) and the given parameters from the {@code Profile}.
 * It computes and stores the pixel values representing the fractal image within a defined canvas size.
 */
public class ComputingUnit {

    //Basic values
    Profile profile; //Contains max-iter and escape-radius and choosen fractal type
    private final Dimension canvasDim =new Dimension(900,600);

    //X borders
    private double minX = -2;
    private double maxX = 1;

    //Y borders
    private double minY = -1;
    private double maxY = 1;

    //List of pixels
    private List<Pixel> pixels;


    /**
     * Constructs a {@code ComputingUnit} with the specified {@code Profile}.
     *
     * @param profile the profile containing the fractal configuration (e.g., max iterations, escape radius, fractal type)
     */
    public ComputingUnit(Profile profile) {
        pixels = new ArrayList<Pixel>();
        this.profile = profile;
    }

    /**
     * Calculates the fractal based on the profile's configuration and stores the resulting pixels.
     * This method iterates over the canvas dimensions and calculates the corresponding pixel values
     * for the selected fractal type (Mandelbrot, Julia, or Burning Ship).
     */
    public void calculateFractal(){

        //borders of the plane we're looking at, and taking their distance
        double dX = Math.abs(maxX-minX);
        double dY = Math.abs(maxY-minY);

        //Calculate the size of steps you take between each rendered pixel
        double stepX = dX/canvasDim.getWidth();
        double stepY = dY/canvasDim.getHeight();


        for(int x=0;x<canvasDim.width;x++){
            for(int y=0;y<canvasDim.height;y++){
                 double coordX = minX + x*stepX;
                 double coordY = minY + y*stepY;
                 if(profile.getFractalType()== Fractal.MANDELBROT){
                     MandelbrotPixelFactory(coordX,coordY,x,y);
                 }
                 else if(profile.getFractalType()== Fractal.JULIA){
                     JuliaPixelFactory(coordX,coordY,x,y);
                 }
                 else if(profile.getFractalType()== Fractal.BURNING_SHIP){
                     BurningShipPixelFactory(coordX,coordY,x,y);
                 }
                 else{
                     MandelbrotPixelFactory(coordX,coordY,x,y); //in case something happens
                 }
            }
        }
    }

    /**
     * Creates pixels for the Mandelbrot fractal based on the given coordinates.
     *
     * @param x the x-coordinate in the fractal plane
     * @param y the y-coordinate in the fractal plane
     * @param widthCoord the x-coordinate on the canvas
     * @param heightCoord the y-coordinate on the canvas
     */
    private void MandelbrotPixelFactory(double x, double y, int widthCoord, int heightCoord){
        Complex c = new Complex(x,y);
        Complex z = new Complex(0,0);
        int iteration = 0;
        for(;iteration<profile.getMaxIter();iteration++){

            z = Equation(c,z);

            if(z.radius()>profile.getEscapeRadius()){
                break;
            }
        }
        pixels.add(new Pixel(c,iteration,widthCoord,heightCoord));
    }


    /**
     * Creates pixels for the Julia fractal based on the given coordinates.
     *
     * @param x the x-coordinate in the fractal plane
     * @param y the y-coordinate in the fractal plane
     * @param widthCoord the x-coordinate on the canvas
     * @param heightCoord the y-coordinate on the canvas
     */
    private void JuliaPixelFactory(double x, double y, int widthCoord, int heightCoord){
        Complex c = new Complex(-0.7,0.27015); //IN JULIA SET THIS IS CONSTANT, you should probably make a settings part for this
        Complex z = new Complex(x,y);
        int iteration = 0;
        for(;iteration< profile.getMaxIter();iteration++){
            z = Equation(c,z);
            if(z.radius()>profile.getEscapeRadius()){
                break;
            }
        }
        pixels.add(new Pixel(c,iteration,widthCoord,heightCoord));

    }

    /**
     * Creates pixels for the Burning Ship fractal based on the given coordinates.
     *
     * @param x the x-coordinate in the fractal plane
     * @param y the y-coordinate in the fractal plane
     * @param widthCoord the x-coordinate on the canvas
     * @param heightCoord the y-coordinate on the canvas
     */
    private void BurningShipPixelFactory(double x, double y, int widthCoord, int heightCoord){
        Complex c = new Complex(x,y);
        Complex z = new Complex(0,0); //maybe 0.355 0.355
        int iteration = 0;
        for(;iteration< profile.getMaxIter();iteration++){
            double realPart = Math.abs(z.getReal());
            double imaginaryPart = Math.abs(z.getImaginary());
            z = new Complex(realPart,imaginaryPart).square().add(c);
            if(z.radius()> profile.getEscapeRadius()){
                break;
            }
        }
        pixels.add(new Pixel(c,iteration,widthCoord,heightCoord));
    }

    /**
     * Common equation used in both Mandelbrot and Julia sets.
     *
     * @param c the complex constant
     * @param z the current complex number in the iteration
     * @return the result of z^2 + c
     */
    private Complex Equation(Complex c, Complex z){
        return z.square().add(c);
    }

    /**
     * Returns the list of pixels representing the computed fractal.
     *
     * @return the list of pixels
     */
    public List<Pixel> getPixels() {
        return pixels;
    }

    /**
     * Returns the maximum number of iterations for the fractal computation.
     *
     * @return the maximum number of iterations
     */
    public int getMaxIterations() {
        return profile.getMaxIter();
    }


    /**
     * Moves the fractal view upwards by 10% of the current Y range and recalculates the fractal.
     */
    public void moveUpwards(){
        double dY = Math.abs(maxY-minY);
        double d = dY * 0.1;
        maxY -= d;
        minY -= d;
        calculateFractal();
    }


    /**
     * Moves the fractal view downwards by 10% of the current Y range and recalculates the fractal.
     */
    public void moveDownwards(){
        double dY = Math.abs(maxY-minY);
        double d = dY * 0.1;
        maxY += d;
        minY += d;
        calculateFractal();
    }

    /**
     * Moves the fractal view to the left by 10% of the current X range and recalculates the fractal.
     */
    public void moveLeftwards(){
        double dX = Math.abs(maxX-minX);
        double d = dX * 0.1;
        maxX -= d;
        minX -= d;
        calculateFractal();
    }

    /**
     * Moves the fractal view to the right by 10% of the current X range and recalculates the fractal.
     */
    public void moveRightwards(){
        double dX = Math.abs(maxX-minX);
        double d = dX * 0.1;
        maxX += d;
        minX += d;
        calculateFractal();
    }

    /**
     * Zooms in on the fractal view by a factor of 1.2 and recalculates the fractal.
     */
    public void zoomIn() {
        double zoomRate = 1.2;

        double centerX = (minX + maxX) / 2.0;
        double centerY = (minY + maxY) / 2.0;

        double rangeX = Math.abs(maxX - minX) / zoomRate;
        double rangeY = Math.abs(maxY - minY) / zoomRate;

        minX = centerX - rangeX / 2.0;
        maxX = centerX + rangeX / 2.0;

        minY = centerY - rangeY / 2.0;
        maxY = centerY + rangeY / 2.0;

        calculateFractal();
    }


    /**
     * Zooms out of the fractal view by a factor of 1.2 and recalculates the fractal.
     */
    public void zoomOut() {
        double zoomRate = 1.2;

        double centerX = (minX + maxX) / 2.0;
        double centerY = (minY + maxY) / 2.0;

        double rangeX = Math.abs(maxX - minX) * zoomRate;
        double rangeY = Math.abs(maxY - minY) * zoomRate;

        minX = centerX - rangeX / 2.0;
        maxX = centerX + rangeX / 2.0;

        minY = centerY - rangeY / 2.0;
        maxY = centerY + rangeY / 2.0;

        calculateFractal();
    }


    public double getMinX() {
        return minX;
    }

    public double getMaxX() {
        return maxX;
    }

    public double getMinY() {
        return minY;
    }

    public double getMaxY() {
        return maxY;
    }
}
