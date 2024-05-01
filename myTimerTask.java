//keeps track of the time as the stopwatch for the game
import java.util.TimerTask;
import mayflower.*;

public class myTimerTask extends TimerTask
{
    int count;
    World world;
    // constructor
    public myTimerTask(World w)
    {
        count = 0;
        world = w;
    }
    // displays seconds that have passed
    public void run()
    {
        count++;
        world.showText("Seconds elapsed: " + count, 10,30, Color.WHITE);
    }
}
