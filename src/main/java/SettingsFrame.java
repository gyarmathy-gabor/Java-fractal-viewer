import javax.swing.*;
import java.awt.*;


public class SettingsFrame extends Scene {

    //Reference to main menu, so it can get back into it:
    //JFrame mainMenu;


    //Settings panels: TODO:Back to menu button, confirming, profiles
    private HeaderPanel header;
    private ParametersPanel parameters;
    private FractalChoicePanel sets;
    private ColormapPanel colormaps;


    public SettingsFrame(JFrame mainMenu){
        super(mainMenu);
        //this.mainMenu = mainMenu;

        setTitle("Settings");
        //setSize(900,650); already implemented in Scene
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        header = new HeaderPanel(this);header.setBounds(0,0,900,50);
        parameters = new ParametersPanel(); parameters.setBounds(450,50,450,600);
        sets = new FractalChoicePanel(); sets.setBounds(0,350,450,300);
        colormaps = new ColormapPanel(); colormaps.setBounds(0,50,450,300);

        add(header);
        add(parameters);
        add(sets);
        add(colormaps);






        setVisible(true);
    }
}
