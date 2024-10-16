import javax.swing.*;

public class ViewerHeaderPanel extends HeaderPanel{
    private Profile profile;
    JLabel informations;

    public ViewerHeaderPanel(JFrame parentFrame,Profile profile){
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

    }
}
