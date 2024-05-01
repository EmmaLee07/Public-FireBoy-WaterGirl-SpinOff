/**
 * a platform that oscillates only when a specific button is pressed
 */


import java.util.List;
import mayflower.*;
public class Platform extends Actor
{
    int direction = 0;
    int startingX = 0;
    int startingY = 0;
    Button button1;
    Button button2;
    // constructors
    public Platform(Button press)
    {
        MayflowerImage p = new MayflowerImage("img/Platform.png");
        p.scale(0.3);
        setImage(p);
        button1 = press;
    }
    public Platform(Button press1, Button press2)
        {
            MayflowerImage p = new MayflowerImage("img/Platform.png");
            p.scale(0.3);
            setImage(p);
            button1 = press1;
            button2 = press2;
        }
    // get starting location 
    public void initialize()
    {
        startingX = getX();
        startingY = getY();
    }
    // checks if buttons pressed
    public void act()
    {
        
        int x = getX();
        int y = getY();
        if(button1.isPressed()==true || button2.isPressed() == true)
        {
            if (direction == 0)
            {
                startingX = getX();
                startingY = getY();
                direction = 1;
            }
            else if (direction == 1 && getY() == startingY + 100){
                direction = -1;
            }
            else if (direction == -1 && getY() == startingY){
                direction = 1;
            }
            
        }
        else if(!(button1.isPressed() || button2.isPressed()) && getY() != startingY)
        {
            direction = -1;
        }
        if(getX() == startingX && getY() == startingY && !(button1.isPressed() || button2.isPressed()))
            direction = 0;
        setLocation(getX(), getY() + direction);
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
    // movement
    public void move(int dy)
    {
        int x = super.getX();
        int y = super.getY();
        setLocation(x, y + dy);
        
    }
    // checks if blocked
    public boolean isBlocked()
    {
        return isTouching(Player.class) || isTouching(MovableBlock.class);
    }
    // checks if falling
    public boolean isFalling()
    {
        return direction == -1;
    }
}
