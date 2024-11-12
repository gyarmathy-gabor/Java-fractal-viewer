package ui.settings.panel;

import model.profile.Colormap;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ColormapDisplayPanel extends JPanel {
    private Colormap colormap;

    public void setColormap(Colormap colormap){
        this.colormap = colormap;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        if(colormap == null){return;}


        List<Color> colors = colormap.getColors();
        int rectWidth = getWidth() / colors.size();
        int rectHeight = getHeight();

        for(int i=0;i<colors.size();i++){
            g.setColor(colors.get(i));
            g.fillRect(i*rectWidth,0,rectWidth,rectHeight);
        }


    }

}
