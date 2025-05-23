import java.awt.Color;

/**
 * The {@code Player} class represents a player entity in a game.
 * It inherits from {@code Entity}.
 */
public class Player extends Entity {
    
    
    /**
     * Constructs a {@code Player} object with the specified initial position.
     *
     * @param x the initial x-coordinate of the player's position
     * @param y the initial y-coordinate of the player's position
     */
    public Player(float x, float y, Sprites sprites) {
        super(x, y, 20, 36, GameShape.IMAGE, sprites);
        this.faceingRight = true;
        this.playerState = "idle";

    }
    public void moveLeft() {
        this.playerState = "walking";
        // if(faceingRight){
        //     this.setImage(flip(this.getImage()));
        //     faceingRight = false;
        // }
        faceingRight = false;
        super.setXVel(-3);
    }
    public void moveRight() {
        this.playerState = "walking";
        // if(!faceingRight){
        //     this.setImage(flip(this.getImage()));
        //     faceingRight = true;
        // }
        faceingRight = true;
        super.setXVel(3);
    }
    public void jump() {
        this.playerState = "jump";
        this.setOnGround(false);
        this.setYVel(-10);
    }
    public void stopRight() {
        this.playerState = "idle";
        if(this.getXVel() > 0) {
            super.setXVel(0);
        }
    }
    public void stopLeft() {
        this.playerState = "idle";
        if(this.getXVel() < 0) {
            super.setXVel(0);
        }
    }
    
    public GameObject attack() {
        this.playerState = "attack";
        GameObject attackSpace = new GameObject(this.x, this.y, 10, 10, GameShape.OVAL, Color.gray);
        return attackSpace;
    }
}
