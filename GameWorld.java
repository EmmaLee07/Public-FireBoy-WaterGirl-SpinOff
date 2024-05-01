import mayflower.*;
import java.time.Instant.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.LinkedList;
/**
The first game world
This class builds the world by creating the array that can be used to put the
bricks in certain spots and have the characters define where they are
 */
public class GameWorld extends World
{
    private String[][] tiles;
    private Brick brick1;
    private Player p1;
    private Player p2;
    private Timer time;
    private smallerLava lava1;
    private smallerWater water1;
    private Button button1;
    private Lever lever1;
    private Button button2;
    private Platform platform1;
    private Platform platform2;
    private Button button3;
    private Button button4;
    private Coins coins1;
    private Coins coins2;
    private Coins coins3;
    private Coins coins4;
    private Coins coins5;
    private Coins coins6;
    private Coins coins7;
    private MovableBlock midBlock;
    private WaterboyDoor waterdoor; 
    private FiregirlDoor firedoor; 
    // constructor
    public GameWorld()
    {

        MayflowerImage p = new MayflowerImage("img/BrownBackground.jpg");
        p.scale(6);
        setBackground(p);

        p1 = new Player(Keyboard.KEY_UP, Keyboard.KEY_DOWN, Keyboard.KEY_LEFT, Keyboard.KEY_RIGHT, Keyboard.KEY_LSHIFT);
        p2 = new Player(Keyboard.KEY_W, Keyboard.KEY_S, Keyboard.KEY_A, Keyboard.KEY_D, Keyboard.KEY_C);

        addObject(p1,550,50);
        addObject(p2,500,50);

        buildWorld();

        addCoins();

        time = new Timer();
        myTimerTask timer= new myTimerTask(this);
        time.schedule(timer,0,1000);

        midBlock = new MovableBlock();
        addObject(midBlock, 450,155);
        addHazards();

        addButtons();

        addUserControlledPlatforms();
        
        firedoor = new FiregirlDoor();
        addObject(firedoor, 60, 490);

        waterdoor = new WaterboyDoor();
        addObject(waterdoor, 100, 490);

    }
    // checks continuously if the player has gotten all the coins
    public void act()
    {
        /*if(MovableAnimatedActor.coinCheck == true)
        {
            MovableAnimatedActor.resetAmt();
            MovableAnimatedActor.resetCheck();
            Mayflower.setWorld(new LevelTwoGameWorld());
        }
        */
    }
    // builds the background bricks in the world
    public void buildWorld()
    {
        LinkedList<Brick> bricks = new LinkedList<Brick>();
        for(int i = 30; i < 550; i++)
        {
            Brick b = new Brick();
            addObject(b, 30, i);
            bricks.add(b);
            i = i+15;
        }

        for(int x = 40; x < 720; x++)
        {
            Brick b = new Brick();
            addObject(b, x,30);
            bricks.add(b);
            x = x+ 15;
        }

        for(int x = 40; x < 720; x++)
        {
            Brick b = new Brick();
            addObject(b, x, 540);
            bricks.add(b);
            x = x+15;
        }

        for(int y = 30;  y<540; y++)
        {
            Brick b = new Brick();
            addObject(b, 720, y);
            bricks.add(b);
            y = y+15;
        }

        //gold lever bricks
        for(int x = 40; x < 300; x++)
        {
            Brick b = new Brick();
            addObject(b, x, 400);
            bricks.add(b);
            x= x+15;
        }

        int xn=320;
        int yn=400;
        int xn2= 370;
        int yn2= 300;
        int xn3 = 500;
        int yn3 = 200;

        for(int i =0; i <30;i++)
        {
            addObject(new Brick(),xn, yn);
            xn++;
            yn++;
            addObject(new Brick(), xn2, yn2);
            yn2++;
            addObject(new Brick(), xn3, yn3);
            xn3++;
            yn3++;
        }

       
        //dissapearing platform and first purple button
        for(int x = 120; x <375; x++)
        {
            Brick b = new Brick();
            addObject(b, x, 300);
            bricks.add(b);
            x=x+15;
        }

        for(int x = 350; x <600; x++)
        {
            Brick b = new Brick();
            addObject(b, x, 430);
            bricks.add(b);
            x=x+15;
        }

        for(int x =40; x < 290; x++)
        {
            Brick b = new Brick();
            addObject(b, x, 470);
            bricks.add(b);
            x=x+15;
        }

        for(int x = 680; x < 700; x++)
        {
            Brick b = new Brick();
            addObject(b, x, 470);
            bricks.add(b);
            x=x+15;
        }

        for(int x = 680; x <700;x++)
        {
            Brick b = new Brick();
            addObject(b, x, 480);
            bricks.add(b);
            x=x+15;
        }

        for(int x = 680; x <700;x++)
        {

            Brick b = new Brick();
            addObject(b, x, 490);
            bricks.add(b);
            x=x+15;
        }

        for(int x = 680; x <700;x++)
        {

            Brick b = new Brick();
            addObject(b, x, 500);
            bricks.add(b);
            x=x+15;
        }

        for(int x = 680; x <700;x++)
        {

            Brick b = new Brick();
            addObject(b, x, 510);
            bricks.add(b);
            x=x+15;
        }
        for(int x = 680; x <700;x++)
        {

            Brick b = new Brick();
            addObject(b, x, 520);
            bricks.add(b);
            x=x+15;
        }
        for(int x = 680; x <700;x++)
        {
            Brick b = new Brick();
            addObject(b, x, 530);
            bricks.add(b);
            x=x+15;
        }
        for(int x =400; x <700;x++)
        {
            Brick b = new Brick();
            addObject(b, x, 330);
            bricks.add(b);
            x=x+15;
        }
        for(int x = 400; x <500;x++)
        {
            Brick b = new Brick();
            addObject(b, x, 200);
            bricks.add(b);
            x=x+15;
        }
        for(int y = 200; y <230; y++)
        {
            Brick b = new Brick();
            addObject(b, 400, y);
            bricks.add(b);
            y=y+15;
        }
        //second purple button
        for(int x = 550; x <630; x++)
        {
            Brick b = new Brick();
            addObject(b, x, 230);
            bricks.add(b);
            x=x+15;
        }
        for(int x = 400; x >40; x--)
        {

            Brick b = new Brick();
            addObject(b, x, 230);
            bricks.add(b);
            x=x-15;
        }
        for(int y=230; y>150; y--)
        {

            Brick b = new Brick();
            addObject(b, 100, y);
            bricks.add(b);
            y=y-15;
        }
        for(int x = 100; x>40; x--)
        {

            Brick b = new Brick();
            addObject(b, x, 150);
            bricks.add(b);
            x=x-15;
        }
        for(int x = 200; x <700; x++)
        {
            Brick b = new Brick();
            addObject(b, x, 125);
            bricks.add(b);
            x=x+15;
        }
        for(int x = 400; x >40; x--)
        {
            Brick b = new Brick();
            addObject(b, x, 230);
            bricks.add(b);
            x=x-15;
        }
    }
    // adds the coins to the world
    public void addCoins()
    {
        coins1 = new Coins();
        addObject(coins1, 400, 500);

        coins2 = new Coins();
        addObject(coins2, 545, 500);

        coins3 = new Coins();
        addObject(coins3, 165, 260);

        coins4 = new Coins();
        addObject(coins4, 455, 285);

        coins5 = new Coins();
        addObject(coins5, 70, 125);

        coins6 = new Coins();
        addObject(coins6, 238, 65);

        coins7 = new Coins();
        addObject(coins7, 458, 105);

    }
    // adds obstacles (lava, water)
    public void addHazards()
    {
        lava1 = new smallerLava();
        addObject(lava1, 350,530);
        lava1.initialize();

        water1= new smallerWater();
        addObject(water1, 500, 530);
        water1.initialize();
    }
    // adds buttons that turn on the moving platforms.
    public void addButtons()
    {
        button1 = new Button();
        addObject(button1, 200, 290);

        button2 = new Button();
        addObject(button2, 200,380);

        button3 = new Button();
        addObject(button3, 600, 220);

        button4 = new Button();
        addObject(button4, 550, 320);
    }
    // adds the platforms controlled by buttons
    public void addUserControlledPlatforms()
    {
        platform1 = new Platform(button1, button2);
        addObject(platform1, 60,300);
        platform1.initialize();

        platform2 = new Platform(button3, button4);
        addObject(platform2, 650, 230);
        platform2.initialize();
    }

}


