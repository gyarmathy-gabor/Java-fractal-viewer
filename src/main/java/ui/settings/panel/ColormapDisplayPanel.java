package ui.settings.panel;

import model.profile.Colormap;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * A panel that displays a visual representation of a colormap by drawing colored rectangles
 * for each color in the colormap. The width of each rectangle is proportional to the number
 * of colors in the colormap, and the height spans the entire height of the panel.
 *
 * <p>This panel can be used in the settings or configuration screens to show the selected colormap
 * in a graphical way.</p>
 */
public class ColormapDisplayPanel extends JPanel {
    private Colormap colormap;

    /**
     * Sets the colormap to be displayed and triggers a repaint to update the panel.
     *
     * @param colormap The Colormap to display on the panel.
     */
    public void setColormap(Colormap colormap){
        this.colormap = colormap;
        repaint();
    }

    /**
     * Paints the component by drawing colored rectangles for each color in the colormap.
     * The width of each rectangle is calculated based on the number of colors in the colormap,
     * and the height spans the full height of the panel.
     *
     * @param g The Graphics context used for painting the component.
     */
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        if(colormap == null){return;}

        List<Color> colors = colormap.getColors();  // Get the list of colors in the colormap
        int rectWidth = getWidth() / colors.size(); // Calculate the width of each rectangle
        int rectHeight = getHeight(); // Calculate the width of each rectangle

        // Draw a colored rectangle for each color in the colormap
        for(int i=0;i<colors.size();i++){
            g.setColor(colors.get(i));
            g.fillRect(i*rectWidth,0,rectWidth,rectHeight);
        }
    }
}
