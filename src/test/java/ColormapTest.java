import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.profile.Colormap;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ColormapTest {

    Colormap colormap1;
    Colormap colormap2;
    Colormap colormap3;


    @BeforeEach
    public void setUp(){
        colormap1 = new Colormap("colormap1", List.of(Color.black, Color.white));
        colormap2 = new Colormap("colormap2", List.of(Color.black, Color.white, Color.orange));
        colormap1 = new Colormap("colormap1", List.of(Color.black, Color.white, Color.cyan));
    }

    @Test
    public void testConstructors(){

        List<String> hexColorList = List.of("#4A90E2","#F5A623","#7ED321");
        Colormap colormap4 = new Colormap("testmap1",hexColorList.toArray(new String[0]));

        List<Color> colorList = new ArrayList<>();
        String[] hexColors = {"#4A90E2", "#F5A623", "#7ED321"};
        for (String hex : hexColors) {
            colorList.add(Color.decode(hex));
        }

        Colormap colormap5 = new Colormap("testmap2",colorList);


        // Get the colors from both colormap objects
        List<Color> colors1 = colormap4.getColors();
        List<Color> colors2 = colormap5.getColors();


        assertEquals(colors1.size(), colors2.size(),"Both colormaps should have the same colors.");

        // Check if each corresponding color is the same in both lists
        for (int i = 0; i < colors1.size(); i++) {
            assertEquals(colors1.get(i), colors2.get(i),"Color at index " + i + " should be the same.");
        }


    }

}
