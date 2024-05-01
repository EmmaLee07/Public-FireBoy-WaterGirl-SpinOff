import mayflower.*;
/**
 * the class for the door at the end of the level
 */
public class WaterboyDoor extends Actor
{
    MayflowerImage p;
    /**
     * Constructor for objects of class WaterboyDoor
     */
    public WaterboyDoor()
    {
        p = new MayflowerImage("img/waterboydoor.png");
        p.scale(.3);
        setImage(p);
    }

    public void act(){
       
    }
}
