import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class VaccinWereld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VaccinWereld extends Omgeving
{

    /**
     * Constructor for objects of class VaccinWereld.
     * 
     */
    Player _player;
    Vaccin vaccin = new Vaccin();
    public VaccinWereld()
    {
        super(WorldSizeX, WorldSizeY, PixelSize);
        
        _player = initializePlayer();
        
        ActiveBar healthBar = _player.getHealthBar();
        ActiveBar ammoBar = _player.getAmmoBar();
        addObject(_player, 1150, 400);
        
        addObject(healthBar, 220, 760);
        int healthBarX = 30 + healthBar.getValue() / 2;
        healthBar.setLocation(healthBarX, 760);
        
        addObject(ammoBar, 30, 720);
        int ammoBarX = 30 + ammoBar.getValue() / 2;
        ammoBar.setLocation(ammoBarX, 720);
        
        GreenfootImage bg = new GreenfootImage("/backgrounds/vaccinWereld/background.png");
        setBackground(bg);
        
        NieuweInfoBlok("Hey! het vaccin!!! Ik pak het snel op!", 1000, 400);
        
        addObject(vaccin, 250, 400);
        
        MuurPlaatsingen();
    }
    
    public void Act() {
        if (vaccin.getOnPlayer()) {
            Greenfoot.setWorld(new Einde());
        }
    }
    
    private void MuurPlaatsingen() {
    }
}
