import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sleutels here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sleutels extends Actor
{
    /**
     * Act - do whatever the Sleutels wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    Player player;
    Actor politie;
    
    public Sleutels(Player _player, Actor _politie) {
        player = _player;
        politie = _politie;
        getImage().scale(23,10);
    }
    
    public void act() 
    {
        if(keyInReach()) {
            player.keyCanBePickedUp = true;
        } else {
            player.keyCanBePickedUp = false;
        }
        if (player.gotKey) {
            setLocation(player.getX()-10, player.getY() + 20);
        } else {
            setLocation(politie.getX()-10, politie.getY() + 20);
        }
    }
    
    private boolean keyInReach() {
        int polX = politie.getX();
        int polY = politie.getY();
        int pX = player.getX();
        int pY = player.getY();
        int pdX = player.playerDimensionX;
        int pdY = player.playerDimensionY;
        
        if ((-pdX *2) + pX < polX && polX < (pdX *2) + pX && pY > polY) {
            return true;
        }
        return false;
    }
}
