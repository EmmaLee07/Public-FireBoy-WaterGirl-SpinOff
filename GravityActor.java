/**
 * Introduces gravity to blocks and players
 */
 import mayflower.*;
 import java.util.List;
public class GravityActor extends Actor
{
    // instance variables - replace the example below with your own
    double v;
    double a;
    double  dy;
    //sets default acceleration and velocity values
    public GravityActor()
    {
        v = 1;
        a = 1;
        dy = 1;
    }
    
    public void act()
    {
        v = v + a;
        setLocation(getX(),getY() + dy);
        if(isBlocked()){
            setLocation(getX(), getY() - dy);
            int x = getX();
            int y = getY();
            v = 1;
            dy = 1;
            
        }
        else dy = v + a;
        
    }
    // checks if running into something
    public boolean isBlocked()
    {
        return (isTouching(Brick.class) || isTouching(MovableBlock.class) || isTouching(AutoPlatformVertical.class)|| isTouching(Platform.class)) || isTouching(SideWallLevelTwo.class);
    }
    // checks if it is falling
    public boolean isFalling()
    {
        boolean ret;
        // move the actor down and see if it touches a block
        setLocation(getX(), getY() + 3);
        ret = isTouching(Brick.class) || isTouching(MovableBlock.class) || isTouching(AutoPlatformVertical.class) || isTouching(Platform.class);
        setLocation(getX(), getY() - 3);
        return !ret;
    }
}
