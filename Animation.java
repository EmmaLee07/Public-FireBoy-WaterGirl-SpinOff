import mayflower.*;
/**
 * class for animations; stores images to be played in succession
 */
public class Animation
{
    // instance variables - replace the example below with your own
    private int framerate;
    private int currentFrame;
    private MayflowerImage[] frames;
    
    /**
     * Constructor for objects of class Animation
     */
    public Animation(int in, String[] lst)
    {
        framerate = in;
        frames = new MayflowerImage[lst.length];
        for(int i = 0; i < lst.length; i++)
            frames[i] = new MayflowerImage(lst[i]);
    }
    // various methods that allow for changing the animation as a whole instead of image by image
    
    
    public void scale(int w, int h){
        for (int i = 0; i < frames.length; i++) 
            frames[i].scale(w,h);
    }
    public void setTransparency(int per)
    {
        for (int i = 0; i < frames.length; i++) 
            frames[i].setTransparency(per);
    }
    public void setBounds(int x, int y, int w, int h)
    {
        for (int i = 0; i < frames.length; i++) 
            frames[i].crop(x,y,w,h);
    }
    public int getFrameRate()
    {
        return framerate;
    }
    public void mirrorHorizontally()
    {
        for (int i = 0; i < frames.length; i++) 
            frames[i].mirrorHorizontally();
    }
    // gives the next image in the list
    public MayflowerImage getNextFrame()
    {
        MayflowerImage mfi = frames[currentFrame];
        if (currentFrame < frames.length-1) currentFrame++;
        else currentFrame = 0;
        return mfi;
    }
}
