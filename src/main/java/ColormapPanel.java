import javax.swing.*;


public class ColormapPanel extends SettingPanel {
    Colormap[] colormaps;

    JComboBox<String> maps;
    ColormapDisplayPanel colorsOfMaps;


    JSplitPane Pane;

    public ColormapPanel(){
        super();
        colormaps = FileUtils.readColormaps("src/main/resources/colormaps.json");

        maps = new JComboBox(colormaps);
        JLabel currentColormap = new JLabel("Colormap:");
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

    public Colormap getChosenColormap(){
        int idx = maps.getSelectedIndex();
        return colormaps[idx];
    }

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
