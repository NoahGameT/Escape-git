import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math;

/**
 * Move towards the player when it is within a certain radius and damage the player when it collides.
 * 
 * @author Dinand 
 * @version 21-0-2021
 */
public class Infected extends ExtraFuncties
{
    // Movement variables
    int maxDist = 250;
    int movementSpeed;
    private int[][] inputs;
    
    // Sound variables
    GreenfootSound zombieSound = new GreenfootSound("zombie.wav");
    
    // Widths and lengths
    private int width;
    private int height;
    private int imageScaleX = Omgeving.ActorSizeX;
    private int imageScaleY = Omgeving.ActorSizeY;
    
    // Animation variables.
    private int animNum = 0;
    private int animationTime = 0;
    private boolean animating = false;
    private GreenfootImage[][] sprites = {{new GreenfootImage("/infected/left/1.png"), new GreenfootImage("/infected/left/2.png"), new GreenfootImage("/infected/left/3.png"), new GreenfootImage("/infected/left/4.png")},
    {new GreenfootImage("/infected/right/1.png"), new GreenfootImage("/infected/right/2.png"), new GreenfootImage("/infected/right/3.png"), new GreenfootImage("/infected/right/4.png")},
    {new GreenfootImage("/infected/up/1.png"), new GreenfootImage("/infected/up/2.png"), new GreenfootImage("/infected/up/3.png"), new GreenfootImage("/infected/up/4.png")},
    {new GreenfootImage("/infected/down/1.png"), new GreenfootImage("/infected/down/2.png"), new GreenfootImage("/infected/down/3.png"), new GreenfootImage("/infected/down/4.png")}};
    
    
    Actor player;
    
    /**
     * Create an infected object.
     */
    public Infected(int _movementSpeed) {
        movementSpeed = _movementSpeed;
        // Lower the volume of the sound.
        zombieSound.setVolume(60);
    }
    
    /**
     * Move towards the player if the distance is smaller than a certain distance.
     */
    public void act() 
    {
        player = Omgeving.getPlayer();
        // This call gets the reference to the player.
        int playerX = player.getX();
        int playerY = player.getY();
        if (checkDistance(playerX, playerY)) {
            moveInfected(playerX, playerY);
            animateInfected();
            zombieSound.play();
        } else {
            // Set the image to the default image.
            resetImage();
        }
    }
    
    /**
     * Check if the distance between the player and the infected isn't too big.
     */
    public boolean checkDistance(int playerX, int playerY) {
        int xCor = getX();
        int yCor = getY();
        int dX = xCor - playerX;
        int dY = yCor - playerY;
        int distance = (int)Math.sqrt(Math.pow((double)dX, 2) + Math.pow((double)dY, 2)); // Pythagoras' theory. This calculates the distance between the player and the infected.
        if (distance <= maxDist) {
            return true;
        }
        return false;
    }
    
    /**
     * Move the infected.
     */
    private void moveInfected(int playerX, int playerY) {
        inputs = getInfectedInputs(playerX, playerY);
        // Don't let the infected walk through walls.
        checkCollision(OnzichtbareMuur.class, inputs);
        checkCollision(Muur.class, inputs);
        int newX = getX() + inputs[0][0] * movementSpeed - inputs[0][1] * movementSpeed;
        int newY = getY() + inputs[1][0] * movementSpeed - inputs[1][1] * movementSpeed;
        setLocation(newX, newY);
    }
    
    /**
     * Determine in which direction the infected has to move to get to the player.
     */
    private int[][] getInfectedInputs(int playerX, int playerY) {
        int dX = getX() - playerX;
        int dY = getY() - playerY;
        
        int a; // Right
        int b; // Left
        int c; // Up
        int d; // Down
        
        // Get the horizontal direction.
        if (dX < 0) {
            a = 1;
            b = 0;
        } else {
            a = 0;
            b = 1;
        }
        // Get the vertical direction.
        if (dY < 0) {
            c = 1;
            d = 0;
        } else {
            c = 0;
            d = 1;
        }
        int[][] inputs = {{a, b}, {c, d}};
        return inputs;
    }
    
    public void checkCollision(java.lang.Class collider, int[][] inputs) {
        for (Object obj : getIntersectingObjects(collider))
        {
            Actor actor = (Actor) obj;
            if(actor != null) {
                int x = actor.getX();
                int y = actor.getY();
                GreenfootImage colliderImage = actor.getImage();
                int sizeX = colliderImage.getWidth();
                int sizeY = colliderImage.getHeight();
                
                int x1 = x - sizeX/2; // X-cor of the left side.
                int x2 = x + sizeX/2; // X-cor of the right side.
                int infectedXLeft = getX() - getInfectedWidth()/2;
                int infectedXRight = getX() + getInfectedWidth()/2;
                
                // Check if the infected has collided with either the left or right side of the wall and set the input of the colliding side to 0. 
                if (x2 >= infectedXLeft) {
                    inputs[0][0] = 0;
                } else if (x1 <= infectedXRight) {
                    inputs[0][1] = 0;
                }
                
                int y1 = y - sizeY/2; // Y-cor of the top.
                int y2 = y + sizeY/2; // Y-cor of the bottom.
                int yInfected = getY();
                int infectedBottom = yInfected + getInfectedHeight()/2;
                int infectedTop = yInfected - getInfectedHeight()/2;
                
                // Check if the infected has collided with either the top or bottom side of the wall and set the input of the colliding side to 0.
                if (y1 <= infectedBottom && y > yInfected) {
                    inputs[1][0] = 0;
                } else if (y2 >= infectedTop && y < yInfected) {
                    inputs[1][1] = 0;
                }
            }
        }
    }
    
    /**
     * Check what direction the infected is moving in and play the right animation accordingly.
     */
    private void animateInfected() {
        // The horizontal motions have priority.
        if (inputs[0][0] == 1) {
            playAnimation(sprites[1]);
        } else if (inputs[0][1] == 1) {
            playAnimation(sprites[0]);
        } else if (inputs[1][0] == 1) {
            playAnimation(sprites[2]);
        } else if (inputs[1][1] == 1) {
            playAnimation(sprites[3]);
        }
    }
    
    /**
     * Play the animation from the right array.
     */
    private void playAnimation(GreenfootImage[] images) {
        if (animNum == images.length) {
            animNum = 0;
        }
        if(animating) {
           setImage(images[animNum]);
           GreenfootImage image = getImage();
           image.scale(imageScaleX, imageScaleY);
        } else {
           animNum = 0;
           animating = true;
           return;
        }
        animationTime++;
        if (animationTime == Omgeving.speed / movementSpeed) {
            animNum++;
            animationTime = 0;
        }
    }
    
    /**
     * Set the infected's image to the default image.
     */
    private void resetImage() {
        setImage(sprites[3][0]);
        GreenfootImage image = getImage();
        image.scale(imageScaleX, imageScaleY); // Make the image bigger.
        animNum = 0; // Reset the animation counter.
    }
    
    /**
     * Get the infected's width.
     */
    private int getInfectedWidth() {
        GreenfootImage image = getImage();
        int width = image.getWidth();
        return width;
    }
    
    /**
     * Get the infected's height.
     */
    private int getInfectedHeight() {
        GreenfootImage image = getImage();
        int height = image.getHeight();
        return height;
    }
}
