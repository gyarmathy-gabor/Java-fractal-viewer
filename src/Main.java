public class Main {
    public static void main(String[] args) {
        MandelbrotCalculator computer = new MandelbrotCalculator();
        computer.calculateMandelbrot();
        /*
        MandelbrotFrame frame = new MandelbrotFrame();
        frame.updateCanvas(computer.getPixels());*/

        MainMenu menu = new MainMenu();
    }
}