import javax.swing.*;
import java.util.ArrayList;
import java.awt.*;

public class GamePanel extends JPanel{
    private final int WIDTH = 800;
    private final int HEIGHT = 600;
    Player player = new Player(500f, 100f, 0f, 0f);
    ArrayList<GameObject> go = new ArrayList<GameObject>();
    ArrayList<Movable> movers = new ArrayList<Movable>();

    Ground ground;
    public GamePanel()
    {
        this.setFocusable(true);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        ground = new Ground(0, HEIGHT-50, 800, 50, new Color(65, 250, 100));
        go.add(ground);
        go.add(player);

    }
    public void update()
    {
        repaint();
    }
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        for(GameObject go: go)
        {
            g.setColor(go.getColor());
            switch (go.getShape()) {
                case RECTANGLE:
                    g.fillRect((int)go.getX(), (int)go.getY(), go.getWidth(), go.getHeight());
                    break;
                case OVAL:
                    g.fillOval((int)go.getX(), (int)go.getY(), go.getWidth(), go.getHeight());
                default:
                    break;
            }
        }
    }
}
