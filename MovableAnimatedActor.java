import mayflower.*;
import java.util.ArrayList;
import java.util.List;
/**
 * Set of animations related to movement that can be extended to be used in 
 * a player class.
 */

public class MovableAnimatedActor extends AnimatedActor
{
    private Animation walkRight;
    private Animation idleRight;
    private Animation idleLeft;
    private String currentAction;
    private Animation walkLeft;
    private String direction;
    private Animation fallLeft;
    private Animation fallRight;
    ArrayList<Integer> keyBinds;
    public static int amtCoin;
    public static boolean coinCheck;
    public static int amtCoin3;
    // constructor; takes in keybinds
    public MovableAnimatedActor(int up, int down, int left, int right, int sprint)
    {
        keyBinds = new ArrayList<Integer>();
        keyBinds.add(up);
        keyBinds.add(down);
        keyBinds.add(left);
        keyBinds.add(right);
        keyBinds.add(sprint);

        walkRight = null;
        idleRight = null;
        idleLeft = null;
        currentAction = null;
        direction = "right";
        fallLeft = null;
        fallRight = null;
    }
    // adds animations 
    public void setIdleRightAnimation(Animation ani)
    {
        idleRight = ani;
    }

    public void setIdleLeftAnimation(Animation ani)
    {
        idleLeft = ani;
    }

    public void setFallRightAnimation(Animation ani)
    {
        fallRight = ani;
    }

    public void setFallLeftAnimation(Animation ani)
    {
        fallLeft = ani;
    }

    public void setWalkRightAnimation(Animation ani)
    {
        walkRight = ani;
    }

    public void setWalkLeftAnimation(Animation ani)
    {
        walkLeft = ani;
    }
    // checks if the player is not blocked from above and is therefore able to jump
    public boolean canJump()
    {
        int x = getX();
        int y = getY();
        setLocation(x,y+1);
        boolean ans = false;
        if(isBlocked())
            ans = true;
        setLocation(x,y);
        return ans;
    }
    // constantly checks for keypresses
    public void act()
    {   
        // GravityActor
        super.act();
        String newAction = null;
        // puts the character as idle if they are not doing anything else
        if(currentAction == null) 
            newAction = "idle";
        // gets character locations + dimensions
        int x = getX();
        int y = getY();
        int w = getWidth();
        int h = getHeight();
        // defaults to moving 1 space at a time
        int dx = 1;
        // boolean variable to check if character should be idle; allows the character to 
        // move in multiple directions by removing the need for else if
        boolean elses = true;
        // allows character to move faster if sprinting
        if(Mayflower.isKeyDown(keyBinds.get(4)))
            dx = 3;
        // movement to the right
        if(Mayflower.isKeyDown(keyBinds.get(3)) && x + w < 800)
        {
            setLocation(x+dx,y);
            newAction = "walkRight";
            // checks if block is able to be moved (not running into wall)
            boolean moved = false;
            // checks if the player is blocked
            if (isBlocked()){
                // gets all intersecting movable blocks
                List<MovableBlock> objs = getIntersectingObjects(MovableBlock.class);
                for(Object o : objs) { 
                    if(o instanceof MovableBlock)
                    {
                        // for movable blocks, pushes them by the player's speed
                        MovableBlock pushMe = (MovableBlock)o;
                        if(isBlocked())
                        {
                            moved = pushMe.moveMe(dx);
                        }
                    }
                    // if the block was not successfully moved or there was no movable block
                    // the player returns to the original location
                    if(!moved) {
                        setLocation(x,y);
                    }
                }
            }
            // player can't move if it is running into wall
            if(isTouching(Brick.class) || isTouching(SideWallLevelTwo.class))
            {
                setLocation(x,y);
            }
            // teleports player
            if(isTouching(teleporterMachine.class))
            {
                setLocation(300, 400);
            }
            direction = "right";
            elses = false;
        }
        // movement to the left
        if(Mayflower.isKeyDown(keyBinds.get(2)) && x > 0)
        {
            setLocation(x-dx,y);
            newAction = "walkLeft";
            // checks if block is able to be moved (not running into wall)
            boolean moved = false;
            // checks if the player is blocked
            if (isBlocked()){
                // gets all intersecting movable blocks
                List<MovableBlock> objs = getIntersectingObjects(MovableBlock.class);
                for(Object o : objs) { 
                    if(o instanceof MovableBlock)
                    {
                        // for movable blocks, pushes them by the player's speed
                        MovableBlock pushMe = (MovableBlock)o;
                        if(isBlocked())
                        {
                            moved = pushMe.moveMe(-1*dx);
                        }
                    }
                    // if the block was not successfully moved or there was no movable block
                    // the player returns to the original location
                    if(!moved) {
                        setLocation(x,y);
                    }
                }
            }
            // player can't move if it is running into wall
            if(isTouching(Brick.class) || isTouching(SideWallLevelTwo.class))
            {
                setLocation(x,y);
            }
            // teleports player
            if(isTouching(teleporterMachine.class))
            {
                setLocation(300, 400);
            }
            direction = "right";
            elses = false;
        }
        // jumping
        if(Mayflower.isKeyDown(keyBinds.get(0)) && y > 0)
        {
            if(canJump())
                setLocation(x,y-35);
            if (isBlocked())
                setLocation(x,y);
            elses = false;
        }
        // moving downward
        if(Mayflower.isKeyDown(keyBinds.get(1)) && y + h < 800)
        {
            setLocation(x,y+1);
            if (isBlocked())
                setLocation(x,y);
            elses = false;
        }
        // sets animation/action when falling
        if(isFalling())
        {
            if(direction != null && direction.equals("left"))
            {
                newAction = "fallLeft";
            }
            if(direction != null && direction.equals("right"))
            {
                newAction = "fallRight";
            }
            elses = false;
        }
        // if there is no action
        if(elses) 
        {
            newAction = "idle";
            newAction = "idle";
            if(direction != null && direction.equals("left"))
            {
                newAction = "idleLeft";
            }
            if(direction != null && direction.equals("right"))
            {
                newAction = "idleRight";
            }
        }
        // change action
        if(newAction != null && !newAction.equals(currentAction))
        {
            if (newAction.equals("fallRight"))
                setAnimation(fallRight);
            else if (newAction.equals("fallLeft"))
                setAnimation(fallLeft);
            else if(newAction.equals("idleRight")) 
                setAnimation(idleRight);
            else if(newAction.equals("idleLeft")) 
                setAnimation(idleLeft);    
            else if(newAction.equals("walkRight")) 
                setAnimation(walkRight);
            else if(newAction.equals("walkLeft")) 
                setAnimation(walkLeft);
            currentAction = newAction;
        }
        // increments # of coins collected
        if(isTouching(Coins.class)){
            amtCoin++;
        }
        // puts players in next level if all coins collected & one playeris at the door
        if(amtCoin == 7 && (isTouching(WaterboyDoor.class))) {
            World world = getWorld();
            if(world instanceof GameWorld){
            Mayflower.setWorld(new LevelTwoGameWorld());
        }
            resetAmt();
            resetCheck();
        }
        
        // if(isTouching(LevelThreeCoins.class))
        // {
            // amtCoin3++;
        // }
        // sets coins to collected
        if(amtCoin == 7 && coinCheck==false){
            coinCheck = true;
            World world = getWorld();
            if(world.equals(LevelTwoGameWorld.class)) {
                coinCheck = true;
                Mayflower.setWorld(new LevelThreeGameWorld());
            }
            
        }
        // if all 18 coins collected
        if(amtCoin3 == 18)
        {
                Mayflower.setWorld(new WinScreen());
        }
    }
    
    public static void resetAmt()
    {
       amtCoin = 0;
       amtCoin3 = 0;
    }
    public static void resetCheck()
    {
        coinCheck = false;
    }
    public static void increase()
    {
        amtCoin3++;
    }
}
