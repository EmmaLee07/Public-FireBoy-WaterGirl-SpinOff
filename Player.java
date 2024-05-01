import java.util.ArrayList;
/**
 * The player class has animations for each player (ninjagirl)
 */
public class Player extends MovableAnimatedActor
{
    private Animation walkRight;
    private Animation walkLeft;
    private Animation idleRight;
    private Animation fallLeft;
    private Animation fallRight;
    private Animation idleLeft;
    private Animation jumpRight;
    private boolean isGameOver;
    // constructor, takes in values for each keybind
    public Player(int up, int down, int left, int right, int sprint)
    {
        super(up, down, left, right, sprint);
        isGameOver = false;
        String[] wrFileNames = new String[9];
        for(int i = 1; i < wrFileNames.length + 1; i++)
            wrFileNames[i-1] = "img/ninjagirl/Run__00" + i + ".png";
       
        String[] iFileNames = new String[9];
        for(int i = 1; i < iFileNames.length + 1; i++)
            iFileNames[i-1] = "img/ninjagirl/Idle__00" + i + ".png";
           
        String[] jFileNames = new String[9];
        for(int i = 1; i < jFileNames.length + 1; i++)
            jFileNames[i-1] = "img/ninjagirl/Jump__00" + i + ".png";
            
        String[] fFileNames = new String[9];
        for(int i = 1; i < fFileNames.length + 1; i++)
            fFileNames[i-1] = "img/ninjagirl/Glide_00" + i + ".png";
            
        
       
            
            
        walkRight = new Animation(50,wrFileNames);
        setWalkRightAnimation(walkRight);
        walkRight.scale(60, 47);
        //walkRight.setBounds(8,5,52,70,);  
       
        walkLeft = new Animation(50, wrFileNames);
        walkLeft.mirrorHorizontally();
        setWalkLeftAnimation(walkLeft);
        walkLeft.scale(60, 47);
        //walkLeft.setBounds(30,30,40,60);
       
        idleRight = new Animation(50,iFileNames);
        setIdleRightAnimation(idleRight);
        idleRight.scale(60, 47);
        //idleRight.setBounds(30,30,40,60);
       
        idleLeft = new Animation(50,iFileNames);
        idleLeft.mirrorHorizontally();
        setIdleLeftAnimation(idleLeft);
        idleLeft.scale(60, 47);
        //idleLeft.setBounds(30,30,40,60);
      
        fallRight = new Animation(50,fFileNames);
        setFallRightAnimation(fallRight);
        fallRight.scale(60, 47);
       
        fallLeft = new Animation(50,fFileNames);
        fallLeft.mirrorHorizontally();
        setFallLeftAnimation(fallLeft);
        fallLeft.scale(60, 47);
        
        setAnimation(walkRight);       
    }
    // sets player to center if they fall off the map 
    public void act()
    {
        super.act();
        if(getY() > 600){
            setLocation(400,200);
        }
       
    }
    // allows player to be pushed
    public void move(int dy)
    {
        setLocation(getX(), getY() + dy);
    }
    
    
}
