import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Level3 here.
 * 
 * @author (Noah) 
 * @version (a version number or a date)
 */
public class Level3 extends Omgeving
{

    /**
     * Constructor for objects of class Level3.
     * 
     */
    
    public Level3()
    {
        super(WorldSizeX, WorldSizeY, PixelSize);
        Player _player = getPlayer();
        GreenfootImage bgImage = new GreenfootImage("/backgrounds/lvl_3/level_3_a_zebi_deur_dicht.png");
        setBackground(bgImage);
        _player = initializePlayer(_player);
        addObject(_player, 50, 400);
        ActiveBar healthBar = _player.getHealthBar();
        addObject(healthBar, 220, 760);
        int healthBarX = 30 + healthBar.getValue() / 2;
        healthBar.setLocation(healthBarX, 760);
        
        ActiveBar ammoBar = _player.getAmmoBar();
        addObject(ammoBar, 30, 720);
        int ammoBarX = 30 + ammoBar.getValue() / 2;
        ammoBar.setLocation(ammoBarX, 720);
        MuurPlaatsingen();
        PopulateInfected();
        InfoBlokken();
        BruikbareDingen();
        LevelBlock lvlblock = new LevelBlock();
        addObject(lvlblock, 1200, 280);
    }
    
    public void act() {
        if (getPlayer().getGameOver()) {
            Greenfoot.setWorld(new DoodScherm(2));
        }
    }
    
    private void MuurPlaatsingen() {
        NieuweOnzichtbareMuur(303, 600, 42, 405);
        NieuweOnzichtbareMuur(505, 300, 42, 600);
        NieuweOnzichtbareMuur(860, 405, 185, 50);
        NieuweOnzichtbareMuur(1150, 405, 190, 50);
        NieuweOnzichtbareMuur(650, 200, 300, 50);
        NieuweOnzichtbareMuur(795, 300, 42, 230);
        NieuweOnzichtbareMuur(795, 100, 42, 200);
        NieuweOnzichtbareMuur(795, 700, 42, 240);
    }
    
    private void PopulateInfected() {
        SpawnInfected(1, 375, 600);
        SpawnInfected(1, 652, 535);
        SpawnInfected(1, 984, 638);
        SpawnInfected(1, 1009, 133);
    }
    
    private void InfoBlokken() {
        NieuweInfoBlok("Jeetje eindelijk in de bewoonde wereld, eens kijken wat er aan de hand is.", 150, 400);
        NieuweInfoBlok("Pff, dat ook weer gehad. Het lijkt wel of ik tegen het virus kan, misschien moet ik een vaccin maken van mijn eigen bloed.", 150, 400);
    }
    
    private void BruikbareDingen() {
        Actor healthPack = new HealthPack(20, 10, true);
        addObject(healthPack, 500, 750);
        Actor ammo = new Ammo(20, 10, true);
        addObject(ammo, 100, 200);
        Actor ammo1 = new Ammo(20, 10, true);
        addObject(ammo1, 100, 200);
    }
}
