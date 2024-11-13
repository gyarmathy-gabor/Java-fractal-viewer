package model.fractal;

/**
 * Represents a pixel in a fractal image. A pixel contains information about its position on the screen
 * as well as the fractal coordinates and the number of iterations it took before escaping to infinity.
 */
public class Pixel {


    private final Complex coordinate;       //Complex coordinates
    private final int outStoodIterations;   //Iterations outstood before shooting to infinity

    //The position of the pixel on the screen (canvas coordinates)
    private final int displayX;
    private final int displayY;


    /**
     * Constructs a new {@code Pixel} with the specified fractal coordinates, iteration count,
     * and display coordinates.
     *
     * @param c the complex number representing the pixel's coordinates in the fractal plane
     * @param iter the number of iterations the pixel survived before escaping to infinity
     * @param displayX the x-coordinate of the pixel on the screen (canvas)
     * @param displayY the y-coordinate of the pixel on the screen (canvas)
     */
    Pixel(Complex c, int iter, int displayX, int displayY){
        this.coordinate = c;
        this.outStoodIterations = iter;
        this.displayX = displayX;
        this.displayY = displayY;
    }

    /**
     * Returns the x-coordinate of the pixel on the screen (canvas).
     *
     * @return the x-coordinate of the pixel
     */
    public int getDisplayX() {
        return displayX;
    }

    /**
     * Returns the y-coordinate of the pixel on the screen (canvas).
     *
     * @return the y-coordinate of the pixel
     */
    public int getDisplayY() {
        return displayY;
    }

    /**
     * Returns the number of iterations the pixel survived before escaping to infinity.
     *
     * @return the number of iterations the pixel survived
     */
    public int getOutStoodIterations() {
        return outStoodIterations;
    }

    /**
     * Returns the complex number representing the pixel's coordinates in the fractal plane.
     *
     * @return the complex coordinate of the pixel
     */
    public Complex getCoordinate() {
        return coordinate;
    }

}
