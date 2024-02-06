import javax.swing.*;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel{
    private final int WIDTH = 800;
    private final int HEIGHT = 600;
    ArrayList<GameObject> go = new ArrayList<GameObject>();
    ArrayList<Movable> movers = new ArrayList<Movable>();
    Player player;
    Ground ground;
    Controller c;
   

    public GamePanel()
    {
        this.setFocusable(true);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        c = new Controller();
        player = new Player(500f, 100f);
        ground = new Ground(0, HEIGHT-50, 800, 50, GameShape.RECTANGLE, new Color(65, 250, 100));

        Function moveLeft = () -> {player.moveLeft(); };
        c.addControlDown(65, moveLeft);
        Function moveRight = () -> player.moveRight();
        c.addControlDown(68, moveRight);
        Function jump = () -> player.jump();
        c.addControlDown(32, jump);

        Function stopRight = () -> player.stopRight();
        c.addControlUp(68, stopRight);
        Function stopLeft = () -> player.stopLeft();
        c.addControlUp(65, stopLeft);

        




        go.add(ground);
        go.add(player);
        movers.add(player);
        this.addKeyListener(c);
        
    }
    public void update()
    {
        //Function moveLeft = () -> System.out.println("hi");;
        //c.addControl(65, moveLeft);
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
        for(GameObject go: go)
        {
            go.paintSelf(g);
            
        }
    }
    
}
