/**
 * this class is for a button that can be mapped to a platform so that the platform only
 * oscillates when the button is pressed.
 */
import mayflower.*;
public class Button extends Actor
{
    public boolean pressed;
    // constructor
    public Button()
    {
        MayflowerImage p = new MayflowerImage("img/ButtonUpImage.png");
        p.scale(0.3);
        setImage(p);
    }
    // button is pressed down when player or movable block is touching it
    public void act()
    {
        pressed = false;
        if(isTouching(Player.class) || isTouching(MovableBlock.class))
        {
            pressed = true;
            MayflowerImage n = new MayflowerImage("img/ButtonDown.png");
            n.scale(0.1);
            setImage(n);
        }
        if(!isTouching(Player.class) && !isTouching(MovableBlock.class))
        {
            pressed = false;
            MayflowerImage p = new MayflowerImage("img/ButtonUpImage.png");
            p.scale(0.1);
            setImage(p);   
        }
    }
    // checks if the button is pressed.
    public boolean isPressed()
    {
        return pressed;
    }
}
