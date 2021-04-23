import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.image.BufferedImage;
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends ExtraFuncties
{
    /// 
    /// Player class
    ///
    /// In deze class worden alle methodes van de speler gedefinieerd.
    ///
    GreenfootImage playerImage = getImage();
    public int playerDimensionX = playerImage.getWidth();
    public int playerDimensionY = playerImage.getHeight();
    
    private int imageScaleX = 75;
    private int imageScaleY = 120;
    
    
    public int movementSpeed = 5; // Pixels per frame.
    private boolean UpInput = true;
    private boolean LeftInput = true;
    private boolean RightInput = true;
    private boolean DownInput = true;
    private boolean WallCollide = false;
    
    // Animatie variabelen
    private int animNum = 0;
    private int animationTime = 0;
    private boolean animating = false;
    
    GreenfootImage[] loopDownImages = {new GreenfootImage("/lopenNormal/down/loop-animatie-1.png"), new GreenfootImage("/lopenNormal/down/loop-animatie-2.png"), new GreenfootImage("/lopenNormal/down/loop-animatie-3.png"), new GreenfootImage("/lopenNormal/down/loop-animatie-4.png")};
    GreenfootImage[] loopUpImages = {new GreenfootImage("/lopenNormal/up/loop-up-animatie-1.png"), new GreenfootImage("/lopenNormal/up/loop-up-animatie-2.png"), new GreenfootImage("/lopenNormal/up/loop-up-animatie-3.png"), new GreenfootImage("/lopenNormal/up/loop-up-animatie-4.png")};
    GreenfootImage[] loopRightImages = {new GreenfootImage("/lopenNormal/right/loop-right-animatie-1.png"), new GreenfootImage("/lopenNormal/right/loop-right-animatie-2.png"), new GreenfootImage("/lopenNormal/right/loop-right-animatie-3.png"), new GreenfootImage("/lopenNormal/right/loop-right-animatie-4.png")};
    GreenfootImage[] loopLeftImages = {new GreenfootImage("/lopenNormal/left/loop-left-animatie-1.png"), new GreenfootImage("/lopenNormal/left/loop-left-animatie-2.png"), new GreenfootImage("/lopenNormal/left/loop-left-animatie-3.png"), new GreenfootImage("/lopenNormal/left/loop-left-animatie-4.png")};
    public Player() {
        System.out.println("X: " + playerDimensionX + " Y: " + playerDimensionY);
        GreenfootImage img = getImage();
        img.scale(imageScaleX,imageScaleY);
    }
    
    public void act() 
    {
        movePlayer();
        Collision(Muur.class);
        Collision(Politie.class);
        Collision(OnzichtbareMuur.class);
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
        AnimatePlayer(playerInput);
    }
    
    private boolean atEdge(char _dir) {
        if (_dir == 'l') {
            
           if (getX() <= playerDimensionX) {
               return true;
           }
           else {
               return false;
           }
           
        } else if (_dir == 'r') {
            
           if (getX() >= (Omgeving.WorldSizeX - playerDimensionX)) {
               return true;
           }
           else {
               return false;
           }
           
        } else if(_dir == 'u') {
           
           if (getY() <= playerDimensionY) {
               System.out.println(getY() + " " + playerDimensionY);
               return true;
           } else {
               return false;
           }           
        } else if(_dir == 'd') { 
           
           if (getY() >= (Omgeving.WorldSizeY - playerDimensionY)) {
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
            GreenfootImage colliderImage = actor.getImage();
            int sizeX = colliderImage.getWidth();
            int sizeY = colliderImage.getHeight();
            
            
            int x1 = x - sizeX/2;
            int x2 = x + sizeX/2;
            int playerXRight = getX() - playerDimensionX/2;
            int playerXLeft = getX() + playerDimensionX/2;
            
            
            
            if (x1 > playerXLeft) {
                RightInput = false;
            } else {
                RightInput = true;
            }
            if (x2 < playerXRight) {
                LeftInput = false;
            } else {
                LeftInput = true;
            }
            
            int y1 = y - sizeY/2;
            int y2 = y + sizeY/2; 
            int playerYOnder = getY() + playerDimensionY/2;
            int playerYBoven = getY() - playerDimensionY/2;
            
            if (y1 > playerYOnder) {
                DownInput = false;
            } else {
                DownInput = true;
            }
            
            if (y2 < playerYBoven) {
                UpInput = false;
            } else {
                UpInput = true;
            }
        }
        
    }
    
    private void AnimatePlayer(int[] _playerInput) {
        if(_playerInput[0] == 0 && _playerInput[1] == 0) {
            StopAnimation();
        }
        else if (_playerInput[1] > 0) {
            PlayAnimation(loopDownImages);
        } else if (_playerInput[1] < 0) {
            PlayAnimation(loopUpImages);
        } else if (_playerInput[0] > 0) {
            PlayAnimation(loopRightImages);
        } else if (_playerInput[0] < 0) {
            PlayAnimation(loopLeftImages);
        } else {
            StopAnimation();
        }
    }
    
    private void PlayAnimation(GreenfootImage[] images) {
        if (animNum == images.length) {
            animNum = 0;
        }
        if(animating) {
           setImage(images[animNum]);
           GreenfootImage image = getImage();
           image.scale(imageScaleX, imageScaleY);
        } else {
           animNum = 0;
           animating = true;
           return;
        }
        animationTime++;
        if (animationTime == Omgeving.speed / movementSpeed) {
            animNum += 1;
            animationTime = 0;
        }
    }
    
    private void StopAnimation() {
        animating = false;
        setImage(loopDownImages[0]);
        GreenfootImage image = getImage();
        image.scale(imageScaleX, imageScaleY); 
        animNum = 0;
        return;
    }
    
    public int[] getPlayerPos() {
        int[] pos = {getX(), getY()};
        return pos;
    }
}














