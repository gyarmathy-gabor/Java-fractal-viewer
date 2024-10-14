import javax.swing.*;

public class Scene extends JFrame {

    private MenuFrame mainMenu;

    public Scene(MenuFrame mainMenu){
        this.mainMenu = mainMenu;

        setSize(900,650);
    }

    @Override
    public void dispose(){
        super.dispose();
        mainMenu.setVisible(true);
    }

}
