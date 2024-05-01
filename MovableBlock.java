import mayflower.*;
/*
 * Allows for blocks that can be pushed by the player
 */
public class MovableBlock extends GravityActor
{
   
    // constructor
    public MovableBlock()
    {
        MayflowerImage img = new MayflowerImage("img/Tiles/12.png");
        img.scale(.18);
        setImage(img);
    }
    // allows for the block to experience gravity
    public void act()
    {
        super.act();
    }
    // allows for the block to be pushed
    public boolean moveMe(int dx)
    {
        
        int x = super.getX();
        int y = super.getY();
        setLocation(x + dx, y);
        if(this.isBlocked()){
            setLocation(x,y);
            return false;
        }
        return true;
    }
}
