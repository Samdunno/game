import java.awt.*;
public interface GameObject{

    public float getX();
    public float getY();
    public int getWidth();
    public int getHeight();
    public GameShape getShape();
    public Color getColor();
    public void paintSelf(Graphics g);

}
