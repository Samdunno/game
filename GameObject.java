import java.awt.*;
public interface GameObject{

    public float getX();
    public float getY();
    public void setX(float x);
    public void setY(float y);

    public int getWidth();
    public int getHeight();
    public GameShape getShape();
    public Color getColor();

}
