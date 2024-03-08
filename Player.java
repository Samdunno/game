import java.awt.Color;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

/**
 * The {@code Player} class represents a player entity in a game.
 * It inherits from {@code Entity}.
 */
public class Player extends Entity {
    private boolean faceingRight;
    private String playerState;
    /**
     * Constructs a {@code Player} object with the specified initial position.
     *
     * @param x the initial x-coordinate of the player's position
     * @param y the initial y-coordinate of the player's position
     */
    public Player(float x, float y) {
        super(x, y, 20, 36, GameShape.IMAGE, FileUtil.cell1());
        this.faceingRight = true;
    }
    public void moveLeft() {
        this.playerState = "walking";
        if(faceingRight){
            this.setImage(flip(this.getImage()));
            faceingRight = false;
        }
        super.setXVel(-3);
    }
    public void moveRight() {
        this.playerState = "walking";
        if(!faceingRight){
            this.setImage(flip(this.getImage()));
            faceingRight = true;
        }
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
    public Image flip(Image im) {
        AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
        tx.translate(-im.getWidth(null), 0);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        return(op.filter((BufferedImage)im, null));
    }
    public GameObject attack() {
        this.playerState = "attack";
        GameObject attackSpace = new GameObject(this.x, this.y, 10, 10, GameShape.OVAL, Color.gray);
        return attackSpace;
    }
}
