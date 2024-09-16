import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MandelbrotCalculator {

    //Basic values
    static final int MAX_ITERATIONS = 25;
    static final double ESCAPE_RADIUS = 2;
    static Dimension canvasDim =new Dimension(900,600);

    //X borders
    static double minX = -2;
    static double maxX = 1;

    //Y borders
    static double minY = -1;
    static double maxY = 1;

    //List of pixels
    private List<Pixel> pixels;

    public MandelbrotCalculator() {
        pixels = new ArrayList<Pixel>();
    }


    public void calculateMandelbrot(){

        double dX = Math.abs(maxX-minX);
        double dY = Math.abs(maxY-minY);

        //Calculate the steps you take between each rendered pixel
        double stepX = dX/canvasDim.getWidth();
        double stepY = dY/canvasDim.getHeight();


        for(int x=0;x<canvasDim.width;x++){
            for(int y=0;y<canvasDim.height;y++){
                 double coordX = minX + x*stepX;
                 double coordY = minY + y*stepY;
                 PixelFactory(coordX,coordY,x,y);
            }
        }
    }

    private void PixelFactory(double x,double y,int widthCoord,int heightCoord){
        Complex c = new Complex(x,y);
        Complex z = new Complex(0,0);
        int iteration = 0;
        for(;iteration<MAX_ITERATIONS;iteration++){
            z = Equation(c,z);
            if(z.radius()>ESCAPE_RADIUS){
                break;
            }
        }
        pixels.add(new Pixel(c,iteration,widthCoord,heightCoord));
    }

    private Complex Equation(Complex c,Complex z){
        return z.square().add(c);
    }

    public List<Pixel> getPixels() {
        return pixels;
    }

    public static int getMaxIterations() {
        return MAX_ITERATIONS;
    }

}
