import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.*;
/**
 * Write a description of class Politie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Politie extends ExtraFuncties
{
    private int X1;
    private int Y1;
    private int X2;
    private int Y2;
    private boolean ChangeX = true;
    private boolean ChangeY = true;
    private float tijd;
    private int tijdInterval;
    private boolean timerBegonnen = false;
    private boolean aanHetTerugLopen = false;
    
    double deltaX;
    double deltaY;
    
    private long startTime = System.currentTimeMillis();
    private double deltaTime;
    private long intervalStart;
    
    private boolean firstRun = true;
    private boolean terugLopen = false;
    
    // Animatie variabelen
    private int animNum = 0;
    private int animationTime = 0;
    private boolean animating = false;
    
    GreenfootImage[] loopDownImages = {new GreenfootImage("/bewaker/down/1.png"), new GreenfootImage("/bewaker/down/2.png"), new GreenfootImage("/bewaker/down/3.png"), new GreenfootImage("/bewaker/down/4.png")};
    GreenfootImage[] loopUpImages = {new GreenfootImage("/bewaker/up/1.png"), new GreenfootImage("/bewaker/up/2.png"), new GreenfootImage("/bewaker/up/3.png"), new GreenfootImage("/bewaker/up/4.png")};
    GreenfootImage[] loopRightImages = {new GreenfootImage("/bewaker/right/1.png"), new GreenfootImage("/bewaker/right/2.png"), new GreenfootImage("/bewaker/right/3.png"), new GreenfootImage("/bewaker/right/4.png")};
    GreenfootImage[] loopLeftImages = {new GreenfootImage("/bewaker/left/1.png"), new GreenfootImage("/bewaker/left/2.png"), new GreenfootImage("/bewaker/left/3.png"), new GreenfootImage("/bewaker/left/4.png")}; 
    
    public Politie(int x1, int y1, int x2, int y2, float duration, int interval) {     
        X1 = x1;
        Y1 = y1;
        X2 = x2;
        Y2 = y2;
        tijd = duration;
        tijdInterval = interval;
        setLocation(X1,Y1);
    }
    
    /**
     * Act - do whatever the Politie wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        long msSinceLast = System.currentTimeMillis()-startTime;
        startTime = System.currentTimeMillis();
        deltaTime = 1000 / msSinceLast;
        Lopen(X1,Y1,X2,Y2, tijd, tijdInterval);
    }
    
    private void Lopen(int x1, int y1, int x2, int y2, float tijd, int interval) {
        if (y1 == y2) {
            ChangeY = false;
        }
        if (x1 == x2) {
            ChangeX = false;
        }
        
        
        deltaX = (x2-x1)/(deltaTime * tijd);
        deltaY = (y2-y1)/(deltaTime * tijd);
        
        if(firstRun) {
           deltaX = 0.001;
           deltaY = 0.001;
           firstRun = false;
        }
        
        double x = getExactX();
        double y = getExactY();
        
        if(terugLopen) {
            
            if ((System.currentTimeMillis() - intervalStart) >= interval * 1000 || aanHetTerugLopen) {
                if (ChangeX) {
                x = getExactX() - deltaX;
                }
                if (ChangeY) {
                y = getExactY() - deltaY;
                }
                aanHetTerugLopen = true;
            } else {
                deltaX = 0;
                deltaY = 0;
            }
        } else {
            if (ChangeX) {
                x = getExactX() + deltaX;
            }
            if (ChangeY) {
                y = getExactY() + deltaY;
            }
            aanHetTerugLopen = false;
            timerBegonnen = false;
        }
        
        if (!ChangeX) {
            if (getExactY() >= y2) {
                terugLopen = true;
                generateIntervalTimer();
            } else if(getExactY() <= y1) {
                terugLopen = false;
            }
        } else if (!ChangeY) {
            if (getExactX() >= x2) {
                terugLopen = true;
                generateIntervalTimer();
            } else if(getX() <= x1) {
                terugLopen = false;
            } 
        } else {
            if(getExactX() >= x2 || getExactY() >= y2) {
                terugLopen = true;
                generateIntervalTimer();
            } else if(getX() <= x1 || getExactY() <= y1) {
                terugLopen = false;
            }
        }
        
        if (terugLopen) {
            deltaX = deltaX * -1;
            deltaY = deltaY * -1;
        }
        
        float[] npcDirections = {(float)deltaX, (float)deltaY};
        AnimateNPC(npcDirections);
        setLocation(x, y);
    }
    
    private void generateIntervalTimer() {
        if (!timerBegonnen) {
            intervalStart = System.currentTimeMillis();
            timerBegonnen = true;
        }
    }
    
    private void AnimateNPC(float[] _dir) {
        if(_dir[0] == 0 && _dir[1] == 0) {
            StopAnimation();
        }
        else if (_dir[1] > 0 && ChangeY) {
            PlayAnimation(loopDownImages, _dir);
        } else if (_dir[1] < 0 && ChangeY) {
            PlayAnimation(loopUpImages, _dir);
        } else if (_dir[0] > 0 && ChangeX) {
            PlayAnimation(loopRightImages, _dir);
        } else if (_dir[0] < 0 && ChangeX) {
            PlayAnimation(loopLeftImages, _dir);
        }
    }
    
    private void PlayAnimation(GreenfootImage[] images, float[] _dir) {
        if (animNum == images.length) {
            animNum = 0;
        }
        if(animating) {
           setImage(images[animNum]);
           GreenfootImage image = getImage();
           image.scale(Omgeving.ActorSizeX, Omgeving.ActorSizeY);
        } else {
           animNum = 0;
           animating = true;
           return;
        }
        animationTime++;
        
        if (animationTime == (Omgeving.speed/tijd)*2) {
            animNum += 1;
            animationTime = 0;
        }
    }
    
    private void StopAnimation() {
        animating = false;
        setImage(loopDownImages[0]);
        GreenfootImage image = getImage();
        image.scale(Omgeving.ActorSizeX, Omgeving.ActorSizeY);
        animNum = 0;
        return;
    }
}













