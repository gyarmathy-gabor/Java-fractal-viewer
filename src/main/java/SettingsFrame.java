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
        //setSize(900,650); already implemented in Scene
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        headerPanel = new SettingsHeaderPanel(this);
        headerPanel.setBounds(0,0,900,50);
        parametersPanel = new ParametersPanel(); parametersPanel.setBounds(450,50,450,600);
        setsPanel = new FractalChoicePanel(); setsPanel.setBounds(0,350,450,300);
        colormapsPanel = new ColormapPanel(); colormapsPanel.setBounds(0,50,450,300);

        add(headerPanel);
        add(parametersPanel);
        add(setsPanel);
        add(colormapsPanel);






        setVisible(true);
    }
}
