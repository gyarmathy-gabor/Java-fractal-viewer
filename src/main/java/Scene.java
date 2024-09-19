import javax.swing.*;

public class Scene extends JFrame {

    JFrame mainMenu;

    public Scene(JFrame mainMenu){
        this.mainMenu = mainMenu;

        setSize(900,650);
    }

    @Override
    public void dispose(){
        super.dispose();
        mainMenu.setVisible(true);
    }

}
