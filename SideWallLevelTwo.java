/*
 * a hazard used in the second level that moves out of the way when the user presses the sideWallButton class
 */
import mayflower.*;

public class SideWallLevelTwo extends Actor
{
    int direction = 0;
    int startingX = 0;
    int startingY = 0;
    // constructor
    public SideWallLevelTwo()
    {
        MayflowerImage p = new MayflowerImage("img/EditedSideWall.jpg");
        p.scale(0.3);
        setImage(p);
    }
    // makes the sidewall oscillate when the button is pressed.
    public void act()
    {
        if(SideWallButton.sideWallButtonPress==true )
        {
            if (direction == 0)
            {
                startingX = getX();
                startingY = getY();
                direction = 1;
            }
            else if (direction == 1 && getY() == startingY + 90){
                direction = -1;
            }
            else if (direction == -1 && getY() == startingY){
                direction = 1;
            }
            setLocation(getX(), getY() + direction);
        }
        
    }
}
