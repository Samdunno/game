import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Entity implements Movable, GameObject, Rigid {
    float x, y, xVel, yVel;
    int width, height;
    GameShape shape;
    Color color;
    private boolean onGround;
    public Entity(float x, float y, int width, int height, GameShape shape, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.shape = shape;
        this.color = color;
    }

    @Override
    public void doGravity() {
        if(! onGround)
        yVel += Movable.GRAVITY;
        
    }

    @Override
    public float getXVel() {
        return xVel;
    }

    @Override
    public float getYVel() {
        return yVel;
    }

    @Override
    public void move() {
        x+= xVel;
        y+= yVel; 
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public GameShape getShape() {
        return shape;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public void paintSelf(Graphics g) {
        g.setColor(color);
        if(shape == GameShape.OVAL) {
            g.fillOval((int)x, (int)y, width, height);
        } else if(shape == GameShape.RECTANGLE) {
            g.fillRect((int)x, (int)y, width, height);
        } else {
            System.out.println("ERROR");
        }
        
    }

    @Override
    public ArrayList<GameObject> getCollisions(ArrayList<GameObject> gameObjects) {
        ArrayList<GameObject> collisions = new ArrayList<>();
        boolean xColide,yColide;
        for (GameObject obj : gameObjects) {
            xColide = (this.x < obj.getX() - obj.getWidth() && this.x - this.width > obj.getX());
            yColide = (this.y < obj.getY() - obj.getHeight() && this.y - this.height > obj.getY());
            if(xColide && yColide) {
                collisions.add(obj);
            }
        }
        return collisions;
        //
    }
    
}
