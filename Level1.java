import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
    
    public Level1()
    {    
        super(WorldSizeX, WorldSizeY, PixelSize);
        
        setBackground(prison_dicht);
        GreenfootImage image = getBackground();
        image.scale(getWidth(), getHeight());
        
        
        // Actors
        Actor Player = new Player();
        Actor Politie = new Politie(300, 400, 600, 400, 3, 1);
        Gun Pistool = new Gun(20, 10, true, GunType.Pistool); // TODO: Meer wapens door middel van type!
        
        // Objecten toevoegen aan het scenario
        MuurPlaatsingen();
        addObject(Politie, 300, 400);
        addObject(Pistool, 140, 675);
        //addObject(new Zaklamp(Player), 0, 0);
        addObject(Player, 368, 650);
        
    }
    
    public void act() {
        OpenDeur();
    }
    
    private void MuurPlaatsingen() {
        NieuweOnzichtbareMuur(26, 400, 52, 800);
        NieuweOnzichtbareMuur(WorldSizeX/2, 120, WorldSizeX, 240);
        NieuweOnzichtbareMuur(842, 620, 775, 300);
        NieuweOnzichtbareMuur(256, 650, 53, 300);
        NieuweOnzichtbareMuur(WorldSizeX/2, 773, WorldSizeX, 70);
        NieuweOnzichtbareMuur(60, 550, 50, 70);
        NieuweOnzichtbareMuur(230, 550, 50, 70);
        if (!CellOpen) {
            addObject(Celldeur, 368, 515);
        }
        return;
    }
    
    
    private void NieuweMuur(int x, int y, int width, int height, Color color) {
        Actor muur = new Muur(width, height, color);
        addObject(muur, x, y);
        return;
    }
    
    private void NieuweOnzichtbareMuur(int x, int y, int width, int height) {
        Actor invisibleWall = new OnzichtbareMuur(width, height);
        addObject(invisibleWall, x, y);
        return;
    }
    
    private void NieuweNepMuur(int x, int y, int width, int height, Color color) {
        Actor nepmuur = new NepMuur(width, height, color);
        addObject(nepmuur, x, y);
        return;
    }
    
    private void NieuweText(String text, int fontsize, Color color, Color bgColor, int x, int y) {
        Actor TextElement = new Text(text, fontsize, color, bgColor);
        addObject(TextElement, x,y);
    }
    
    private void OpenDeur() {
        if (Greenfoot.isKeyDown("f") && !CellOpen) {
            setBackground(prison_open);
            Greenfoot.playSound("prison_door_2.wav");
            CellOpen = true;
            removeObject(Celldeur);
        }
    }
    
}
