import mayflower.*;
import java.util.Queue;
import java.util.LinkedList;
/**
 * Description:
 * This class spawns the coins and removes them after the actor 
 * collects (touches) them
 */
public class Coins extends Actor
{
    MayflowerImage p;
    private Queue1<Integer> q;
    public static boolean change = false;
    // constructor
    public Coins()
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
        //q.add(7);
        // if(q.isEmpty()==true)
        // {
            // change = true;
        // }
    }
    // increment + remove coins when touching player
    // next level when done
    public void act()
    {

        if(isTouching(Player.class))
        {
            Object a = getOneIntersectingObject(Player.class);
            Player c = (Player) a;
            getWorld().removeObject(this);
            remove();
        }

        if(q.isEmpty()==true)
        {
            change = true;
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

