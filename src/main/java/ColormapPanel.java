import javax.swing.*;
import java.util.List;

public class ColormapPanel extends SettingPanel {
    private List<Colormap> colormaps;

    public ColormapPanel(){
        super();
        colormaps = FileUtils.readColormaps("/home/gyari/IdeaProjects/Prog3_NHF/src/main/resources/colormaps.json");

        String[] names = new String[colormaps.size()];
        for(int i=0;i<colormaps.size();i++){
            names[i] = colormaps.get(i).getName();
        }

        JComboBox<String> maps = new JComboBox<>(names);
        maps.setBounds(200,200,150,30);
        add(maps);
    }
}
