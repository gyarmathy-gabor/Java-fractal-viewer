import javax.swing.*;
import java.util.List;

public class ColormapPanel extends SettingPanel {
    //private List<Colormap> colormaps;
    Colormap colormaps[];

    public ColormapPanel(){
        super();
       // colormaps = FileUtils.readColormaps("/home/gyari/IdeaProjects/Prog3_NHF/src/main/resources/colormaps.json");
        colormaps = FileUtils.readColormaps("src/main/resources/colormaps.json");

        JComboBox<String> maps = new JComboBox(colormaps);
        maps.setBounds(200,200,150,30);
        add(maps);
    }
}
