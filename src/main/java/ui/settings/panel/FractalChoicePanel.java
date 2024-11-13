package ui.settings.panel;

import model.fractal.Fractal;

import javax.swing.*;

/**
 * A panel that allows users to select a fractal type from a list of available fractals.
 * The user can choose a fractal type, which will affect the rendering behavior in the fractal visualization.
 *
 * <p>This panel is part of the settings interface, enabling the user to adjust the fractal type
 * for the fractal rendering.</p>
 */
public class FractalChoicePanel extends SettingPanel {
    JComboBox<String> sets;
    Fractal[] fractals;

    /**
     * Constructor for the FractalChoicePanel.
     * This constructor initializes the JComboBox with available fractal types and sets up the
     * label for selecting a fractal type.
     */
    public FractalChoicePanel(){
        super();

        fractals = Fractal.values();

        String[] names = new String[Fractal.values().length];
        for(int i = 0; i< Fractal.values().length; i++){
            names[i] = fractals[i].toString();
        }

        sets = new JComboBox<>(names);
        JLabel currentsetJLabel = new JLabel("Fractaltype:");
        sets.setBounds(110,10,150,30);
        currentsetJLabel.setBounds(10,10,100,30);
        add(sets);
        add(currentsetJLabel);
    }

    /**
     * Returns the currently selected fractal type.
     *
     * @return The selected {@link Fractal}.
     */
    public Fractal getFractalChoice(){
        int idx = sets.getSelectedIndex();
        return fractals[idx];
    }

    /**
     * Sets the selected fractal type in the JComboBox based on the given fractal.
     *
     * @param fractal The fractal type to set as selected.
     */
    public void setSets(Fractal fractal){
        sets.setSelectedItem(fractal.toString());
    }
}
