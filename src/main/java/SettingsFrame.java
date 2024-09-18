import javax.swing.*;
import java.awt.*;


public class SettingsFrame extends JFrame {
    //Settings panels: TODO:Back to menu button, confirming, profiles
    private ParametersPanel parameters;
    private FractalChoicePanel sets;
    private ColormapPanel colormaps;


    public SettingsFrame(){
        setTitle("Settings");
        setSize(900,650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        parameters = new ParametersPanel(); parameters.setBounds(450,50,450,600);
        sets = new FractalChoicePanel(); sets.setBounds(0,350,450,300);
        colormaps = new ColormapPanel(); colormaps.setBounds(0,50,450,300);

        add(parameters);
        add(sets);
        add(colormaps);






        setVisible(true);
    }
}
