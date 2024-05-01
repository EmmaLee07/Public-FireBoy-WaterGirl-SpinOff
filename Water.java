/*
 * one of hazards in the game
 * if the player touches it, the program swtiches to game over screen
 */
import mayflower.*;
public class Water extends Actor
{
    // constructor
    public Water()
    {
        MayflowerImage p = new MayflowerImage("img/WaterEdited.jpg");
        p.scale(0.15);
        setImage(p);
    }
    // game over if player touches the lava
    public void act()
    {
        if(isTouching(Player.class))
        {
            World w = getWorld();
            Mayflower.setWorld(new GameOverScreen());
        }
    }
}
