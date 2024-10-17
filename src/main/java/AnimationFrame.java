import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AnimationFrame extends Scene{
    private ViewerHeaderPanel headerPanel;
    private CanvasPanel canvasPanel;
    private ComputingUnit computer;

    public AnimationFrame(MenuFrame mainMenu){
        super(mainMenu);

        //Get choosen profile for computing unit
        Profile choosenProfile =FileUtils.getChoosenProfile();

        //Logic
        computer = new ComputingUnit(choosenProfile,this);

        //Basic initialization
        setTitle("Julia set animation viewer");
        this.setSize(900,650);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null); //set the layout to manual
        setLocationRelativeTo(null);


        //Adding header
        headerPanel = new ViewerHeaderPanel(this,choosenProfile);
        headerPanel.setBounds(0,0,900,50);
        add(headerPanel);


        //Adding canvas
        this.canvasPanel = new CanvasPanel(choosenProfile.getMaxIter(),choosenProfile.getColormap());
        this.add(canvasPanel);
        canvasPanel.setBounds(0,50,900,600);

        this.setVisible(true);

        updateCanvas(computer.getPixels());


        JButton startAnimation = new JButton("Start animation");
        startAnimation.setBounds(620,0,200,50);
        headerPanel.add(startAnimation);


        startAnimation.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                computer.animateJuliaSets();
            }
        });

    }

    public void updateCanvas(List<Pixel> pixels) {
        canvasPanel.setPixels(pixels);
    }

    public CanvasPanel getCanvas(){
        return canvasPanel;
    }

}
