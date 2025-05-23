import java.awt.Color;
import java.awt.Image;
import java.util.Map;

/**
 * The {@code Entity} class represents a movable game object with velocity, capable of responding to gravity.
 * It inherits from {@code GameObject} class and implements the {@code Movable} interface.
 */
public class Entity extends GameObject implements Movable {
    private float xVel, yVel;
    private boolean onGround;

    /**
     * Constructs an {@code Entity} object with the specified position, dimensions, shape, and color.
     *
     * @param x      the x-coordinate of the entity's position
     * @param y      the y-coordinate of the entity's position
     * @param width  the width of the entity
     * @param height the height of the entity
     * @param shape  the shape of the entity
     * @param color  the color of the entity
     */
    public Entity(float x, float y, int width, int height, GameShape shape, Color color) {
        super(x, y, width, height, shape, color);
    }
    
    public Entity(float x, float y, int width, int height, GameShape shape, Image im) {
        super(x, y, width, height, shape, im);
    }

    public Entity(float x, float y, int width, int height, GameShape shape, Sprites sprites) {
        super(x, y, width, height, shape, sprites);
    }
    /**
     * Sets the on-ground status of the entity.
     *
     * @param onGround {@code true} if the entity is on the ground, {@code false} otherwise
     */
    public void setOnGround(boolean onGround) {
        this.onGround = onGround;
    }
    public boolean onGround() {
        return onGround;
    }
    public void correctPosition(GameObject obj) {
        boolean xCollision = (this.x < obj.getX() + obj.getWidth() && this.x + super.getWidth() > obj.getX());
        if(xCollision && yVel > 0)
            this.y = ((int)obj.getY() - this.getHeight()+1);
        //Is in side bounds
        //yVel is negative
    }

    /**
     * Applies gravity to the entity. If the entity is on the ground, the vertical velocity is set to 0.
     * Otherwise, the vertical velocity is increased by the gravitational constant.
     */
    @Override
    public void doGravity() {
        
        if (onGround) {
            yVel = 0;
        } else {
            yVel += Movable.GRAVITY;
        }
    }

    /**
     * Gets the horizontal velocity of the entity.
     *
     * @return the horizontal velocity of the entity
     */
    @Override
    public float getXVel() {
        return xVel;
    }

    /**
     * Gets the vertical velocity of the entity.
     *
     * @return the vertical velocity of the entity
     */
    @Override
    public float getYVel() {
        return yVel;
    }

    /**
     * Moves the entity based on its velocity.
     */
    @Override
    public void move() {
        super.x += xVel;
        super.y += yVel;
    }
    protected void setXVel(int v) {
        this.xVel = v;
    }
    protected void setYVel(int v) {
        this.yVel = v;
    }
}
