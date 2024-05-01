/**
 * class for the lever that the player can press
*/
import mayflower.*;
public class Lever extends Actor
{
   public static boolean flipped;
    public Lever()
    {
        MayflowerImage p = new MayflowerImage("img/LeverUnflipped.png");
        p.scale(0.3);
        setImage(p);
    }

    public void act()
    {
        flipped = false;
        int count = 1;
        if(isTouching(Player.class))
        {
        MayflowerImage p = new MayflowerImage("img/LeverFlipped.png");
        p.scale(0.3);
        setImage(p);
        count++;
        }
        if((count%2==0))
        {
            flipped=true;
        }
    }
}
