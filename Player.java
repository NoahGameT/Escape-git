import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.image.BufferedImage;
/**
 * Write a description of class Player here.
 * 
 * @author Noah en Dinand
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
    
    public int health = 100;
    
    public int movementSpeed = 2; // Pixels per frame.
    private boolean UpInput = true;
    private boolean LeftInput = true;
    private boolean RightInput = true;
    private boolean DownInput = true;
    private boolean WallCollide = false;
    private char lookDirection = 'd';
    
    // Animatievariabelen
    private int animNum = 0;
    private int animationTime = 0;
    private boolean animating = false;
    
    // Barvariabelen
    public ActiveBar healthBar;
    public ActiveBar ammoBar;
    public int checkpointHealth;
    public int checkpointAmmo;
    
    // Wapenvariabelen
    public int bulletCounter = 0;
    private int maxBullets = 5;
    private boolean hasGun = false;
    private int shootCounter = 0;
    private int shootingSpeed = 120; // interval in Acts
    private boolean firstShot = true;
    
    // Ammovariabelen
    private int ammo = 0; // Initial value.
    private int maxAmmo = 100;
    
    // Sleutel variabelen
    public boolean keyCanBePickedUp;
    public boolean keyIsPickedUp = false;
    public boolean gotKey = false;
    
    
    private boolean gameover = true;
    
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
    
    public Player(Actor _healthBar, Actor _ammoBar) {
        GreenfootImage img = getImage();
        img.scale(imageScaleX,imageScaleY);
        healthBar = (ActiveBar)_healthBar;
        ammoBar = (ActiveBar)_ammoBar;
    }
    
    public void act() 
    {
        movePlayer();
        checkKeys();
        Collision(Politie.class);
        Collision(OnzichtbareMuur.class);
        Collision(Muur.class);
        checkHitInfected();
        checkHitHealthPack();
        checkHitAmmo();
        checkHitVaccin();
        if (keyCanBePickedUp) {
            if (Greenfoot.isKeyDown("e")) {
                gotKey = true;
            }
        }        
    }
    
    public void setGameOver(boolean state) {
        gameover = state;
    }
    
    public boolean getGameOver() {
        return gameover;
    }
    
    private void checkKeys() {
        if (Greenfoot.isKeyDown("space") && firstShot) {
            shootCounter = shootingSpeed;
            firstShot = false;
        }
        if (!Greenfoot.isKeyDown("space")) {
            firstShot = true;
        }
        if (Greenfoot.isKeyDown("space") && bulletCounter < maxBullets && hasGun && shootCounter == shootingSpeed && ammo > 0) {
            fireBullet();
            shootCounter = 0;
            ammo--;
            ammoBar.changeValue(-(200/maxAmmo));
        }
        shootCounter++;
    }
    
    /**
     * Maak een nieuwe kogel en zet het op de juiste plek.
     */
    private void fireBullet() {
        getWorld().addObject(new Bullet(this), getX(), getY());
        bulletCounter++;
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
    
    /**
     * Check if the player has hit an infected. If so, remove the infected and reduce the health.
     */
    private void checkHitInfected() {
        for (Object obj : getIntersectingObjects(Infected.class)) {
            Actor actor = (Actor) obj;
            if(actor != null) {
                healthBar.changeValue(-130);
                Greenfoot.playSound("player_hit.wav");
                getWorld().removeObject(actor);
                Greenfoot.playSound("infected_death.wav");
            }
        }
    }
    
    /**
     * Increase the player's health if he has hit a health pack and if the current value of health is not maximal.
     */
    private void checkHitHealthPack() {
        for (Object obj : getIntersectingObjects(HealthPack.class)) {    
            Actor actor = (Actor) obj;
            if (actor != null) {
                int health = healthBar.getValue();
                if (health < 380) {
                    healthBar.changeValue(76);
                    getWorld().removeObject(actor);
                }
            }
        }
    }
    
    /**
     * Increase the player's ammo if the player has collided with an ammo pack.
     * The player's amount of ammo may not exceed the value of 'maxAmmo'.
     */
    private void checkHitAmmo() {
        for (Object obj : getIntersectingObjects(Ammo.class)) {  
            if (ammo == 0) {
                setGunState(true);
            }
            Actor actor = (Actor) obj;
            if (actor != null && ammo < maxAmmo) {
                int freeSpace = maxAmmo - ammo; // The amount of ammo which the player can pick up.
                Ammo actorAmmo = (Ammo) actor;
                if (freeSpace < 10) {
                    // If the player's free space is less than 10, only pick up what's needed and don't remove the pack: simply decrease its value.
                    ammo += freeSpace;
                    actorAmmo.setValue(freeSpace);
                    ammoBar.changeValue(200 / freeSpace);
                } else {
                    // Pick up all of the ammo and remove the ammo pack.
                    ammo += 10;
                    getWorld().removeObject(actor);
                    ammoBar.changeValue(20);
                }
            }
        }
    }
    
    private void checkHitVaccin() {
        for (Object obj : getIntersectingObjects(Vaccin.class)) {  
            Actor actor = (Actor) obj;
            if (actor != null) {
                Vaccin vaccin = (Vaccin)actor;
                vaccin.OnPlayer();
            }
        }
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
                
                
                int x1 = x - sizeX/2; // X-cor of the left side.
                int x2 = x + sizeX/2; // X-cor of the right side.
                int playerXLeft = getX() - playerDimensionX/2;
                int playerXRight = getX() + playerDimensionX/2;
                
                
                
                if (x1 > playerXRight) {
                    RightInput = false;
                }
                if (x2 < playerXLeft) {
                    LeftInput = false;
                }
                
                int y1 = y - sizeY/2; // Y-cor of the top.
                int y2 = y + sizeY/2; // Y-cor of the bottom.
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
            lookDirection = 'd';
        } else if (_playerInput[1] < 0) {
            PlayAnimation(AnimationSpriteSheet[1]);
            lastPlayedSprite = AnimationSpriteSheet[1];
            lookDirection = 'u';
        } else if (_playerInput[0] > 0) {
            PlayAnimation(AnimationSpriteSheet[2]);
            lastPlayedSprite = AnimationSpriteSheet[2];
            lookDirection = 'r';
        } else if (_playerInput[0] < 0) {
            PlayAnimation(AnimationSpriteSheet[3]);
            lastPlayedSprite = AnimationSpriteSheet[3];
            lookDirection = 'l';
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
            animNum++;
            animationTime = 0;
        }
    }
    
    private void StopAnimation() {
        animating = false;
        if (lastPlayedSprite != null) {
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
    
    /**
     * Change the player's hasGun state.
     */
    public void setGunState(boolean _hasGun) {
        hasGun = _hasGun;
        // Since this method will only be called when the player picks up the gun, it can be used to give the player's first ammo.
        ammo = 10;
        ammoBar.changeValue(20);
    }
    
    public char getPlayerDirection() {
        return lookDirection;
    }
    
    public ActiveBar getHealthBar() {
        return (ActiveBar)healthBar;
    }
    
    public ActiveBar getAmmoBar() {
        return (ActiveBar)ammoBar;
    }
    
    public void addAmmo(int _ammo) {
        ammo += _ammo; // Voeg ammo toe aan de speler.
    }
    
    public void setCheckpointHealth(int health) {
        checkpointHealth = health;
    }
    
    public void setCheckpointAmmo(int ammo) {
        checkpointAmmo = ammo;
    }
}














