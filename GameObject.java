import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

/**
 * The {@code GameObject} class represents a generic game object with position,
 * dimensions, shape, and color.
 */

public class GameObject implements Collider {
    protected float x, y;
    private int width, height;
    private GameShape shape;
    private Color color;
    private Image image;
    protected String playerState;
    Sprites sprites;
    protected boolean faceingRight;

    /**
     * Constructs a {@code GameObject} with the specified position, dimensions,
     * shape, and color.
     *
     * @param x      the x-coordinate of the object's position
     * @param y      the y-coordinate of the object's position
     * @param width  the width of the object
     * @param height the height of the object
     * @param shape  the shape of the object
     * @param color  the color of the object
     */
    public GameObject(float x, float y, int width, int height, GameShape shape, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.shape = shape;
        this.color = color;
    }

    public GameObject(float x, float y, int width, int height, GameShape shape, Image im) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.shape = shape;
        this.image = im;
    }

    public GameObject(float x, float y, int width, int height, GameShape shape, Sprites sprites) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.shape = shape;
        this.sprites = sprites;

    }

    protected Image getImage() {
        return image;
    }

    protected void setImage(Image im) {
        this.image = im;
    }

    /**
     * Gets the x-coordinate of the object's position.
     *
     * @return the x-coordinate of the object's position
     */
    public int getX() {
        return (int) x;
    }

    /**
     * Gets the y-coordinate of the object's position.
     *
     * @return the y-coordinate of the object's position
     */
    public int getY() {
        return (int) y;
    }

    /**
     * Gets the width of the object.
     *
     * @return the width of the object
     */
    public int getWidth() {
        return width;
    }

    /**
     * Gets the height of the object.
     *
     * @return the height of the object
     */
    public int getHeight() {
        return height;
    }

    /**
     * Gets the shape of the object.
     *
     * @return the shape of the object
     */
    public GameShape getShape() {
        return shape;
    }

    /**
     * Gets the color of the object.
     *
     * @return the color of the object
     */
    public Color getColor() {
        return color;
    }

    /**
     * Paints the object on the specified graphics context.
     *
     * @param g the graphics context on which to paint the object
     */
    public void paintSelf(Graphics g) {
        g.setColor(color);
        if (this.shape == GameShape.OVAL) {
            g.fillOval((int) x, (int) y, width, height);
        } else if (this.shape == GameShape.RECTANGLE) {
            g.fillRect((int) x, (int) y, width, height);
        } else if (this.shape == GameShape.IMAGE) {
            if (this.sprites == null)
                g.drawImage(flip(this.getImage()), (int) x, (int) y, null);
            else {
                // center image in frame
                float drawX = x;
                float drawY = y;

                // check state
                if (this.playerState != this.sprites.CurrentState) {
                    this.sprites.SetState(playerState);
                }

                var img = this.sprites.GetCurrentSprite().GetImage();
                var playw = (float) img.getWidth(null);
                var playh = (float) img.getHeight(null);

                if (playw > -1 & playh > -1) {
                    // shift x to center in frame
                    drawX = drawX - (playw - this.width) / 2;
                    drawY = drawY - (playh - this.height) / 2;
                }

                // System.out.println(String.format("Player x:%f to %f, y:%f to %f",x, drawX, y,
                // drawY));

                g.drawImage(flip(img), (int) drawX, (int) drawY, null);
            }
        } else {

        }
    }

    public Image flip(Image im) {
        if (faceingRight)
            return im;

        AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
        tx.translate(-im.getWidth(null), 0);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        return (op.filter((BufferedImage) toBufferedImage(im), null));
    }

    /**
     * Converts a given Image into a BufferedImage
     *
     * @param img The Image to be converted
     * @return The converted BufferedImage
     */
    public static BufferedImage toBufferedImage(Image img) {
        if (img instanceof BufferedImage) {
            return (BufferedImage) img;
        }

        // Create a buffered image with transparency
        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        // Draw the image on to the buffered image
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();

        // Return the buffered image
        return bimage;
    }

    /**
     * Checks if the object is colliding with another game object.
     *
     * @param obj the other game object to check for collision
     * @return {@code true} if the objects are colliding, {@code false} otherwise
     */
    @Override
    public boolean isColliding(Collider c) {
        boolean xCollision = (this.x < c.getX() + c.getWidth() && this.x + this.width > c.getX());
        boolean yCollision = (this.y < c.getY() + c.getHeight() && this.y + this.height > c.getY());
        return xCollision && yCollision;
    }

    public String collisionDirection(GameObject obj) {
        if (!isColliding(obj)) {
            return "";
        }
        // top higher, bottom lower than other top
        if (this.y > obj.getY() && this.y + this.height < obj.getY()) {
            return "top";

        }
        // top higher, bottom lower than other bottom
        if (this.y < obj.getY() && this.y + this.getHeight() < obj.getY()) {
            return "bottom";
        }
        // left less then obj left, right equal to or more than obj left
        if (this.x < obj.getX() && this.x + this.width >= obj.getX()) {
            return "left";

        }
        // right more then obj right, left less than or equal
        if (this.x <= obj.getX() + obj.getWidth() && this.x + this.width > obj.getWidth() + obj.getX()) {
            return "right";
        }
        return "";
    }
}