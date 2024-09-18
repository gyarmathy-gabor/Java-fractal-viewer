import javax.swing.*;

public class FractalChoicePanel extends SettingPanel{
    Fractal choice;

    public FractalChoicePanel(){
        super();

        Fractal[] fractals = Fractal.values();

        String[] names = new String[Fractal.values().length];
        for(int i=0;i<Fractal.values().length;i++){
            names[i] = fractals[i].toString();
        }

        JComboBox<String> sets = new JComboBox<>(names);
        sets.setBounds(200,200,150,30);
        add(sets);
    }
}
