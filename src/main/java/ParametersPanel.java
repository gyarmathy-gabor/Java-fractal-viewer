import javax.swing.*;

public class ParametersPanel extends SettingPanel{
    private JTextField textFieldMaxIterations;
    private JTextField textFieldEscapeRadius;


    //constants
    private final int DEFAULT_MAX_ITERATIONS = 25;
    private final double DEFAULT_ESCAPE_RADIUS = 2;

    public ParametersPanel(){
        super();
        setSize(450,600);


        //Max iterations
        textFieldMaxIterations = new JTextField();
        JLabel currentMaxIterations = new JLabel("Here goes number");
        textFieldMaxIterations.setBounds(200,200,50,30);
        currentMaxIterations.setBounds(250,200,100,30);



        //Escape radius
        textFieldEscapeRadius = new JTextField();
        JLabel currentEscapeRadius = new JLabel("Here goes number");
        textFieldEscapeRadius.setBounds(200,300,50,30);
        currentEscapeRadius.setBounds(250,300,100,30);

        add(textFieldEscapeRadius);
        add(textFieldMaxIterations);
        add(currentMaxIterations);
        add(currentEscapeRadius);
    }

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

    public double getEscapeRadius() {
        String text = textFieldEscapeRadius.getText().trim();
        if(text.isEmpty()){
            return DEFAULT_MAX_ITERATIONS;
        }
        boolean isNumeric;
        try {
            Double.parseDouble(text);
            isNumeric = true;
        } catch (NumberFormatException e) {
            isNumeric = false;
            return DEFAULT_MAX_ITERATIONS;
        }
        return Integer.parseInt(text);
    }

    public void setTextFieldMaxIterations(int maxIterations){
        textFieldMaxIterations.setText(Integer.toString(maxIterations));
    }

    public void setTextFieldEscapeRadius(double escapeRadius){
        textFieldEscapeRadius.setText(Double.toString(escapeRadius));
    }

}
