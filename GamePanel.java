import javax.swing.*;
import javax.xml.stream.events.EndElement;

import java.util.ArrayList;
import java.awt.*;
import java.awt.image.ImageObserver;

public class GamePanel extends JPanel{
    private final int WIDTH = 800;
    private final int HEIGHT = 600;
    ArrayList<GameObject> go = new ArrayList<GameObject>();
    ArrayList<Entity> movers = new ArrayList<Entity>();
    Player player;
    Ground ground;
    Controller c;
    Camera cam;
    Enemy e;
    
    public GamePanel()
    {
        this.setFocusable(true);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        c = new Controller();
        player = new Player(500f, 100f);
        for(int i = 0; i < 1; i++) {
            Enemy e = new Enemy(-1000 + 20 * i, 100, player);
            go.add(e);
            movers.add(e);
        }
        
        ground = new Ground(-5000, HEIGHT-50, 10000, 50, GameShape.RECTANGLE, new Color(65, 250, 100));

        //camera buffer 30% of screen size
        var camBuffer = new Rectangle(0, 0, (int)(WIDTH * .3), (int)(HEIGHT * .3));

        cam = new Camera(player, this, camBuffer);

        //Adds all controls for when key is pressed down.
        Function moveLeft = () -> {player.moveLeft(); };
        c.addControlDown(65, moveLeft);
        Function moveRight = () -> player.moveRight();
        c.addControlDown(68, moveRight);
        Function jump = () -> player.jump();
        c.addControlDown(32, jump);
        Function attack = () -> go.add(player.attack());
        c.addControlDown(75, attack);

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
        for(Entity m: movers)
        {
            if(m.isColliding(ground) && m.getYVel() >= 0) {
                m.setOnGround(true);
                m.correctPosition(ground);
            } else {
                m.setOnGround(false);
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
        // g.translate((int) -cam.getX() + WIDTH /2 - player.getWidth() /2, (int) -cam.getY() + HEIGHT /2 - player.getHeight() /2);
        cam.TranslateCamera(g);
        
        for(GameObject go: go)
        {
            go.paintSelf(g);
            
        }
        g.drawRect((int)player.getX(), (int)player.getY(), player.getWidth(), player.getHeight());
    }
    
    public int getHeight() {
        return HEIGHT;
    }

    public int getWidth() {
        return WIDTH;
    }

}
