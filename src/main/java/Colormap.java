import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Colormap {
    private String name;
    private List<Color> colors;

    public Colormap(String name,String[] hexcolors){
        this.name = name;

        colors = new ArrayList<Color>();
        for(String hex : hexcolors){
            colors.add(Color.decode(hex));
        }
    }

    public List<Color> getColors() {
        return colors;
    }

    public String getName() {
        return name;
    }
}
