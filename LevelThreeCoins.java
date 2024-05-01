/*
 * Description:
 * the coin actors that once completely collect in third level, will switch the screen to 
 * the win screen
 */
import mayflower.*;
import java.util.Queue;
import java.util.LinkedList;
public class LevelThreeCoins extends Actor
{
   MayflowerImage p;
    private Queue1<Integer> q;
    // constructor
    public LevelThreeCoins()
    {
        p = new MayflowerImage("img/coin.png");
        p.scale(.01);
        setImage(p);
        q = new MyQueue1<Integer>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
    }
    // increment coins collected and remove the coin when touched by a player
    public void act()
    {
        if(isTouching(Player.class))
        {
            MovableAnimatedActor.increase();
            getWorld().removeObject(this);
            remove();
        }

    }
    
    public boolean noMoreCoins(){
        if(q.isEmpty()){
            return true;
        }
        return false;
    }

    private void remove()
    {
        // System.out.print(q.remove());
        q.remove();
    }
}
