package ui.settings.frame;

import ui.Scene;
import ui.menu.MenuFrame;
import ui.settings.panel.ColormapPanel;
import ui.settings.panel.FractalChoicePanel;
import ui.settings.panel.ParametersPanel;
import ui.settings.panel.SettingsHeaderPanel;

import javax.swing.*;


public class SettingsFrame extends Scene {

    //Reference to main menu, so it can get back into it:
    //JFrame mainMenu;


    //Settings panels:
    private SettingsHeaderPanel headerPanel;
    private ParametersPanel parametersPanel;
    private FractalChoicePanel setsPanel;
    private ColormapPanel colormapsPanel;


    public SettingsFrame(MenuFrame mainMenu){
        super(mainMenu);
        //this.mainMenu = mainMenu;

        setTitle("Settings");
        //setSize(900,650); already implemented in ui.Scene
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        headerPanel = new SettingsHeaderPanel(this);
        headerPanel.setBounds(0,0,900,50);
        parametersPanel = new ParametersPanel(); parametersPanel.setBounds(0,300,450,600);
        setsPanel = new FractalChoicePanel(); setsPanel.setBounds(0,150,450,300);
        colormapsPanel = new ColormapPanel(); colormapsPanel.setBounds(0,50,450,300);

        add(headerPanel);
        add(parametersPanel);
        add(setsPanel);
        add(colormapsPanel);

        setVisible(true);
    }

    public ParametersPanel getParametersPanel(){
        return parametersPanel;
    }

    public FractalChoicePanel getSetsPanel() {
        return setsPanel;
    }

    public ColormapPanel getColormapsPanel(){
        return colormapsPanel;
    }
}
