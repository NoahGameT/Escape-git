import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Set the standard variables for the levels.
 * 
 * @author Noah and Dinand 
 * @version (a version number or a date)
 */
public class Omgeving extends World
{

    /**
     * Constructor for objects of class Omgeving.
     */
    public static int speed = 60;
    public static int WorldSizeX = 1200;
    public static int WorldSizeY = 800;
    public static int PixelSize = 1;
    public static int ActorSizeX = 75;
    public static int ActorSizeY = 120;
    
    private static Player player;
    
    public Omgeving(int WSX, int WSY, int PS)
    {   
        super(WSX, WSY, PS);
        Greenfoot.setSpeed(speed);
    }
    
    public static void setPlayer(Player _player) {
        player = _player;
    }
    
    public static Player getPlayer() {
        return player;
    }
    
    public static Player createPlayer(Actor _healthBar, Actor _ammoBar) {
            player = new Player(_healthBar, _ammoBar);
            return player;
    }
    
    public Player initializePlayer(Player _player) {
        if (_player == null || _player.getGameOver()) {
            // Health bar
            Actor healthBar = new ActiveBar(380, 20, Color.RED, "health");
            Actor healthBorderBar = new Bar(390, 30, Color.BLACK);
            Actor healthEmptyBar = new Bar(380, 20, Color.WHITE);
            
            // Ammo bar
            Actor ammoBar = new ActiveBar(200, 20, Color.YELLOW, "ammo");
            Actor ammoBorderBar = new Bar(210, 30, Color.BLACK);
            Actor ammoEmptyBar = new Bar(200, 20, Color.WHITE);
            _player = createPlayer(healthBar, ammoBar);
            _player.setGameOver(false);
            // Objecten toevoegen aan de wereld voor de health bar
            
            addObject(healthBorderBar, 220, 760);
            addObject(healthEmptyBar, 220, 760); 
            // Objecten toevoegen voor de ammo bar
            addObject(ammoBorderBar, 130, 720);
            addObject(ammoEmptyBar, 130, 720);
            _player.setPlayerState(PlayerState.Gevangenen_pistool);
            _player.setGunState(true);
            return _player;
        }
        
        // Initializeer objecten voor de health bar.
        ActiveBar healthBar = _player.getHealthBar();
        Actor healthBorderBar = new Bar(390, 30, Color.BLACK);
        Actor healthEmptyBar = new Bar(380, 20, Color.WHITE);
        
        // Initializeer objecten voor de ammo bar.
        ActiveBar ammoBar = _player.getAmmoBar();
        Actor ammoBorderBar = new Bar(210, 30, Color.BLACK);
        Actor ammoEmptyBar = new Bar(200, 20, Color.WHITE);
        
        
        // Objecten toevoegen aan de wereld voor de health bar
        addObject(healthBorderBar, 220, 760);
        addObject(healthEmptyBar, 220, 760);
        
        // Objecten toevoegen voor de ammo bar
        addObject(ammoBorderBar, 130, 720);
        addObject(ammoEmptyBar, 130, 720);
        _player.setGameOver(false);
        return _player;
    }
    
    public static World getLevel(int worldIndex) {
        World[] levels = {new Level4(), new Level3(), new Level2(), new Level1()};
        return levels[worldIndex];
    }
    
    public void NieuweMuur(int x, int y, int width, int height, Color color) {
        Actor muur = new Muur(width, height, color);
        addObject(muur, x, y);
        return;
    }
    
    public void NieuweOnzichtbareMuur(int x, int y, int width, int height) {
        Actor invisibleWall = new OnzichtbareMuur(width, height);
        addObject(invisibleWall, x, y);
        return;
    }
    
    public void NieuweNepMuur(int x, int y, int width, int height, Color color) {
        Actor nepmuur = new NepMuur(width, height, color);
        addObject(nepmuur, x, y);
        return;
    }
    
    public void NieuweText(String text, int fontsize, Color color, Color bgColor, int x, int y) {
        Actor TextElement = new Text(text, fontsize, color, bgColor);
        addObject(TextElement, x,y);
    }
    
    public void SpawnInfected(int movementSpeed, int x, int y) {
        Actor Infected = new Infected(movementSpeed);
        addObject(Infected, x,y);
    }
    
    public void NieuweInfoBlok(String text, int x, int y) {
        InformationBlock InfoBlok = new InformationBlock(text);
        addObject(InfoBlok, x, y);
    }
}
