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
    public Player(float x, float y) {
        super(x, y, 20, 50, GameShape.RECTANGLE, Color.BLUE);
    }
    public void moveLeft() {
        super.setXVel(-3);
    }
    public void moveRight() {
        super.setXVel(3);
    }
    public void jump() {
        this.setOnGround(false);
        this.setYVel(-10);
    }
    public void stopRight() {
        if(this.getXVel() > 0) {
            super.setXVel(0);
        }
    }
    public void stopLeft() {
        if(this.getXVel() < 0) {
            super.setXVel(0);
        }
    }
}
