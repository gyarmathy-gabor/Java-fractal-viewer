import javax.swing.*;

public class ViewerHeaderPanel extends HeaderPanel{
    private Profile profile;
    JLabel informations;

    JButton up;
    JButton down;
    JButton right;
    JButton left;
    JButton zoomIn;
    JButton zoomOut;

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



    }
}
