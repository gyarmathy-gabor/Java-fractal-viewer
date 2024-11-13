package model.profile;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a colormap used for visualizing fractals or other graphical data.
 * A colormap contains a name and a list of colors, which can be used to map
 * numerical data to colors.
 */
public class Colormap implements Serializable {
    private String name;
    private List<Color> colors;

    /**
     * Constructs a {@code Colormap} with the specified name and a list of color hex values.
     * The hex color codes are converted to {@code Color} objects.
     *
     * @param name the name of the colormap
     * @param hexcolors an array of color hex codes (e.g., "#FF5733")
     */
    public Colormap(String name,String[] hexcolors){
        this.name = name;

        colors = new ArrayList<Color>();
        for(String hex : hexcolors){
            colors.add(Color.decode(hex));
        }
    }

    /**
     * Constructs a {@code Colormap} with the specified name and a list of {@code Color} objects.
     *
     * @param name the name of the colormap
     * @param colorList a list of {@code Color} objects
     */
    public Colormap(String name,List<Color> colorList){
        this.name = name;
        colors = new ArrayList<>();
        for(Color i: colorList){
            colors.add(i);
        }
    }

    /**
     * Returns the list of colors in this colormap.
     *
     * @return the list of colors in the colormap
     */
    public List<Color> getColors() {
        return colors;
    }

    /**
     * Returns the name of this colormap.
     *
     * @return the name of the colormap
     */
    public String getName() {
        return name;
    }

    /**
     * Returns a string representation of the colormap, which is the name of the colormap.
     *
     * @return the name of the colormap
     */
    @Override
    public String toString(){
        return name;
    }

    /**
     * Compares this colormap to another colormap based on the name.
     *
     * @param other the other {@code Colormap} to compare with
     * @return {@code true} if the two colormaps have the same name, {@code false} otherwise
     */
    public Boolean equals(Colormap other){
        return this.name.equals(other.name);
    }

    /**
     * Returns the number of colors in this colormap.
     *
     * @return the size of the colormap (number of colors)
     */
    public int getSize(){
        return colors.size();
    }
}
