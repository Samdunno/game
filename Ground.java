import java.awt.*;
public class Ground implements GameObject {
    private float x;
    private float y;
    private int width;
    private int height;
    private Color color;
    GameShape shape;
    public Ground(float x, float y, int w, int h, Color c)
    {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
        this.color = c;
        shape = GameShape.RECTANGLE;
    }
    public void paintSelf(Graphics g)
    {
        g.fillRect((int)this.x, (int)this.y, width, height);
    }
    @Override
    public int getHeight() {
        // TODO Auto-generated method stub
        return height;
    }

    @Override
    public GameShape getShape() {
        // TODO Auto-generated method stub
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

    @Override
    public Color getColor()
    {

        return color;
    }
   
    
}
