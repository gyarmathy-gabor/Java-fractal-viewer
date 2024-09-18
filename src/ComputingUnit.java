import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ComputingUnit {

    //Basic values
    final int MAX_ITERATIONS = 25;
    private final double ESCAPE_RADIUS = 2;
    private Dimension canvasDim =new Dimension(900,600);

    //X borders
    private double minX = -2;
    private double maxX = 1;

    //Y borders
    private double minY = -1;
    private double maxY = 1;

    //List of pixels
    private List<Pixel> pixels;

    public ComputingUnit() {
        pixels = new ArrayList<Pixel>();
    }


    public void calculateMandelbrot(){      //TODO: Make julia set to and then as an ENUM make it so that you can switch and calculate that instead

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

    public int getMaxIterations() {
        return MAX_ITERATIONS;
    }

}
