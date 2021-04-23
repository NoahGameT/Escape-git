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
    public Level1()
    {    
        super(WorldSizeX, WorldSizeY, PixelSize);
        Actor Player = new Player();
        Actor Politie = new Politie(400, 200, 400, 400, 1, 3);
        MuurPlaatsingen();
        
        addObject(Politie, 400, 200);
        
        addObject(Player, WorldSizeX/4, WorldSizeY/4);
        
    }
    
    private void MuurPlaatsingen() {
        NieuweMuur(250, 700+WorldSizeY/2, 20, 500, Color.BLACK);
        NieuweMuur(125, 240, 255, 20, Color.BLACK);
        NieuweNepMuur(250, WorldSizeY/2, 20, 250, Color.GRAY);
        //NieuweOnzichtbareMuur(WorldSizeX/2, WorldSizeY/2, 30, WorldSizeY);
        NieuweText("test", 20, Color.BLACK, null, 600, 400);
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
