/*
 * Description:
 * appears on the screen if the user touches on of the hazards
 * has an restartButton that comes up also
 * if the user hovers the mouse near the start of the screen, the game starts over again
 * at level 1
 * If the user does not want to play anymore, they are supposed to close the game as explained
 * to them
 */

import mayflower.*;
import java.awt.event.*;
import java.awt.Point;
import java.awt.MouseInfo;
import java.awt.PointerInfo;
import java.awt.Component;

public class GameOverScreen extends World {
    private RestartButton button1;
    // constructor
    public GameOverScreen()
    {
        //setBackground("img/NewWhiteBackground.jpg");
        showText("Game Over." , 10 ,30, Color.BLACK);
        showText("Please hover the mouse over the restart button if ", 10, 60, Color.BLACK);
        showText("you would like to restart.",10,100, Color.BLACK);
        showText("If you want to stop the game, please close the game." , 10, 160, Color.BLACK);
        
        button1 = new RestartButton();
        addObject(button1, 200,200);
        //PointerInfo a = MouseInfo.getPointerInfo();
        
        
        
    }
    // checks if mouse in center of screen
    public void act() {
        
        int x = button1.getX();
        int y = button1.getY();
        int xRange = x+50;
        int yRange = y+50;
        int mouseX = MouseInfo.getPointerInfo().getLocation().x;
        int mouseY = MouseInfo.getPointerInfo().getLocation().y;
        showText("Mouse X: " + mouseX, 10, 50, Color.BLACK);
        showText("Mouse Y: " + mouseY, 10,80, Color.BLACK);
        showText("Button X: " + x, 10, 110, Color.BLACK);
        showText("Button Y: " + y, 10,140, Color.BLACK);
        if((mouseX <= xRange||mouseX >=x) && (mouseY <=yRange || mouseY >=y))
        {
            GameWorld g = new GameWorld();
            Mayflower.setWorld(new GameWorld());
        }
    }
}
