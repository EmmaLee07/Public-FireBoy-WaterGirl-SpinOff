import mayflower.*;
/**
 * allows for actors that can be animated
 */
public class AnimatedActor extends GravityActor
{
    private Animation animation;
    private Timer animationTimer;

    /**
     * Constructor for objects of class AnimatedActor
     */
    public AnimatedActor()
    {
        animationTimer = new Timer(1000);
    }
    // sets animations
    public void setAnimation (Animation a)
    {
        animation = a;
    }
    // allows animations to happen
    public void act()
    {
        super.act();
        if (animationTimer.isDone())
        {
            animationTimer.reset();
            MayflowerImage mfi = animation.getNextFrame();
            setImage(animation.getNextFrame());
        }
    }

}
