/*
 * small as the lava class except the image is smaller for smaller areas in the game where this 
 * hazard is needed
 */
import mayflower.*;
public class smallerLava extends Actor
{
    int z = -1;
    int upY = 65;
    int downY =65;
    boolean i = false;
    int sY;
    int sX;
    // constructor
    public smallerLava()
    {
        MayflowerImage p = new MayflowerImage("img/LavaEdited.jpg");
        p.scale(0.09);
        setImage(p);

    }
    // sets basic info so that the water knows where to oscillate
    public void initialize()
    {
        sY= getY();
        sX = getX();
        i= true;
    }
    // moves up and down periodically
    public void act()
    {
        int y = getY();
        int x = getX();
        if(i)
        {
            if(y == sY-upY)
            {
                z =1;
            }
            else if(y== sY+ downY)
            {
                z=-1;
            }
            setLocation(x, y+z);
        }
        // ends game if player touches the water
        if(isTouching(Player.class))
        {
            World w = getWorld();
            GameWorld g = new GameWorld();
            Mayflower.setWorld(new GameOverScreen());
        }
    }
}
