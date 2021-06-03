import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PreLevel3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PreLevel3 extends Omgeving
{

    /**
     * Constructor for objects of class PreLevel3.
     * 
     */
    private Player player;
    
    private Actor healthBar;
    private Actor healthBorderBar;
    private Actor healthEmptyBar;
        
    // Ammo bar
    private Actor ammoBar;
    private Actor ammoBorderBar;
    private Actor ammoEmptyBar;
    
    public PreLevel3()
    {
        super(WorldSizeX, WorldSizeY, PixelSize);
        player = getPlayer();
        
        // Initializeer objecten voor de health bar.
        Actor healthBar = player.getHealthBar();
        Actor healthBorderBar = new Bar(390, 30, Color.BLACK);
        Actor healthEmptyBar = new Bar(380, 20, Color.WHITE);
        
        // Initializeer objecten voor de ammo bar.
        Actor ammoBar = player.getAmmoBar();
        Actor ammoBorderBar = new Bar(210, 30, Color.BLACK);
        Actor ammoEmptyBar = new Bar(200, 20, Color.WHITE);
        
        if (player == null) {
            // Health bar
            healthBar = new ActiveBar(380, 20, Color.RED, "health");
            healthBorderBar = new Bar(390, 30, Color.BLACK);
            healthEmptyBar = new Bar(380, 20, Color.WHITE);
                
            // Ammo bar
            ammoBar = new ActiveBar(200, 20, Color.YELLOW, "ammo");
            ammoBorderBar = new Bar(210, 30, Color.BLACK);
            ammoEmptyBar = new Bar(200, 20, Color.WHITE);
            
            player = createPlayer(healthBar, ammoBar);
        }
        
        // Objecten toevoegen aan de wereld voor de health bar
        addObject(healthBorderBar, 220, 760);
        addObject(healthEmptyBar, 220, 760);
        addObject(healthBar, 220, 760);
        // Set the health bar to the right position.
        ActiveBar healthBar2 = (ActiveBar)healthBar;
        int healthBarX = 30 + healthBar2.getValue() / 2;
        healthBar.setLocation(healthBarX, 760);
        
        // Objecten toevoegen voor de ammo bar
        addObject(ammoBorderBar, 130, 720);
        addObject(ammoEmptyBar, 130, 720);
        addObject(ammoBar, 30, 720);
        // Set the ammo bar to the right position.
        ActiveBar ammoBar2 = (ActiveBar)ammoBar;
        int ammoBarX = 30 + ammoBar2.getValue() / 2;
        ammoBar.setLocation(ammoBarX, 720);
        
        
        GreenfootImage background = new GreenfootImage("/backgrounds/prelvl_3/background.png");
        setBackground(background);
        addObject(player, 50, 400);
        MuurPlaatsingen();
    }
    
    private void MuurPlaatsingen() {
        NieuweOnzichtbareMuur(600, 50, 1200, 100);
        NieuweOnzichtbareMuur(600, 650, 1200, 300);
    }
}
