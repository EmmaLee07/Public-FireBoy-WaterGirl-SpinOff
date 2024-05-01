import java.util.List;
import mayflower.*;
// platform that automatically moves up and down
public class AutoPlatformVertical extends Actor
{
    int dy = -1;
    int startingX = 0;
    int startingY = 0;
    int upy;
    int downy;
    boolean initialized = false;
    // constructor
    public AutoPlatformVertical()
    {
        MayflowerImage p = new MayflowerImage("img/Platform.png");
        p.scale(0.3);
        setImage(p);
        upy = 40;
        downy = 50;
    }
    public AutoPlatformVertical(int up, int down)
    {
        upy = up;
        downy = down;
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
    // moves up and down
    public void act()
    {
        if(initialized){

            int x = getX();
            int y = getY();

            if(y == startingY - upy){
                dy = 1;
            }
            else if(y == startingY + downy) {
                dy = -1;
            }
            setLocation(x, y + dy);
            // pushes up movable blocks or players
            if (isBlocked()){
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
    // allows it to be pushed if needed
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
