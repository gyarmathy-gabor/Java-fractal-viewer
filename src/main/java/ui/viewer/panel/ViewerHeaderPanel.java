package ui.viewer.panel;

import model.profile.Profile;
import ui.HeaderPanel;
import ui.viewer.frame.MandelbrotFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The {@code ViewerHeaderPanel} class represents the header panel displayed at the top of the
 * Mandelbrot fractal viewer window. It provides buttons to control the view, such as zooming in and out,
 * and moving the view in different directions (up, down, left, right). It also displays information about
 * the current profile being used for the fractal computation.
 * <p>
 * This class extends {@link HeaderPanel} and is used to manage user input for interacting with the
 * Mandelbrot fractal visualization.
 * </p>
 *
 * @see MandelbrotFrame
 * @see Profile
 * @see HeaderPanel
 */
public class ViewerHeaderPanel extends HeaderPanel {
    private Profile profile;
    JLabel informations;

    JButton up;
    JButton down;
    JButton right;
    JButton left;
    JButton zoomIn;
    JButton zoomOut;

    /**
     * Constructs a new {@code ViewerHeaderPanel}.
     * Initializes the panel with buttons for controlling the fractal view, as well as displaying
     * the current profile information.
     *
     * @param parentFrame the parent {@link JFrame} which holds this header panel
     * @param profile the {@link Profile} containing the settings for the fractal rendering
     */
    public ViewerHeaderPanel(JFrame parentFrame, Profile profile){
        super(parentFrame);
        this.profile = profile;

        if(profile!=null){
            String toInformations=new String(
                    "Informations: "
                            + profile.getName() + " -> "
                            + profile.getColormap().getName() + " + "
                            + profile.getFractalType().toString() + " + "
                            + profile.getMaxIter() + " + "
                            + profile.getEscapeRadius());
            informations = new JLabel(toInformations);
            informations.setBounds(110,0,500,50);
            add(informations);
        }

        zoomIn = new JButton("In");
        zoomIn.setSize(60,25);
        zoomIn.setBounds(840,0,60,25);
        this.add(zoomIn);

        zoomOut = new JButton("Out");
        zoomOut.setSize(60,25);
        zoomOut.setBounds(840,25,60,25);
        this.add(zoomOut);

        up = new JButton("↑");
        up.setSize(50,50);
        up.setBounds(640,0,50,50);
        this.add(up);

        down = new JButton("↓");
        down.setSize(50,50);
        down.setBounds(690,0,50,50);
        this.add(down);

        left = new JButton("←");
        left.setSize(50,50);
        left.setBounds(740,0,50,50);
        this.add(left);

        right = new JButton("→");
        right.setSize(50,50);
        right.setBounds(790,0,50,50);
        this.add(right);


        up.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MandelbrotFrame parent = (MandelbrotFrame) parentFrame;
                parent.moveToUp();
            }
        });

        down.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MandelbrotFrame parent = (MandelbrotFrame) parentFrame;
                parent.moveToDown();
            }
        });

        right.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MandelbrotFrame parent = (MandelbrotFrame) parentFrame;
                parent.moveToRight();
            }
        });

        left.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MandelbrotFrame parent = (MandelbrotFrame) parentFrame;
                parent.moveToLeft();
            }
        });

        zoomIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MandelbrotFrame parent = (MandelbrotFrame) parentFrame;
                parent.zoomToIn();
            }
        });


        zoomOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MandelbrotFrame parent = (MandelbrotFrame) parentFrame;
                parent.zoomToOut();
            }
        });

    }
}
