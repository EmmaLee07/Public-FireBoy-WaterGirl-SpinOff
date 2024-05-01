import java.util.List;
import mayflower.*;
// platform that moves left and right automatically
public class AutoPlatformHorizontal extends Actor
{
    int dx = -1;
    int startingX = 0;
    int startingY = 0;
    boolean initialized = false;
    // constructor
    public AutoPlatformHorizontal()
    {
        MayflowerImage p = new MayflowerImage("img/Platform.png");
        p.scale(0.3);
        setImage(p);
    }
    /* should be called after creating the object, checks the current 
     * x and y coordinates to see how far up and down it should move
     */
    public void initialize()
    {
        startingX = getX();
        startingY = getY();
        initialized = true;
    }
    // moves left and right
    public void act()
    {
        if(initialized){

            int x = getX();
            int y = getY();
            // makes sure the platform oscillates between 100 left and right of the starting place
            if(x == startingX - 100){
                dx = 1;
            }
            else if(x == startingX + 100) {
                dx = -1;
            }
            setLocation(x + dx, y);
            if (isBlocked()){
                // pushes the movable blocks when running in to them
                List<MovableBlock> blocks = getIntersectingObjects(MovableBlock.class);

                for(Object o : blocks) { 
                    if(o instanceof MovableBlock)
                    {
                        MovableBlock pushMe = (MovableBlock)o;
                        if(isBlocked())
                        {
                            pushMe.move(-1);
                        }
                    }
                    else {
                        setLocation(x,y);
                    }
                }
                // pushes the player when running in to them
                List<Player> players = getIntersectingObjects(Player.class);
                for(Object o : players) { 
                    if(o instanceof Player)
                    {
                        Player pushMe = (Player)o;
                        if(isBlocked())
                        {
                            pushMe.move(-1);
                        }
                    }
                    else {
                        setLocation(x,y);
                    }
                }
            }
        }
    }
    // allows it to be pushed
    public void move(int dy)
    {
        int x = super.getX();
        int y = super.getY();
        setLocation(x, y + dy);

    }
    // checks if it is inside a player or movable block
    public boolean isBlocked()
    {
        return isTouching(Player.class) || isTouching(MovableBlock.class);
    }

}
