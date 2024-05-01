/*
 * The graphics, hazards and coins for the third level
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
public class LevelThreeGameWorld extends World
{
    private Timer time;
    Player p1;
   Player p2;
   AutoPlatformVertical bLeft;
   AutoPlatformVertical bRight;
   AutoPlatformVertical platform1;
   AutoPlatformVertical platform2;
   AutoPlatformHorizontal platform3;
   smallerLava lava1;
   smallerLava lava2;
   smallerWater water1;
   smallerWater water2;
   // constructor
    public LevelThreeGameWorld()
    {
        MayflowerImage p = new MayflowerImage("img/BrownBackground.jpg");
        p.scale(8);
        setBackground(p);
        p1 = new Player(Keyboard.KEY_UP, Keyboard.KEY_DOWN, Keyboard.KEY_LEFT, Keyboard.KEY_RIGHT, Keyboard.KEY_LSHIFT);
        p2 = new Player(Keyboard.KEY_W, Keyboard.KEY_S, Keyboard.KEY_A, Keyboard.KEY_D, Keyboard.KEY_C);
        addObject(p1, 50, 490);
        addObject(p2, 600, 490);
        
        buildWorld();
        addHazards();
        addAutoPlatforms();
        addCoins();
        addTeleporter();
        time = new Timer();
        myTimerTask timer= new myTimerTask(this);
        time.schedule(timer,0,1000);
    }
    // empty method
   public void act(){}
   // adds in bricks for the world
   public void buildWorld()
   {
       LinkedList<Brick> bricks3 = new LinkedList<Brick>();
       //leftmost row of bricks
        for(int i = 10; i < 580; i++)
        {
            Brick b = new Brick();
            addObject(b, 5, i);
            bricks3.add(b);
            i = i+15;
        }
        
        //top row of bricks
        for(int x = 5; x < 770; x++)
        {
            Brick b = new Brick();
            addObject(b, x, 10);
            bricks3.add(b);
            x = x+ 15;
        }
        //bottom row of bricks
        for(int x = 10; x < 770; x++)
        {
            Brick b = new Brick();
            addObject(b, x, 570);
            bricks3.add(b);
            x = x+15;
        }
        //rightmost row of bricks

        for(int y = 10;  y<580; y++)
        {
            Brick b = new Brick();
            addObject(b, 770, y);
            bricks3.add(b);
            y = y+15;
        }
        
        //end of brick code for square frame
        
        //center square at bottom of screen
        for(int x = 350; x <400; x++)
        {
            Brick b = new Brick();
            addObject(b, x, 520);
            bricks3.add(b);
            x=x+15;
        }
        for(int y = 520; y <750; y++)
        {
            Brick b = new Brick();
            Brick a = new Brick();
            addObject(b, 350, y);
            addObject(a, 400, y);
            bricks3.add(b);
            bricks3.add(a);
            y=y+15;
        }
        
        
        // brick layer near bottom of screen w/ coins
        for(int x = 5; x < 770; x++)
        {
            Brick b = new Brick();
            addObject(b, x, 450);
            bricks3.add(b);
            x=x+15;
        }
        
        //layer of bricks the doors are placed on
        for(int x = 150; x < 650; x++)
        {
            Brick b = new Brick();
            addObject(b, x, 375);
            bricks3.add(b);
            x=x+15;
        }
        
        //side columns
        for(int y = 375; y > 100; y--)
        {
            Brick b = new Brick();
            Brick a = new Brick();
            addObject(b, 200, y);
            addObject(a, 600, y);
            bricks3.add(b);
            bricks3.add(a);
            y = y-15;
        }
        
        
        //top row of bricks with coins on them
        for(int x = 90; x <300; x++)
        {
            Brick b = new Brick();
            addObject(b, x, 90);
            bricks3.add(b);
            x=x+15;
        }
        for(int x = 450; x < 690; x++)
        {
            Brick b = new Brick();
            addObject(b, x, 90);
            bricks3.add(b);
            x=x+15;
        }
        
        //large middle square between the doors
        for(int x = 365; x < 425; x++)
        {
            Brick b = new Brick();
            addObject(b, x, 200);
            bricks3.add(b);
            x=x+15;
        }
        for(int y = 200; y < 375; y++)
        {
            Brick b = new Brick();
            Brick a = new Brick();
            addObject(b, 365, y);
            addObject(a, 425, y);
            bricks3.add(b);
            bricks3.add(a);
            y = y+15;
        }
        
        
        
        //layer with water and lava
        for(int x = 200; x < 270; x++)
        {
            Brick b = new Brick();
            addObject(b, x, 250);
            bricks3.add(b);
            x=x+15;
        }
        for(int x = 520; x < 585; x++)
        {
            Brick b = new Brick();
            addObject(b, x, 250);
            bricks3.add(b);
            x=x+15;
        }
   }
   // adds the hazards (water, lava)
   public void addHazards()
   {

     
     lava1 = new smallerLava();
     addObject(lava1, 230, 240);
     lava1.initialize();
     
     water1 = new smallerWater();
     addObject(water1, 540, 240);
     water1.initialize();
     
     lava2 = new smallerLava();
     addObject(lava2, 170,550);
     lava2.initialize();
     
     // water2 = new smallerWater();
     // addObject(water2, 500, 550);
     // water2.initialize();
   }
    // adds platforms that oscillate automatically   
   public void addAutoPlatforms()
   {
       
       bLeft = new AutoPlatformVertical(20,40);
        bRight = new AutoPlatformVertical(20,40);
        addObject(bLeft,300,540);
        addObject(bRight,440,540);
        bLeft.initialize();
        bRight.initialize();
        platform1 = new AutoPlatformVertical(20,400);
        platform2 = new AutoPlatformVertical(20,400);
        addObject(platform1, 40,100);
        addObject(platform2, 710,100);
        platform1.initialize();
        platform2.initialize();
        // platform3 = new AutoPlatformHorizontal();
        // addObject(platform3, 390, 85);
        // platform3.initialize();
    }
    // adds coins to be collected by the player
    public void addCoins()
    {
        //18 coins
        addObject(new LevelThreeCoins(), 200, 420);
        addObject(new LevelThreeCoins(), 100, 420);
        addObject(new LevelThreeCoins(), 600, 420);
        addObject(new LevelThreeCoins(), 700, 420);
        addObject(new LevelThreeCoins(), 40, 200);
        addObject(new LevelThreeCoins(), 40, 150);
        addObject(new LevelThreeCoins(), 40, 105);
        addObject(new LevelThreeCoins(), 710,200);
        addObject(new LevelThreeCoins(), 710, 150);
        addObject(new LevelThreeCoins(), 710, 105);
        addObject(new LevelThreeCoins(), 250, 70);
        addObject(new LevelThreeCoins(), 520, 70);
        addObject(new LevelThreeCoins(), 360,180);
        addObject(new LevelThreeCoins(), 440, 180);
        addObject(new LevelThreeCoins(), 200, 550);
        addObject(new LevelThreeCoins(), 300, 550);
        addObject(new LevelThreeCoins(), 500, 550);
        addObject(new LevelThreeCoins(), 600, 550);
    }
    
    // adds the teleporters that teleport the player when touched
    public void addTeleporter()
    {
        addObject(new teleporterMachine(), 310, 500);
        addObject(new teleporterMachine(), 420, 500);
    }
}
