package ui.settings.panel;

import javax.swing.*;

/**
 * A panel that allows users to input parameters related to the fractal rendering.
 * The parameters include the maximum number of iterations and the escape radius for the fractal.
 * These parameters control how the fractal is generated and how long the rendering process takes.
 */
public class ParametersPanel extends SettingPanel {

    // Text fields for user input
    private JTextField textFieldMaxIterations;
    private JTextField textFieldEscapeRadius;


    //Constants for default values
    private final int DEFAULT_MAX_ITERATIONS = 25;
    private final double DEFAULT_ESCAPE_RADIUS = 2;


    /**
     * Constructor for the ParametersPanel.
     * Initializes the panel, setting up text fields for maximum iterations and escape radius,
     * along with corresponding labels for each parameter.
     */
    public ParametersPanel(){
        super();
        setSize(450,600);

        // Max iterations
        textFieldMaxIterations = new JTextField();
        JLabel currentMaxIterations = new JLabel("Max Iterations:");
        textFieldMaxIterations.setBounds(110,0,50,30);
        currentMaxIterations.setBounds(10,0,100,30);

        // Escape radius
        textFieldEscapeRadius = new JTextField();
        JLabel currentEscapeRadius = new JLabel("Escape Radius:");
        textFieldEscapeRadius.setBounds(110,70,50,30);
        currentEscapeRadius.setBounds(10,70,100,30);

        // Add components to panel
        add(textFieldEscapeRadius);
        add(textFieldMaxIterations);
        add(currentMaxIterations);
        add(currentEscapeRadius);
    }

    /**
     * Returns the maximum number of iterations specified by the user.
     * If the user input is invalid or empty, the default value of 25 is returned.
     *
     * @return The maximum number of iterations.
     */
    public int getMaxIterations() {
        String text = textFieldMaxIterations.getText().trim();
        if(text.isEmpty()){
            return DEFAULT_MAX_ITERATIONS;
        }
        boolean isNumeric;
        try {
            Integer.parseInt(text);
            isNumeric = true;
        } catch (NumberFormatException e) {
            isNumeric = false;
            return DEFAULT_MAX_ITERATIONS;
        }
        return Integer.parseInt(text);
    }

    /**
     * Returns the escape radius specified by the user.
     * If the user input is invalid or empty, the default value of 2.0 is returned.
     *
     * @return The escape radius.
     */
    public double getEscapeRadius() {
        String text = textFieldEscapeRadius.getText().trim();
        if (text.isEmpty()) {
            return DEFAULT_ESCAPE_RADIUS; // Use the default value if the text field is empty
        }
        try {
            return Double.parseDouble(text); // Parse directly as double
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return DEFAULT_ESCAPE_RADIUS;
        }
    }

    /**
     * Sets the maximum iterations value in the text field.
     *
     * @param maxIterations The maximum number of iterations to display.
     */
    public void setTextFieldMaxIterations(int maxIterations){
        textFieldMaxIterations.setText(Integer.toString(maxIterations));
    }

    /**
     * Sets the escape radius value in the text field.
     *
     * @param escapeRadius The escape radius to display.
     */
    public void setTextFieldEscapeRadius(double escapeRadius){
        textFieldEscapeRadius.setText(Double.toString(escapeRadius));
    }

}
