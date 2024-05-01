import mayflower.*;
/**
 * the class for the door at the end of the level
 */
public class FiregirlDoor extends Actor
{
    MayflowerImage p;
    /**
     * Constructor for objects of class FiregirlDoor
     */
    public FiregirlDoor()
    {
        p = new MayflowerImage("img/firegirldoor.png");
        p.scale(.3);
        setImage(p);
    }

    public void act(){
    }
}