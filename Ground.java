import java.awt.*;

/**
 * The {@code Ground} class represents the ground of the game.
 * It inherits from {@code StaticEntity}.
 */
public class Ground extends StaticEntity {

    /**
     * Constructs a {@code Ground} object with the specified position, dimensions, shape, and color.
     *
     * @param x      the x-coordinate of the ground's position
     * @param y      the y-coordinate of the ground's position
     * @param w      the width of the ground
     * @param h      the height of the ground
     * @param shape  the shape of the ground
     * @param color  the color of the ground
     */
    public Ground(float x, float y, int w, int h, GameShape shape, Color color) {
        super(x, y, w, h, shape, color);
    }
}
