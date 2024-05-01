/*
 * This actor is used to keep the player in the game and on-course
 */

import mayflower.*;
/**
The image for the bricks that the characters walk on in the game
 */
public class Brick extends Actor
{
    // constructor
    public Brick()
    {
       MayflowerImage p = new MayflowerImage("img/UneditedBricks.jpg");
       p.scale(0.1);
       setImage(p);
    }
    // empty method
    public void act()
    {
       
    }
    // returns the x of the button
    public int findX()
    {
        return getX();
    }
    // returns the y of the button
    public int findY()
    {
        return getY();
    }
}
