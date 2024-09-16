
public class Pixel {
    private final Complex coordinate;
    private final int outStoodIterations;

    private int displayX;
    private int displayY;


    Pixel(Complex c,int iter,int displayX,int displayY){
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
