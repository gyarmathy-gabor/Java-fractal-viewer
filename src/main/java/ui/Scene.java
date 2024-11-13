package ui;

import ui.menu.MenuFrame;

import javax.swing.*;

/**
 * Represents a scene in the application. A scene is a specific screen or window that the user interacts with.
 * This class extends {@link JFrame} and is used as a base for different scenes in the application, such as
 * the main menu and settings frame. The `Scene` class manages the transition back to the main menu when the scene is closed.
 */
public class Scene extends JFrame {

    //Reference to the main menu frame, used for navigating back when the scene is disposed
    private MenuFrame mainMenu;

    /**
     * Constructs a new scene with a reference to the main menu.
     *
     * @param mainMenu The main menu frame that this scene will transition back to when disposed.
     */
    public Scene(MenuFrame mainMenu){
        this.mainMenu = mainMenu;

        setSize(900,650);
    }

    /**
     * Disposes of the current scene and makes the main menu visible again.
     * This method is overridden to ensure that when the scene is closed,
     * the main menu reappears for further interaction.
     */
    @Override
    public void dispose(){
        super.dispose();
        //Make the main menu visible again when this scene is disposed of
        mainMenu.setVisible(true);
    }

}
