package model.fractal;

public class Pixel {


    private final Complex coordinate;       //model.fractal.Complex coordinates
    private final int outStoodIterations;   //Iterations outstood before shooting to infinity

    //On which pixel of the screen it should be rendered on.
    private final int displayX;
    private final int displayY;


    Pixel(Complex c, int iter, int displayX, int displayY){
        this.coordinate = c;
        this.outStoodIterations = iter;
        this.displayX = displayX;
        this.displayY = displayY;
    }

    public int getDisplayX() {
        return displayX;
    }

    public int getDisplayY() {
        return displayY;
    }

    public int getOutStoodIterations() {
        return outStoodIterations;
    }

    public Complex getCoordinate() {
        return coordinate;
    }

}
