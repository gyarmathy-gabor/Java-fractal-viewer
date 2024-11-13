package ui.settings.frame;

import ui.Scene;
import ui.menu.MenuFrame;
import ui.settings.panel.ColormapPanel;
import ui.settings.panel.FractalChoicePanel;
import ui.settings.panel.ParametersPanel;
import ui.settings.panel.SettingsHeaderPanel;

import javax.swing.*;

/**
 * Represents the settings frame of the application. This frame allows users to
 * adjust various settings for the fractal visualization, including fractal type,
 * parameters, and colormap. It provides a layout with panels for these settings.
 */
public class SettingsFrame extends Scene {
    // Settings panels:
    private SettingsHeaderPanel headerPanel;
    private ParametersPanel parametersPanel;
    private FractalChoicePanel setsPanel;
    private ColormapPanel colormapsPanel;

    /**
     * Constructs a new settings frame.
     *
     * @param mainMenu The main menu frame, which will be shown again when the settings frame is disposed.
     */
    public SettingsFrame(MenuFrame mainMenu){
        super(mainMenu);

        setTitle("Settings");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        headerPanel = new SettingsHeaderPanel(this);
        headerPanel.setBounds(0,0,900,50);
        parametersPanel = new ParametersPanel(); parametersPanel.setBounds(0,300,450,600);
        setsPanel = new FractalChoicePanel(); setsPanel.setBounds(0,150,450,300);
        colormapsPanel = new ColormapPanel(); colormapsPanel.setBounds(0,50,450,300);

        //Add panels to the frame
        add(headerPanel);
        add(parametersPanel);
        add(setsPanel);
        add(colormapsPanel);

        setVisible(true);
    }

    /**
     * Gets the parameters panel for adjusting the fractal parameters(Escape radius and Max-iterations).
     *
     * @return The panel where the user can adjust the parameters.
     */
    public ParametersPanel getParametersPanel(){
        return parametersPanel;
    }

    /**
     * Gets the fractal choice panel for selecting the fractal type.
     *
     * @return The panel where the user can choose the fractal type.
     */
    public FractalChoicePanel getSetsPanel() {
        return setsPanel;
    }

    /**
     * Gets the colormap panel for selecting the color map for the fractal visualization.
     *
     * @return The panel where the user can select the color map.
     */
    public ColormapPanel getColormapsPanel(){
        return colormapsPanel;
    }
}
