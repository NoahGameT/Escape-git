import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class HealthBar here.
 * 
 * @author Dinand 
 * @version 1
 */

public class Level2 extends Omgeving
{

    /**
     * Constructor for objects of class level2.
     * 
     */
    Player _player;
    
    public Level2()
    {    
        // Create a new world with 1200x800 cells with a cell size of 1x1 pixels.
        super(WorldSizeX, WorldSizeY, PixelSize);
        
        _player = initializePlayer();
        
        
        ActiveBar healthBar = _player.getHealthBar();
        
        
        ActiveBar ammoBar = _player.getAmmoBar();
        
        GreenfootImage bg = new GreenfootImage("/backgrounds/lvl_2/map_of_neuk.jpg");
        setBackground(bg);
        GreenfootImage image = getBackground();
        image.scale(getWidth(), getHeight());
        
        // Initializeer de overige objecten.
        
        Actor playerCopy;
        Actor levelBlock = new LevelBlock();
        
        // Plaats alle muren.
        plaatsMuren();
        
        // Initializeer vijanden.
        Actor infected1 = new Infected(1);
        Actor infected2 = new Infected(1);
        Actor infected3 = new Infected(1);
        Actor infected4 = new Infected(1);
        Actor infected5 = new Infected(1);
        Actor infected6 = new Infected(1);
        
        // Initializeer pick-ups.
        Actor healthPack1 = new HealthPack(20, 10, true);
        Actor healthPack2 = new HealthPack(20, 10, true);
        Actor ammo1 = new Ammo(20, 10, true);
        Actor ammo2 = new Ammo(20, 10, true);
        Actor ammo3 = new Ammo(20, 10, true);
        
        // Initializeer information blocks
        String message1 = "Au! Wat was dat voor een beest?! En wat is dit voor een plek?!" + '\n' + "Ik moet hieruit zien te komen!";
        String message2 = "Nog zo'n vreemd... mens?! Wat zou er met ze gebeurd zijn? Een... virus?";
        String message3 = "Ah! De uitgang!";
        Actor info1 = new InformationBlock(message1);
        Actor info2 = new InformationBlock(message2);
        Actor info3 = new InformationBlock(message3);
        
        // Objecten toevoegen aan de wereld:
        
        addObject(levelBlock, 1200, 325);
        
        // Vijanden toevoegen aan de wereld.
        addObject(infected1, 160, 455);
        
        addObject(infected3, 65, 195);
        addObject(infected4, 650, 65);
        if (Omgeving.getDifficulty() == 1) {
            addObject(infected5, 460, 195); // Deze kan op de een of andere manier toch een klein stukje door een muurtje heen komen en damage doen.
            addObject(infected6, 1135, 260);
        }
        
        addObject(infected2, 1110, 475); // Deze kan op de een of andere manier toch een klein stukje door een muurtje heen komen en damage doen.
        
        
        // Pick-ups toevoegen aan de wereld.
        addObject(healthPack1, 325, 725);
        
        addObject(ammo1, 65, 65);
        addObject(ammo2, 65, 585);
        if (Omgeving.getDifficulty() != 1) {
           addObject(ammo3, 715, 195);
           addObject(healthPack2, 780, 455);
        }
        
        
        // Information blocks toevoegen aan de wereld.
        addObject(info1, 150, 455);
        addObject(info2, 585, 325);
        addObject(info3, 1135, 195);
        
        // Zorg ervoor dat alleen de belichte gebieden zichtbaar zijn (behalve de bars).
        addObject(new Zaklamp(_player), 0, 0);
        addObject(_player, 50, 455);
        
        
        addObject(healthBar, 220, 760);
        int healthBarX = 30 + healthBar.getValue() / 2;
        healthBar.setLocation(healthBarX, 760);
        
        addObject(ammoBar, 30, 720);
        int ammoBarX = 30 + ammoBar.getValue() / 2;
        ammoBar.setLocation(ammoBarX, 720);
    }
    
    public void act() {
        if (getPlayer().getGameOver()) {
            Greenfoot.setWorld(new DoodScherm(2));
        }
    }
    
    private void plaatsMuren() {
        // Horizontal walls
        NieuweOnzichtbareMuur(520, 130, 780, 10);
        NieuweOnzichtbareMuur(845, 260, 390, 10);
        NieuweOnzichtbareMuur(130, 390, 260, 10);
        NieuweOnzichtbareMuur(585, 390, 130, 10);
        NieuweOnzichtbareMuur(1005, 390, 390, 10);
        NieuweOnzichtbareMuur(130, 520, 260, 10);
        NieuweOnzichtbareMuur(845, 520, 130, 10);
        NieuweOnzichtbareMuur(260, 650, 260, 10);
        NieuweOnzichtbareMuur(780, 650, 260, 10);
        // Vertical walls
        NieuweOnzichtbareMuur(130, 195, 10, 130);
        NieuweOnzichtbareMuur(260, 325, 10, 130);
        NieuweOnzichtbareMuur(390, 390, 10, 520);
        NieuweOnzichtbareMuur(520, 185, 10, 115);
        NieuweOnzichtbareMuur(520, 670, 10, 270);
        NieuweOnzichtbareMuur(650, 455, 10, 390);
        NieuweOnzichtbareMuur(910, 65, 10, 130);
        NieuweOnzichtbareMuur(910, 325, 10, 130);
        NieuweOnzichtbareMuur(910, 585, 10, 130);
        NieuweOnzichtbareMuur(1040, 195, 10, 130);
    }
}
