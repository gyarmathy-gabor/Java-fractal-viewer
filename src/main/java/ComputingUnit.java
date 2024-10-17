import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class ComputingUnit {
    //ParentFrame(for animations)[we're casting it later]
    Scene scene;


    //Basic values
    Profile profile; //Contains max-iter and escape-radius and choosen fractal type
    private final Dimension canvasDim =new Dimension(900,600);

    //X borders
    private final double minX = -2;
    private final double maxX = 1;

    //Y borders
    private final double minY = -1;
    private final double maxY = 1;

    //List of pixels
    private List<Pixel> pixels;

    public ComputingUnit(Profile profile) {
        pixels = new ArrayList<Pixel>();
        this.profile = profile;
        scene = null;
    }

    //Constructor in case of animations
    public ComputingUnit(Profile profile,Scene scene){
        pixels = new ArrayList<Pixel>();
        this.profile = profile;
        this.scene = scene;
    }


    public void calculateFractal(){  //hey

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
                 if(profile.getFractalType()==Fractal.MANDELBROT){
                     MandelbrotPixelFactory(coordX,coordY,x,y);
                 }
                 else if(profile.getFractalType()==Fractal.JULIA){
                     JuliaPixelFactory(coordX,coordY,x,y,-0.7,0.27015); //these should be inside options
                 }
                 else if(profile.getFractalType()==Fractal.BURNING_SHIP){
                     BurningShipPixelFactory(coordX,coordY,x,y);
                 }
                 else{
                     MandelbrotPixelFactory(coordX,coordY,x,y); //in case something happens
                 }
            }
        }
    }

    public void animateJuliaSets(){
        //borders of the plane we're looking at, and taking their distance
        double dX = Math.abs(maxX-minX);
        double dY = Math.abs(maxY-minY);

        //Calculate the size of steps you take between each rendered pixel
        double stepX = dX/canvasDim.getWidth();
        double stepY = dY/canvasDim.getHeight();

        //Getting animationframe
        AnimationFrame frame = (AnimationFrame) scene;


        for(double a=0;a< Math.PI;a=a+0.1){
            Complex temp = Complex.fromPolar(a,0.7885); //a=0->2Pi and magnitude=0.7885

            for(int x=0;x<canvasDim.width;x++) {
                for (int y = 0; y < canvasDim.height; y++) {
                    double coordX = minX + x * stepX;
                    double coordY = minY + y * stepY;
                    JuliaPixelFactory(coordX,coordY,x,y,temp.getReal(),temp.getImaginary());
                }
            }

            frame.updateCanvas(pixels);   // Update the canvas with the new pixel data

        }

    }

    //Mandelbrot pixelfactory
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

    //Julia pixelfactory
    private void JuliaPixelFactory(double x, double y, int widthCoord, int heightCoord,double realC, double imagC ){
        Complex c = new Complex(realC,imagC); //IN JULIA SET THIS IS CONSTANT, you should probably make a settings part for this
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





    //This is the same for both mandelbrot and julia equations
    private Complex Equation(Complex c,Complex z){
        return z.square().add(c);
    }

    public List<Pixel> getPixels() {
        return pixels;
    }

    public int getMaxIterations() {
        return profile.getMaxIter();
    }

}
