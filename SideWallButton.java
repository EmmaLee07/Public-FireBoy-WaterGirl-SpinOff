/*
 * Used by the SideWallLevelTwo to determine whether the sideWall should move or not
 */
import mayflower.*;
public class SideWallButton extends Actor
{
    public static boolean sideWallButtonPress;
    // constructor
    public SideWallButton()
    {
        MayflowerImage p = new MayflowerImage("img/ButtonUpImage.png");
        p.scale(0.3);
        setImage(p);
    }
    // checks if the button is being pushed down by a player or not and sets the 
    // corresponding image
    public void act()
    {
        sideWallButtonPress = false;
        if(isTouching(Player.class))
        {
            sideWallButtonPress = true;
            MayflowerImage n = new MayflowerImage("img/ButtonDown.png");
            n.scale(0.1);
            setImage(n);
        }
        if(!isTouching(Player.class))
        {
            sideWallButtonPress = false;
            MayflowerImage p = new MayflowerImage("img/ButtonUpImage.png");
            p.scale(0.1);
            setImage(p);   
        }
    }
}
