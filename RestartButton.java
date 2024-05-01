/*
 * this is the image the user is supposed to hover over if they want to play again
 * the logic for the mouse is written in the GameOverScreen class
 */
import mayflower.*;
public class RestartButton extends Actor
{
    // constructor 
    public RestartButton()
    {
        MayflowerImage p = new MayflowerImage("img/RestartButton.jpg");
        setImage(p);

    }
    // empty method
    public void act()
    {

    }
}
