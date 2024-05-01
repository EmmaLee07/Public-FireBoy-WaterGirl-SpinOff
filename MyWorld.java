//Description: Calls to the title screen class
import mayflower.*;



public class MyWorld extends World
{
    private Boolean begin;
    // constructor
    public MyWorld()
    {
        
    }

    public void act()
    {
        begin = true;
        
        do 
        {
            //title screen
            Mayflower.setWorld(new TitleScreen());
            begin = false;
        }
        while(begin == true);
    }
}
