package ui.settings.panel;

import javax.swing.*;

/**
 * A base class for creating panels in the settings section of the application.
 * This class provides a common layout configuration and size settings
 * for panels that are part of the settings interface. It uses manual layout
 * management with absolute positioning.
 */
public class SettingPanel extends JPanel {

    /**
     * Constructor for the SettingPanel.
     * Initializes the panel with a null layout (manual layout) and sets the default size.
     */
    public SettingPanel(){
        setLayout(null); //manual layout
        setSize(450,100);
    }
}
