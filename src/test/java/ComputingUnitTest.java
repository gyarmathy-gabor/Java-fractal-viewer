import model.fractal.Complex;
import model.fractal.ComputingUnit;
import model.fractal.Fractal;
import model.profile.Colormap;
import model.profile.Profile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class ComputingUnitTest {

    private Profile profile;
    private ComputingUnit computingUnit;

    double initialMinX;
    double initialMaxX;
    double initialMinY;
    double initialMaxY;

    @BeforeEach
    public void setUp(){
        profile = new Profile(
                "Testprofil",
                50,
                2,
                new Colormap("Testcolormap",List.of(Color.black,Color.white)),
                Fractal.MANDELBROT
        );

        computingUnit = new ComputingUnit(profile);

        initialMinX = computingUnit.getMinX();
        initialMaxX = computingUnit.getMaxX();
        initialMinY = computingUnit.getMinY();
        initialMaxY = computingUnit.getMaxY();
    }



    @Test
    public void testMandelbrotPixelFactory(){
        int size = computingUnit.getPixels().size();
        assertEquals(0, size, "Pixel-list should be empty before doing any calculation");

        computingUnit.calculateFractal();
        size = computingUnit.getPixels().size();

        assertNotNull(computingUnit.getPixels());
        assertTrue(size>0, "Pixel-list shouldn't be empty after doing any calculation");

    }

    @Test
    public void testJuliaPixelFactory(){
        profile.setFractalType(Fractal.JULIA);

        int size = computingUnit.getPixels().size();
        assertTrue(size == 0);

        computingUnit.calculateFractal();
        size = computingUnit.getPixels().size();

        assertNotNull(computingUnit.getPixels());
        assertTrue(size>0);
    }

    @Test
    public void testBurningShipPixelFactory(){
        profile.setFractalType(Fractal.BURNING_SHIP);

        int size = computingUnit.getPixels().size();
        assertEquals(0, size, "Pixel-list should be empty before doing any calculation");

        computingUnit.calculateFractal();
        size = computingUnit.getPixels().size();

        assertNotNull(computingUnit.getPixels(), "Pixel-list shouldn't be null after calculation");
        assertTrue(size>0,"Pixel-list shouldn't be empty after doing any calculation");
    }

    @Test
    public void testZoomIn(){
        assertTrue(computingUnit.getPixels().isEmpty(), "Pixel-list should be empty before doing any calculation");

        computingUnit.zoomIn();

        assertFalse(computingUnit.getPixels().isEmpty(), "Pixel-list shouldn't be empty after calculation");
        assertTrue(computingUnit.getMinX() > initialMinX, "MinX should increase");
        assertTrue(computingUnit.getMaxX() < initialMaxX, "MaxX should decrease");
        assertTrue(computingUnit.getMinY() > initialMinY, "MinY should increase");
        assertTrue(computingUnit.getMaxY() < initialMaxY, "MaxY should decrease");
    }

    @Test
    public void testZoomOut(){
        assertTrue(computingUnit.getPixels().isEmpty(), "Pixel-list should be empty before doing any calculation");

        computingUnit.zoomOut();

        assertFalse(computingUnit.getPixels().isEmpty(), "Pixel-list shouldn't be empty after calculation");
        assertTrue(computingUnit.getMinX() < initialMinX, "MinX should decrease");
        assertTrue(computingUnit.getMaxX() > initialMaxX, "MaxX should increase");
        assertTrue(computingUnit.getMinY() < initialMinY, "MinY should decrease");
        assertTrue(computingUnit.getMaxY() > initialMaxY, "MaxY should increase");
    }

   @Test
   public void testMoveUpwards(){
       assertTrue(computingUnit.getPixels().isEmpty(), "Pixel-list should be empty before doing any calculation");

       computingUnit.moveUpwards();

       assertFalse(computingUnit.getPixels().isEmpty(), "Pixel-list shouldn't be empty after calculation");
       assertEquals(computingUnit.getMinX(), initialMinX, "MinX should stay the same");
       assertEquals(computingUnit.getMaxX(), initialMaxX, "MaxX should stay the same");
       assertTrue(computingUnit.getMinY() < initialMinY, "MinY should decrease");
       assertTrue(computingUnit.getMaxY() < initialMaxY, "MaxY should decrease");
   }

   @Test
    public void testMoveDownwards(){
       assertTrue(computingUnit.getPixels().isEmpty(), "Pixel-list should be empty before doing any calculation");

       computingUnit.moveDownwards();

       assertFalse(computingUnit.getPixels().isEmpty(), "Pixel-list shouldn't be empty after calculation");
       assertEquals(computingUnit.getMinX(), initialMinX, "MinX should stay the same");
       assertEquals(computingUnit.getMaxX(), initialMaxX, "MaxX should stay the same");
       assertTrue(computingUnit.getMinY() > initialMinY, "MinY should increase");
       assertTrue(computingUnit.getMaxY() > initialMaxY, "MaxY should increase");
   }

   @Test
    public void testMoveLeftwards(){
       assertTrue(computingUnit.getPixels().isEmpty(), "Pixel-list should be empty before doing any calculation");

       computingUnit.moveLeftwards();

       assertFalse(computingUnit.getPixels().isEmpty(), "Pixel-list shouldn't be empty after calculation");
       assertEquals(computingUnit.getMinY(),initialMinY, "MinY should stay the same");
       assertEquals(computingUnit.getMaxY(), initialMaxY, "MaxY should stay the same");
       assertTrue(computingUnit.getMinX() < initialMinY, "MinX should decrease");
       assertTrue(computingUnit.getMaxX() < initialMaxY, "MaxX should decrease");
   }

   @Test
    public void testMoveRightwards(){
       assertTrue(computingUnit.getPixels().isEmpty(), "Pixel-list should be empty before doing any calculation");

       computingUnit.moveRightwards();

       assertFalse(computingUnit.getPixels().isEmpty(), "Pixel-list shouldn't be empty after calculation");
       assertEquals(computingUnit.getMinY(),initialMinY, "MinY should stay the same");
       assertEquals(computingUnit.getMaxY(), initialMaxY, "MaxY should stay the same");
       assertTrue(computingUnit.getMinX() > initialMinX, "MinX should increase");
       assertTrue(computingUnit.getMaxX() > initialMaxX, "MaxX should increase");
   }
}
