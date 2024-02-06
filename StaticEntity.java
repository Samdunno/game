import java.awt.Color;
/**
 * The {@code StaticEntity} class represents a game object that serves as the Static Objects in a game.
 * It inherits from {@code GameObject}.
 */
public class StaticEntity extends GameObject{
    public StaticEntity (float x, float y, int width, int height, GameShape shape, Color color) {
        super(x, y, width, height, shape, color);
    }
}
