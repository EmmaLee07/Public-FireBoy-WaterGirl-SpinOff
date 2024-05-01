
import mayflower.*;
/*
 * The screen the player sees after they complete all three levels
 */
public class WinScreen extends World
{
    // sets the win screen
    public WinScreen()
    {
       //MayflowerImage p = new MayflowerImage("img/WhiteBackground.jpg");
        //p.scale(8);
       showText("Congratulations! You won!", 10,30, Color.BLACK);
    }

    public void act()
    {
        
    }
}
