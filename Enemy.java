import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**Class for {@code Enemy} */
public class Enemy extends Entity{
    private Player player;
    private Cooldown leapAttack;

    /**
     * Create a new enemy.
     * @param x, initial
     * @param y, initial
     * @param p, to attack
     */
     public Enemy(float x, float y, Player p) {
        super(x, y, 64, 64, GameShape.IMAGE, FileUtil.loadImage("CryoClaw.png"));
        player = p;
        leapAttack = new Cooldown(5);
     }
     @Override
     public void move() {
        super.move();
        int dis = (int)this.getX() - (int)player.getX();
        if(dis > 10 && Math.abs(dis) > 10) {
            this.setXVel(-2);
        } else if(dis < -10 && Math.abs(dis) > 10) {
            this.setXVel(2);    
        } else if(dis <-1 && Math.abs(dis) <= 500) {
            attack(true);
        } else if(dis >1 && Math.abs(dis) <= 500) {
            attack(false);
        } else if(Math.abs(dis) <= 10) {
            this.setXVel(0);
        }else {
            System.out.println(player.getX() - 210);
            System.out.println(this.getX());
        }
     }
     /**
      * Enimies main attack function.
      * @param isLeft
      */
     private void attack(boolean isLeft) {
        if(leapAttack.timeUp()) {
            leapAttack.startTimer();     
        if(isLeft) {
            this.setXVel(10);
        } else {
            this.setXVel(-10);
        }
        if(this.onGround()) {
        this.setYVel(-5);
        this.setOnGround(false);
        }
     }
    }
   
}
