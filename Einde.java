import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Einde here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Einde extends Omgeving
{

    /**
     * Constructor for objects of class Einde.
     * 
     */
    
    Player _player;
    
    public Einde()
    {
        super(WorldSizeX, WorldSizeY, PixelSize);
        
        _player = initializePlayer();
        
        ActiveBar healthBar = _player.getHealthBar();
        ActiveBar ammoBar = _player.getAmmoBar();
        _player.setPlayerState(PlayerState.Normaal);
        addObject(_player, 600, 400);
        
        
        addObject(healthBar, 220, 760);
        int healthBarX = 30 + healthBar.getValue() / 2;
        healthBar.setLocation(healthBarX, 760);
        
        addObject(ammoBar, 30, 720);
        int ammoBarX = 30 + ammoBar.getValue() / 2;
        ammoBar.setLocation(ammoBarX, 720);
        
        GreenfootImage bg = new GreenfootImage("/backgrounds/einde/einde_wakker_worden.png");
        setBackground(bg);
        
        NieuweText("Attentie! Je hebt het vaccin gevonden, goedzo. We hebben een antivirus je bent onze redder!", 26, Color.WHITE, null, 600, 600);
        NieuweText("Het was een simulatie zodat jij het vaccin kon vinden", 26, Color.WHITE, null, 600, 625);
        
        MuurPlaatsingen();
    }
    
    private void MuurPlaatsingen() {
        NieuweOnzichtbareMuur(750, 400, 50, 800);
        NieuweOnzichtbareMuur(375, 400, 50, 800);
        NieuweOnzichtbareMuur(600, 575, 1200, 50);
        NieuweOnzichtbareMuur(600, 200, 1200, 50);
    }
}
