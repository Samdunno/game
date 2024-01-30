import javax.swing.*;
import java.util.ArrayList;
import java.awt.*;

public class GamePanel extends JPanel{
    private final int WIDTH = 800;
    private final int HEIGHT = 600;
    ArrayList<GameObject> go = new ArrayList<GameObject>();
    ArrayList<Movable> movers = new ArrayList<Movable>();
    Player player;
    Ground ground;
    public GamePanel()
    {
        this.setFocusable(true);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        player = new Player(500f, 100f);
        ground = new Ground(0, HEIGHT-50, 800, 50, GameShape.RECTANGLE, new Color(65, 250, 100));
        go.add(ground);
        go.add(player);
        movers.add(player);
    }
    public void update()
    {
        while(true){
        for(Movable m: movers)
        {
            if(player.isColliding(ground)) {
                player.setOnGround(true);
            } else {
                player.setOnGround(false);
            }
            m.doGravity();
            m.move();
        }

        repaint();
        try {
            Thread.sleep(5);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
   
    }
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        for(GameObject go: go)
        {
            go.paintSelf(g);
            
        }
    }
}
