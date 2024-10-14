import javax.swing.*;

public class ParametersPanel extends SettingPanel{
//TODO fixme pls
    public ParametersPanel(){
        super();
        setSize(450,600);


        //Max iterations
        JTextField textFieldMaxIterations = new JTextField();
        JLabel currentMaxIterations = new JLabel("Here goes number");
        textFieldMaxIterations.setBounds(200,200,50,30);
        currentMaxIterations.setBounds(250,200,100,30);



        //Escape radius
        JTextField textFieldEscapeRadius = new JTextField();
        JLabel currentEscapeRadius = new JLabel("Here goes number");
        textFieldEscapeRadius.setBounds(200,300,50,30);
        currentEscapeRadius.setBounds(250,300,100,30);

        add(textFieldEscapeRadius);
        add(textFieldMaxIterations);
        add(currentMaxIterations);
        add(currentEscapeRadius);
    }
}
