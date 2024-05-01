import mayflower.*;
/**
The first screen the players see when the game is started
 */
public class TitleScreen extends World

{
    private Boolean begin;
    // constructor
    public TitleScreen()
    {
        MayflowerImage p = new MayflowerImage("img/FireGirlAndWaterBoyTitleScreen.jpg");
       p.scale(1.4);
       setBackground(p);
       showText("To begin the game, press the up arrow key", 10,30,Color.WHITE);
    }
    // puts players in game world if up key is pressed
    public void act()
    {
        if (Mayflower.isKeyDown(Keyboard.KEY_UP))
        {
            Mayflower.setWorld(new GameWorld());
        }
    }
}

