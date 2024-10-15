import javax.swing.*;

public class FractalChoicePanel extends SettingPanel{
    JComboBox<String> sets;
    Fractal[] fractals;

    public FractalChoicePanel(){
        super();

        fractals = Fractal.values();

        String[] names = new String[Fractal.values().length];
        for(int i=0;i<Fractal.values().length;i++){
            names[i] = fractals[i].toString();
        }

        sets = new JComboBox<>(names);
        sets.setBounds(200,200,150,30);
        add(sets);
    }

    public Fractal getFractalChoice(){
        int idx = sets.getSelectedIndex();
        return fractals[idx];
    }

    public void setSets(Fractal fractal){
        sets.setSelectedItem(fractal.toString());
    }
}
