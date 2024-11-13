package ui.viewer.panel;

import model.fractal.Pixel;
import model.profile.Colormap;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * The {@code CanvasPanel} class is responsible for rendering the fractal image on a canvas
 * based on the pixel data and colormap. It extends {@link JPanel} and is used to display
 * the computed fractal pixels in a graphical window.
 * <p>
 * This class takes the pixel data representing the fractal and renders it pixel by pixel,
 * applying the colormap to each pixel's escape time value. The {@link #setColor(int)} method
 * is used to determine the color of each pixel based on the number of iterations before it escapes.
 * </p>
 *
 * @see Pixel
 * @see Colormap
 */
public class CanvasPanel extends JPanel {
    private int MAX_ITER;
    private List<Pixel> pixels;
    private Colormap colormap;

    /**
     * Constructor to initialize the canvas panel.
     *
     * @param iterationsMax the maximum number of iterations for the fractal calculation
     * @param colormap the colormap used to color the pixels
     */
    public CanvasPanel(int iterationsMax, Colormap colormap){
        this.setPreferredSize(new Dimension(900,600));
        this.MAX_ITER = iterationsMax;
        this.colormap = colormap;
    }

    /**
     * Sets the list of pixels to be displayed on the canvas.
     * This method triggers a revalidation and repainting of the panel.
     *
     * @param pixels the list of pixels representing the fractal
     */
    public void setPixels(List<Pixel> pixels) {
        this.pixels = pixels;
        revalidate();
        repaint();
    }

    /**
     * Paints the component by drawing each pixel on the canvas.
     * The color of each pixel is determined by its escape time,
     * using the colormap provided during initialization.
     *
     * @param g the {@link Graphics} object used for rendering the image
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);  // Clear the previous graphics

        if (pixels != null) {
            Graphics2D g2D = (Graphics2D) g;
            for (Pixel i : pixels) {
                g2D.setColor(setColor(i.getOutStoodIterations()));
                g2D.fillRect(i.getDisplayX(),i.getDisplayY(),1,1);
            }
        }
    }


    /**
     * Determines the color of a pixel based on its escape time.
     * The escape time is normalized and mapped to a color from the colormap.
     *
     * @param pixelEscapeTime the number of iterations before the pixel escapes
     * @return the color corresponding to the pixel's escape time
     */
    public Color setColor(int pixelEscapeTime){
        double normalizedEscapeTime = ((double) pixelEscapeTime / MAX_ITER) * (colormap.getSize() - 1);
        int index1 = (int) normalizedEscapeTime;
        int index2 = Math.min(index1 + 1, colormap.getColors().size() - 1);
        double t = normalizedEscapeTime - index1;

        return interpolate(colormap.getColors().get(index1),colormap.getColors().get(index2),t);

    }


    /**
     * Interpolates between two colors based on a parameter {@code t}.
     * This creates a smooth transition between the two colors.
     * This function can only shine greatly if the max amount of iteration is high.
     *
     * @param A the first color
     * @param B the second color
     * @param t the interpolation factor (between 0 and 1)
     * @return the resulting interpolated color
     */
    public Color interpolate(Color A, Color B, double t){
        int red = (int)((1 - t) * A.getRed() + t * B.getRed());
        int green = (int)((1 - t) * A.getGreen() + t * B.getGreen());
        int blue = (int)((1 - t) * A.getBlue() + t * B.getBlue());

        return new Color(red, green, blue);
    }
}
