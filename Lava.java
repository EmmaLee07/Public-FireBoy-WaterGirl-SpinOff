/**
 * one of hazards in the game
 * if the player touches it, the program switches to game over screen
 */
import mayflower.*;
public class Lava extends Actor
{
    // constructor
    public Lava()
    {
        MayflowerImage p = new MayflowerImage("img/LavaEdited.jpg");
        p.scale(0.2);
        setImage(p);
    }
    // game over if player touches the lava
    public void act()
    {
        if(isTouching(Player.class))
        {
            World w = getWorld();
            GameWorld g = new GameWorld();
            Mayflower.setWorld(new GameOverScreen());
        }
    }
}
