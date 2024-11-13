package ui.settings.panel;

import model.profile.Colormap;
import util.FileUtils;

import javax.swing.*;

/**
 * A panel that allows users to select and view different colormaps for the fractal rendering.
 * The user can choose a colormap from a dropdown (JComboBox) and see a graphical representation
 * of the selected colormap in a separate display panel.
 *
 * <p>This panel is part of the settings interface, enabling the user to adjust the visual appearance
 * of the fractal based on the selected color scheme.</p>
 */
public class ColormapPanel extends SettingPanel {
    Colormap[] colormaps;

    JComboBox<String> maps;
    ColormapDisplayPanel colorsOfMaps;

    /**
     * Constructor for the ColormapPanel.
     * This constructor initializes the JComboBox with available colormaps and sets up the
     * display panel to show a visual representation of the selected colormap.
     */
    public ColormapPanel(){
        super();
        colormaps = FileUtils.readColormaps("src/main/resources/colormaps.json");

        maps = new JComboBox(colormaps);
        JLabel currentColormap = new JLabel("model.profile.Colormap:");
        maps.setBounds(110,10,150,30);
        currentColormap.setBounds(10,10,100,30);




        colorsOfMaps = new ColormapDisplayPanel();
        colorsOfMaps.setBounds(10, 50, 400, 50);
        maps.addActionListener(e -> {
            int selectedIndex = maps.getSelectedIndex();
            colorsOfMaps.setColormap(colormaps[selectedIndex]);
        });

        add(maps);
        add(colorsOfMaps);
        add(currentColormap);
        colorsOfMaps.setColormap(colormaps[maps.getSelectedIndex()]);


    }

    /**
     * Returns the currently selected colormap.
     *
     * @return The selected {@link Colormap}.
     */
    public Colormap getChosenColormap(){
        int idx = maps.getSelectedIndex();
        return colormaps[idx];
    }


    /**
     * Sets the selected colormap in the JComboBox based on the given colormap.
     *
     * @param colormap The colormap to set as selected.
     */
    public void setMaps(Colormap colormap){
        int i;
        for(i=0;i<colormaps.length;i++){
            if(colormap.equals(colormaps[i])){
              break;
            }
        }
        maps.setSelectedIndex(i);
    }
}
