/*
 * The graphics, hazards and coins for the second game level
 */
import mayflower.*;
import java.time.Instant.*;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.LinkedList;
public class LevelTwoGameWorld extends World
{
   private Timer time;
   Player p1;
   Player p2;
   smallerWater water;
   smallerLava lava;
   AutoPlatformVertical level2;
   AutoPlatformVertical stepper;
   AutoPlatformVertical mover;
   AutoPlatformVertical moverHelper;
   AutoPlatformHorizontal platform1;
   AutoPlatformHorizontal platform2;
   smallerWater water1;
   smallerLava lava1;
   // constructor
    public LevelTwoGameWorld()
    {
        MayflowerImage p = new MayflowerImage("img/BrownBackground.jpg");
        p.scale(8);
        setBackground(p);
        buildWorld();
        addCoins();
        addLiquidHazard();
        addSideWall();
        buildLevelTwoPlatform();
        p1 = new Player(Keyboard.KEY_UP, Keyboard.KEY_DOWN, Keyboard.KEY_LEFT, Keyboard.KEY_RIGHT, Keyboard.KEY_LSHIFT);
        p2 = new Player(Keyboard.KEY_W, Keyboard.KEY_S, Keyboard.KEY_A, Keyboard.KEY_D, Keyboard.KEY_C);
        addObject(p2, 325, 440);
        addObject(p1, 60, 440);
        // in constructor of gameWorld class
        time = new Timer();
        myTimerTask timer= new myTimerTask(this);
        time.schedule(timer,0,1000);
    }
    // checks if all coins are collected
    public void act()
    {
         if(MovableAnimatedActor.coinCheck == true)
        {
            MovableAnimatedActor.resetAmt();
            Mayflower.setWorld(new LevelThreeGameWorld());
        }
    }
    // adds in bricks for the world
    public void buildWorld()
    {
        LinkedList<Brick> bricks2 = new LinkedList<Brick>();
        //leftmost row of bricks
        for(int i = 0; i < 550; i++)
        {
            Brick b = new Brick();
            addObject(b, 10, i);
            bricks2.add(b);
            i = i+15;
        }
        //top row of bricks
        for(int x = 0; x < 720; x++)
        {
            Brick b = new Brick();
            addObject(b, x, 10);
            bricks2.add(b);
            x = x+ 15;
        }
        //bottom row of bricks
        for(int x = 0; x < 720; x++)
        {
            Brick b = new Brick();
            addObject(b, x, 550);
            bricks2.add(b);
            x = x+15;
        }
        
        for(int y = 10;  y<550; y++)
        {
            Brick b = new Brick();
            addObject(b, 720, y);
            bricks2.add(b);
            y = y+15;
        }
        
        //row of bricks with moving wall on it
        for(int x = 10; x <650; x++)
        {
            Brick b = new Brick();
            addObject(b, x, 400);
            bricks2.add(b);
            x = x+15;
        }
        
        
        for (int x = 90; x <720; x++)
        {
            Brick b = new Brick();
            addObject(b, x, 300);
            bricks2.add(b);
            x = x+15;
        }
        
        for(int y = 300; y > 200; y--)
        {
            Brick b = new Brick();
            addObject(b, 650, y);
            bricks2.add(b);
            y = y-15;
        }
        
        for (int x = 650; x < 720; x++)
        {
            Brick b = new Brick();
            addObject(b, x, 200);
            bricks2.add(b);
            x = x+15;
        }
        
        for(int x = 450; x < 550; x++)
        {
            Brick b = new Brick();
            addObject(b, x, 100);
            bricks2.add(b);
            x = x+15;
        }
        
        for(int x = 550; x < 570; x++)
        {
            Brick b = new Brick();
            addObject(b, x, 110);
            bricks2.add(b);
            x = x+15;
        }
        
        for(int x = 570; x < 590; x++)
        {
            Brick b = new Brick();
            addObject(b, x, 120);
            bricks2.add(b);
            x = x+15;
        }
        
        
        for(int x = 10; x < 500; x++)
        {
            Brick b = new Brick();
            addObject(b, x, 100);
            bricks2.add(b);
            x=x+15;
        }
        
        
        
        
        
        for(int y = 490; y >520; y++)
        {
            Brick b = new Brick();
            addObject(b, 500, y);
            bricks2.add(b);
            y= y+15;
        }
        
        
        
    }
    // adds in coins to be collected
    public void addCoins()
    {
        addObject(new Coins(), 150, 507);
        addObject(new Coins(), 220, 507);
        addObject(new Coins(), 445, 507);
        addObject(new Coins(), 200, 83);
        addObject(new Coins(), 550, 370);
        addObject(new Coins(), 500, 370);
        addObject(new Coins(), 300, 370);
        
    }
    // adds in all hazards
    public void addLiquidHazard()
    {
        
        water = new smallerWater();
        addObject(water,150,535);
        water.initialize(); 
        
        lava = new smallerLava();
        addObject(lava,450,535);
        lava.initialize();
        
        // addObject(new Water(), 200, 280);
        // addObject(new Lava(), 400, 280);
        water1 = new smallerWater();
        addObject(water1, 220, 220);
        water1.initialize();
        
        lava1 = new smallerLava();
        addObject(lava1, 400, 200);
        lava1.initialize();
    }
    // adds the wall along with a button
    public void addSideWall()
    {
        addObject(new SideWallButton(), 550, 380);
        addObject(new SideWallLevelTwo(), 350, 320);
    }
    // adds automatic platforms so that the players can traverse the level
    public void buildLevelTwoPlatform()
    {
        
        level2 = new AutoPlatformVertical(20,150);
        addObject(level2, 670, 410);
        level2.initialize(); 
        
        stepper = new AutoPlatformVertical(20,150);
        addObject(stepper, 40, 250);
        stepper.initialize();
        
        mover = new AutoPlatformVertical(20,80);
        addObject(mover, 600, 200);
        mover.initialize();
        
        moverHelper = new AutoPlatformVertical(20, 150);
        addObject(moverHelper,670, 100);
        moverHelper.initialize();
        
        // platform1 = new AutoPlatformHorizontal();
        // addObject(platform1, 200, 250);
        // platform1.initialize();
        
        // platform2 = new AutoPlatformHorizontal();
        // addObject(platform2, 500, 250);
        // platform2.initialize();
        
    }
}
