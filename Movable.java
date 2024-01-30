/**
 * The {@code Movable} interface represents an object that can be moved and affected by gravity.
 * Classes implementing this interface must provide methods for movement, velocity retrieval, and gravity application.
 */
public interface Movable {
    /**The gravitational constant applied to movable objects.*/
    float GRAVITY = 0.2f;

    /**Moves the object based on its velocity.*/
    void move();

    /**
     * Gets the horizontal velocity of the object.
     * @return the horizontal velocity of the object
     */
    float getXVel();

    /**
     * Gets the vertical velocity of the object.
     * @return the vertical velocity of the object
     */
    float getYVel();

    /**Applies gravity to the object, adjusting its vertical velocity.*/
    void doGravity();
}