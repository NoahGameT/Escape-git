import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends SmoothMover
{
    /// 
    /// Player class
    ///
    /// In deze class worden alle methodes van de speler gedefinieerd.
    ///
    GreenfootImage playerImage = getImage();
    public int playerDimensionX = playerImage.getWidth();
    public int playerDimensionY = playerImage.getHeight();
    
    public int movementSpeed = 3; // Pixels per frame.
    private boolean UpInput = true;
    private boolean LeftInput = true;
    private boolean RightInput = true;
    private boolean DownInput = true;
    private boolean WallCollide = false;
    
    public Player() {
        System.out.println("X: " + playerDimensionX + " Y: " + playerDimensionY);
    }
    
    public void act() 
    {
        movePlayer();
        Collision(Muur.class);
        Collision(Politie.class);
    }
    
    private int[] getPlayerInput() {
        int[] inputs = {0,0};
        if (Greenfoot.isKeyDown("w") && UpInput == true) {
            inputs[1] += -1;
        } 
        if (Greenfoot.isKeyDown("s") && DownInput == true) {
            inputs[1] += 1;
        }
        if (Greenfoot.isKeyDown("a") && LeftInput == true) {
            inputs[0] += -1;
        }
        if (Greenfoot.isKeyDown("d") && RightInput == true) {
            inputs[0] += 1;
        }
        return inputs;
    }
    
    private void movePlayer() {
        int[] playerInput = getPlayerInput();
        UpInput = true;
        LeftInput = true;
        RightInput = true;
        DownInput = true;
        setLocation(getX() + playerInput[0] * movementSpeed, getY() + playerInput[1] * movementSpeed);
        if (atEdge('l')) {
            LeftInput = false;
        }
        if (atEdge('r')) {
            RightInput = false;
        }
        if(atEdge('u')) {
            UpInput = false;
        }
        if(atEdge('d')) {
            DownInput = false;
        }
    }
    
    private boolean atEdge(char _dir) {
        if (_dir == 'l') {
            
           if (getX() <= playerDimensionX/2) {
               return true;
           }
           else {
               return false;
           }
           
        } else if (_dir == 'r') {
            
           if (getX() >= (Omgeving.WorldSizeX - playerDimensionX/2)) {
               return true;
           }
           else {
               return false;
           }
           
        } else if(_dir == 'u') {
           
           if (getY() <= playerDimensionY/2) {
               System.out.println(getY() + " " + playerDimensionY);
               return true;
           } else {
               return false;
           }           
        } else if(_dir == 'd') { 
           
           if (getY() >= (Omgeving.WorldSizeY - playerDimensionY/2)) {
               return true;
           } else {
               return false;
           }
           
        } else {
            System.out.println("[!] atEdge kreeg geen correcte character als parameter!");
            return false;
            
        }
    }
    
    public void Collision(java.lang.Class collider) {
        Actor actor = getOneIntersectingObject(collider);
        if(actor != null) {
            int x = actor.getX();
            int y = actor.getY();
            System.out.println("Collision: " + x + " " + y);
            if(x < getX()) {
                LeftInput = false;
            } else {
                RightInput = false;
            }
            if (y < getY()) {
                UpInput = false;
            } else {
                DownInput = false;
            }
        }
    }
}














