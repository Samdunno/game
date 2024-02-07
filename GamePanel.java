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
    Controller c;
    Camera cam;


    public GamePanel()
    {
        this.setFocusable(true);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        c = new Controller();
        player = new Player(500f, 100f);
        ground = new Ground(0, HEIGHT-50, 800, 50, GameShape.RECTANGLE, new Color(65, 250, 100));
        cam = new Camera(player);

        //Adds all controls for when key is pressed down.
        Function moveLeft = () -> {player.moveLeft(); };
        c.addControlDown(65, moveLeft);
        Function moveRight = () -> player.moveRight();
        c.addControlDown(68, moveRight);
        Function jump = () -> player.jump();
        c.addControlDown(32, jump);

        //Adds all controls for when key is released.
        Function stopRight = () -> player.stopRight();
        c.addControlUp(68, stopRight);
        Function stopLeft = () -> player.stopLeft();
        c.addControlUp(65, stopLeft);

        //Adding the objects to respective arrays.
        go.add(ground);
        go.add(player);
        movers.add(player);
        this.addKeyListener(c);
        
    }
    public void update()
    {
        while(true){
        for(Movable m: movers)
        {
            if(player.isColliding(ground) && player.getYVel() >= 0) {
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
        
        // g.translate(12, 12);
        g.translate((int) -cam.getX() + WIDTH /2 - player.getWidth() /2, (int) -cam.getY() + HEIGHT /2 - player.getHeight() /2);

        for(GameObject go: go)
        {
            go.paintSelf(g);
            
        }
    }
    
}
