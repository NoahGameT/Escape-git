import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class MyWorld here.
 * 
 * @author Dinand en Noah
 * @version 22-05-2021
 */
public class Level1 extends Omgeving
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    
    public boolean CellOpen = false;
    Actor Celldeur = new OnzichtbareMuur(175, 70);
    
    GreenfootImage prison_dicht = new GreenfootImage("/backgrounds/lvl_1/prison_dicht.png");
    GreenfootImage prison_open = new GreenfootImage("/backgrounds/lvl_1/prison_open.png");
    
    Player Player;
    Actor sleutel;
    Text UitlegTextSleutel;
    private boolean start = true;
    
    public Level1() {    
        super(WorldSizeX, WorldSizeY, PixelSize);
        
        setBackground(prison_dicht);
        GreenfootImage image = getBackground();
        image.scale(getWidth(), getHeight());
        
        UitlegTextSleutel = new Text("Steel de sleutel van de politie wanneer hij langs loopt.", 30, Color.WHITE, Color.BLACK);
        Text UitlegTextPolitie = new Text("Maar kijk uit voor de politie want als hij je door heeft krijg je straf.", 30, Color.WHITE, Color.BLACK);
        Text UitlegTextControls = new Text("Steel de sleutel door op 'E' te klikken, en open de deur daarna met 'F'.", 30, Color.WHITE, Color.BLACK);
        
        // Actors //
        
        // Info Texten
        addObject(UitlegTextSleutel, 800, 100);
        addObject(UitlegTextPolitie, 800, 130);
        addObject(UitlegTextControls, 800, 160);
        
        // Andere actors
        ActiveBar healthBar = new ActiveBar(380, 20, Color.RED, "health");
        ActiveBar ammoBar = new ActiveBar(200, 20, Color.YELLOW, "ammo");
        
        Player = new Player(healthBar, ammoBar);
        Player.setGameOver(false);
        addObject(Player, 368, 650);
        // Initializeer objecten voor de health bar.
        Actor healthBorderBar = new Bar(390, 30, Color.BLACK);
        Actor healthEmptyBar = new Bar(380, 20, Color.WHITE);
        
        // Initializeer objecten voor de ammo bar.
        Actor ammoBorderBar = new Bar(210, 30, Color.BLACK);
        Actor ammoEmptyBar = new Bar(200, 20, Color.WHITE);
        
        
        // Objecten toevoegen aan de wereld voor de health bar
        addObject(healthBorderBar, 220, 760);
        addObject(healthEmptyBar, 220, 760);
        
        // Objecten toevoegen voor de ammo bar
        addObject(ammoBorderBar, 130, 720);
        addObject(ammoEmptyBar, 130, 720);
        
        
        
        Actor Politie = new Politie(300, 400, 600, 400, 3, 1);
        Gun Pistool = new Gun(20, 10, true, GunType.Pistool);
        Actor levelBlock = new LevelBlock();
        sleutel = new Sleutels((Player)Player, Politie);
        
        // Objecten toevoegen aan de wereld.
        MuurPlaatsingen();
        
        addObject(Politie, 300, 400);
        addObject(sleutel, 0, 0);
        addObject(Pistool, 140, 675);
        addObject(levelBlock, 1200, 404);
        
        // Objecten voor de health bar
        healthBar = Player.getHealthBar();
        addObject(healthBar, 220, 760);
        int healthBarX = 30 + healthBar.getValue() / 2;
        healthBar.setLocation(healthBarX, 760);
        
        // Objecten voor de ammo bar
        ammoBar = Player.getAmmoBar();
        addObject(ammoBar, 30, 720);
        int ammoBarX = 30 + ammoBar.getValue() / 2;
        ammoBar.setLocation(ammoBarX, 720);
        
    }
    
    private void startAct() {
        if (start) {
            setPlayer(Player);
            start = false;
        }
    }
    
    public void act() {
        startAct();
        if (Player.gotKey) {
            UitlegTextSleutel.ChangeText("Goedzo je hebt de sleutel! Pak het pistool en ontsnap uit de gevangenis!");
        }
        OpenDeur();
        if (Player.getGameOver()) {
            Greenfoot.setWorld(new DoodScherm(1));
        }
    }
    
    private void MuurPlaatsingen() {
        NieuweOnzichtbareMuur(26, 400, 52, 800);
        NieuweOnzichtbareMuur(WorldSizeX/2, 120, WorldSizeX, 240);
        NieuweOnzichtbareMuur(842, 645, 775, 300);
        NieuweOnzichtbareMuur(256, 650, 53, 300);
        NieuweOnzichtbareMuur(WorldSizeX/2, 773, WorldSizeX, 70);
        NieuweOnzichtbareMuur(60, 550, 50, 70);
        NieuweOnzichtbareMuur(230, 550, 50, 70);
        if (!CellOpen) {
            addObject(Celldeur, 368, 515);
        }
        return;
    }
    
    private void OpenDeur() {
        if (Greenfoot.isKeyDown("f") && !CellOpen && Player.gotKey) {
            removeObject(sleutel);
            Player.gotKey = false;
            
            setBackground(prison_open);
            Greenfoot.playSound("prison_door_2.wav");
            CellOpen = true;
            removeObject(Celldeur);
        }
    }
    
}
