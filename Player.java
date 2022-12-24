import java.awt.Color;

public class Player implements Movable, GameObject{
    float x, y, xVel, yVel;
    int width, height;
    GameShape shape;
    Color color;
    public Player(float x, float y, float xVel, float yVel)
    {
        this.x = x;
        this.y = y;
        this.xVel = xVel;
        this.yVel = yVel;
        width = 20;
        height = 50;
        shape = GameShape.RECTANGLE;
        color = new Color(100, 100, 250);
    }
    @Override
    public float getXVel() {
        // TODO Auto-generated method stub
        return xVel;
    }
    @Override
    public float getYVel() {
        // TODO Auto-generated method stub
        return yVel;
    }
    @Override
    public void move() {
        // TODO Auto-generated method stub
        
    }
    @Override
    public Color getColor() {
        // TODO Auto-generated method stub
        return color;
    }
    @Override
    public int getHeight() {
        // TODO Auto-generated method stub
        return height;
    }
    @Override
    public GameShape getShape() {
        return shape;
    }
    @Override
    public int getWidth() {
        // TODO Auto-generated method stub
        return width;
    }
    @Override
    public float getX() {
        // TODO Auto-generated method stub
        return x;
    }
    @Override
    public float getY() {
        // TODO Auto-generated method stub
        return y;
    }

}
