import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CanvasPanel extends JPanel {
    private int MAX_ITER;
    private List<Pixel> pixels;
    private Colormap colormap;

    public CanvasPanel(int iterationsMax,Colormap colormap){
        this.setPreferredSize(new Dimension(900,600));
        this.MAX_ITER = iterationsMax;
        this.colormap = colormap;
    }

    public void setPixels(List<Pixel> pixels) {
        this.pixels = pixels;
        revalidate();
        repaint();
    }

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

    public Color setColor(int pixelEscapeTime){
        double normalizedEscapeTime = ((double) pixelEscapeTime / MAX_ITER) * (colormap.getSize() - 1);
        int index1 = (int) normalizedEscapeTime;
        int index2 = Math.min(index1 + 1, colormap.getColors().size() - 1);
        double t = normalizedEscapeTime - index1;

        return interpolate(colormap.getColors().get(index1),colormap.getColors().get(index2),t);

    }

    public Color interpolate(Color A, Color B, double t){
        int red = (int)((1 - t) * A.getRed() + t * B.getRed());
        int green = (int)((1 - t) * A.getGreen() + t * B.getGreen());
        int blue = (int)((1 - t) * A.getBlue() + t * B.getBlue());

        return new Color(red, green, blue);
    }
}
