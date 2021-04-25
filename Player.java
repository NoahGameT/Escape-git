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
    
    
    public int movementSpeed = 2; // Pixels per frame.
    private boolean UpInput = true;
    private boolean LeftInput = true;
    private boolean RightInput = true;
    private boolean DownInput = true;
    private boolean WallCollide = false;
    
    // Animatie variabelen
    private int animNum = 0;
    private int animationTime = 0;
    private boolean animating = false;
    
    /* 
     * 
     * Alle sprites per level en per item pickup
     * 
     */
    
    /// Normale loop sprites
    GreenfootImage[][] normaleImages = {{new GreenfootImage("/Player/normaal/down/loop-animatie-1.png"), new GreenfootImage("/Player/normaal/down/loop-animatie-2.png"), new GreenfootImage("/Player/normaal/down/loop-animatie-3.png"), new GreenfootImage("/Player/normaal/down/loop-animatie-4.png")}, 
    {new GreenfootImage("/Player/normaal/up/loop-up-animatie-1.png"), new GreenfootImage("/Player/normaal/up/loop-up-animatie-2.png"), new GreenfootImage("/Player/normaal/up/loop-up-animatie-3.png"), new GreenfootImage("/Player/normaal/up/loop-up-animatie-4.png")},
    {new GreenfootImage("/Player/normaal/right/loop-right-animatie-1.png"), new GreenfootImage("/Player/normaal/right/loop-right-animatie-2.png"), new GreenfootImage("/Player/normaal/right/loop-right-animatie-3.png"), new GreenfootImage("/Player/normaal/right/loop-right-animatie-4.png")},
    {new GreenfootImage("/Player/normaal/left/loop-left-animatie-1.png"), new GreenfootImage("/Player/normaal/left/loop-left-animatie-2.png"), new GreenfootImage("/Player/normaal/left/loop-left-animatie-3.png"), new GreenfootImage("/Player/normaal/left/loop-left-animatie-4.png")}};
    
    /// Gevangenen loop sprites
    GreenfootImage[][] gevangenenImages = {{new GreenfootImage("/Player/gevangenen/down/1.png"), new GreenfootImage("/Player/gevangenen/down/2.png"), new GreenfootImage("/Player/gevangenen/down/3.png"), new GreenfootImage("/Player/gevangenen/down/4.png")}, 
    {new GreenfootImage("/Player/gevangenen/up/1.png"), new GreenfootImage("/Player/gevangenen/up/2.png"), new GreenfootImage("/Player/gevangenen/up/3.png"), new GreenfootImage("/Player/gevangenen/up/4.png")},
    {new GreenfootImage("/Player/gevangenen/right/1.png"), new GreenfootImage("/Player/gevangenen/right/2.png"), new GreenfootImage("/Player/gevangenen/right/3.png"), new GreenfootImage("/Player/gevangenen/right/4.png")},
    {new GreenfootImage("/Player/gevangenen/left/1.png"), new GreenfootImage("/Player/gevangenen/left/2.png"), new GreenfootImage("/Player/gevangenen/left/3.png"), new GreenfootImage("/Player/gevangenen/left/4.png")}};
    
    // Normale pistool sprites
    GreenfootImage[][] normaalPistoolImages = {};
    
    // Gevangenen pistool sprites
    GreenfootImage[][] gevangenenPistoolImages = {{new GreenfootImage("/Player/gevangenen_pistool/down/1.png"), new GreenfootImage("/Player/gevangenen_pistool/down/2.png"), new GreenfootImage("/Player/gevangenen_pistool/down/3.png"), new GreenfootImage("/Player/gevangenen_pistool/down/4.png")}, 
    {new GreenfootImage("/Player/gevangenen_pistool/up/1.png"), new GreenfootImage("/Player/gevangenen_pistool/up/2.png"), new GreenfootImage("/Player/gevangenen_pistool/up/3.png"), new GreenfootImage("/Player/gevangenen_pistool/up/4.png")},
    {new GreenfootImage("/Player/gevangenen_pistool/right/1.png"), new GreenfootImage("/Player/gevangenen_pistool/right/2.png"), new GreenfootImage("/Player/gevangenen_pistool/right/3.png"), new GreenfootImage("/Player/gevangenen_pistool/right/4.png")},
    {new GreenfootImage("/Player/gevangenen_pistool/left/1.png"), new GreenfootImage("/Player/gevangenen_pistool/left/2.png"), new GreenfootImage("/Player/gevangenen_pistool/left/3.png"), new GreenfootImage("/Player/gevangenen_pistool/left/4.png")}};
    
    private PlayerState playerSpriteState = PlayerState.Gevangenen;
    GreenfootImage[][] AnimationSpriteSheet;
    GreenfootImage[] lastPlayedSprite;
    
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
        int[] inputs = {0, 0};
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
            
           if (getX() <= getPlayerWidth()/2) {
               return true;
           }
           else {
               return false;
           }
           
        } else if (_dir == 'r') {
            
           if (getX() >= (Omgeving.WorldSizeX - getPlayerWidth()/2)) {
               return true;
           }
           else {
               return false;
           }
           
        } else if(_dir == 'u') {
           
           if (getY() <= getPlayerHeight()/2) {
               System.out.println(getY() + " " + playerDimensionY);
               return true;
           } else {
               return false;
           }           
        } else if(_dir == 'd') { 
           
           if (getY() >= (Omgeving.WorldSizeY - getPlayerHeight()/2)) {
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
        for (Object obj : getIntersectingObjects(collider))
        {
            Actor actor = (Actor) obj;
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
                }
                if (x2 < playerXRight) {
                    LeftInput = false;
                }
                
                int y1 = y - sizeY/2;
                int y2 = y + sizeY/2; 
                int playerYOnder = getY() + playerDimensionY/2;
                int playerYBoven = getY() - playerDimensionY/2;
                
                if (y1 > playerYOnder) {
                    DownInput = false;
                }
                
                if (y2 < playerYBoven) {
                    UpInput = false;
                }
            }
        }
    }
    
    private void AnimatePlayer(int[] _playerInput) {
        if (playerSpriteState == PlayerState.Normaal) {
            AnimationSpriteSheet = normaleImages;
        } else if (playerSpriteState == PlayerState.Gevangenen) {
            AnimationSpriteSheet = gevangenenImages;
        } else if (playerSpriteState == PlayerState.Gevangenen_pistool) {
            AnimationSpriteSheet = gevangenenPistoolImages;
        }
        
        
        if(_playerInput[0] == 0 && _playerInput[1] == 0) {
            StopAnimation();
        }
        else if (_playerInput[1] > 0) {
            PlayAnimation(AnimationSpriteSheet[0]);
            lastPlayedSprite = AnimationSpriteSheet[0];
        } else if (_playerInput[1] < 0) {
            PlayAnimation(AnimationSpriteSheet[1]);
            lastPlayedSprite = AnimationSpriteSheet[1];
        } else if (_playerInput[0] > 0) {
            PlayAnimation(AnimationSpriteSheet[2]);
            lastPlayedSprite = AnimationSpriteSheet[2];
        } else if (_playerInput[0] < 0) {
            PlayAnimation(AnimationSpriteSheet[3]);
            lastPlayedSprite = AnimationSpriteSheet[3];
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
        if (lastPlayedSprite != null) {
            //System.out.println("Hier gekomen");
            setImage(lastPlayedSprite[0]);
        } else {
            setImage(AnimationSpriteSheet[0][0]);
        }
        GreenfootImage image = getImage();
        image.scale(imageScaleX, imageScaleY); 
        animNum = 0;
        return;
    }
    
    private int getPlayerWidth() {
        GreenfootImage image = getImage();
        int width = image.getWidth();
        return width;
    }
    
    private int getPlayerHeight() {
        GreenfootImage image = getImage();
        int height = image.getHeight();
        return height;
    }
    
    public int[] getPlayerPos() {
        int[] pos = {getX(), getY()};
        return pos;
    }
    
    public void setPlayerState(PlayerState state) {
        playerSpriteState = state;
        return;
    }
    
    public PlayerState getPlayerState() {
        return playerSpriteState;
    }
}














