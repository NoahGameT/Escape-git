import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Level4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level4 extends Omgeving
{

    /**
     * Constructor for objects of class Level4.
     * 
     */
    
    Player _player;
    public Level4()
    {
        super(WorldSizeX, WorldSizeY, PixelSize);
        
        _player = initializePlayer();
        
        ActiveBar healthBar = _player.getHealthBar();
        ActiveBar ammoBar = _player.getAmmoBar();
        addObject(_player, 50, 400);
        
        addObject(healthBar, 220, 760);
        int healthBarX = 30 + healthBar.getValue() / 2;
        healthBar.setLocation(healthBarX, 760);
        
        addObject(ammoBar, 30, 720);
        int ammoBarX = 30 + ammoBar.getValue() / 2;
        ammoBar.setLocation(ammoBarX, 720);
        
        GreenfootImage bg = new GreenfootImage("/backgrounds/lvl_4/begane_grond_ziekenhuis.png");
        setBackground(bg);
        
        MuurPlaatsingen();
        
        NieuweInfoBlok("Ik moet op zoek naar dat vaccin in het ziekenhuis, ik pak de lift!", 200, 400);
        
        SpawnInfected(1, 600, 400);
        
        LevelBlock lvlblock = new LevelBlock();
        addObject(lvlblock, 1200, 400);
    }
    
    public void act() {
        
    }
    
    private void MuurPlaatsingen() {
        NieuweOnzichtbareMuur(610, 0, 500, 100);
    }
}
