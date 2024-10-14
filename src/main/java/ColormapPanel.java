import javax.swing.*;


public class ColormapPanel extends SettingPanel {
    Colormap[] colormaps;

    JComboBox<String> maps;

    public ColormapPanel(){
        super();
        colormaps = FileUtils.readColormaps("src/main/resources/colormaps.json");

        maps = new JComboBox(colormaps);
        maps.setBounds(200,200,150,30);
        add(maps);
    }

    public Colormap getChosenColormap(){
        int idx = maps.getSelectedIndex();
        return colormaps[idx];
    }
}
