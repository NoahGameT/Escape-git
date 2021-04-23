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
    
    private String bg_dicht = "/backgrounds/lvl_1/prison_dicht.png";
    private String bg_open = "/backgrounds/lvl_1/prison_open.png";
    private String bg = bg_dicht;
    
    public Level1()
    {    
        super(WorldSizeX, WorldSizeY, PixelSize);
        GreenfootImage prison_dicht = new GreenfootImage("/backgrounds/lvl_1/prison_dicht.png");
        prison_dicht.scale(getWidth(), getHeight());
        setBackground(prison_dicht);
        Actor Player = new Player();
        MuurPlaatsingen();
        
        Actor Politie = new Politie(300, 200, 300, 800, 1, 3);
        addObject(Politie, 300, 200);
        
        addObject(Player, 368, 650);
        
    }
    
    private void MuurPlaatsingen() {
        NieuweOnzichtbareMuur(26, 400, 52, 800);
        NieuweOnzichtbareMuur(WorldSizeX/2, 120, WorldSizeX, 240);
        NieuweOnzichtbareMuur(842, 620, 775, 300);
        NieuweOnzichtbareMuur(256, 650, 53, 300);
        NieuweOnzichtbareMuur(WorldSizeX/2, 773, WorldSizeX, 70);
        if (bg == bg_dicht) {
            NieuweOnzichtbareMuur(368, 515, 175, 70);
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
}
