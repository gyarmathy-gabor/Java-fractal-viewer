import model.fractal.Fractal;
import model.profile.Colormap;
import model.profile.Profile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProfileTest {
    Profile profile1;
    Profile profile2;
    Profile profile3;

    @BeforeEach
    public void setUp() {
        profile1 = new Profile(
                "Testprofil1",
                50,
                2,
                new Colormap("Testcolormap", List.of(Color.black, Color.white)),
                Fractal.MANDELBROT
        );

        profile2 = new Profile(
                "Testprofil2",
                50,
                2,
                new Colormap("Testcolormap", List.of(Color.black, Color.white)),
                Fractal.MANDELBROT
        );

        profile3 = new Profile(
                "Testprofil1",
                50,
                2,
                new Colormap("Testcolormap", List.of(Color.black, Color.white)),
                Fractal.MANDELBROT
        );


    }

    @Test
    public void testSetIsProfileInUse(){
        assertFalse(profile1.getProfileInUse());
        assertFalse(profile2.getProfileInUse());
        assertFalse(profile3.getProfileInUse());

        profile1.setIsProfileInUse(true);

        assertTrue(profile1.getProfileInUse());
        assertFalse(profile2.getProfileInUse());
        assertFalse(profile3.getProfileInUse());
    }

    @Test
    public void testHasSameName(){
        assertTrue(profile1.hasSameName(profile3));
    }



}
