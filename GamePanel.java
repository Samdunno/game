import javax.swing.*;
import java.util.ArrayList;
import java.awt.*;
import java.awt.image.ImageObserver;

public class GamePanel extends JPanel{
    private final int WIDTH = 800;
    private final int HEIGHT = 600;
    ArrayList<GameObject> go = new ArrayList<GameObject>();
    ArrayList<Movable> movers = new ArrayList<Movable>();
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
        e = new Enemy(1100, 100, player);
        ground = new Ground(0, HEIGHT-50, 2000, 50, GameShape.RECTANGLE, new Color(65, 250, 100));

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

        //Adds all controls for when key is released.
        Function stopRight = () -> player.stopRight();
        c.addControlUp(68, stopRight);
        Function stopLeft = () -> player.stopLeft();
        c.addControlUp(65, stopLeft);

        //Adding the objects to respective arrays.
        go.add(ground);
        go.add(player);
        go.add(e);
        movers.add(player);
        movers.add(e);
        this.addKeyListener(c);
        
    }
    public void update()
    {
        while(true){
        for(Movable m: movers)
        {
            if(player.isColliding(ground) && player.getYVel() >= 0) {
                player.setOnGround(true);
                player.correctPosition(ground);
            } else {
                player.setOnGround(false);
            }
            if(e.isColliding(ground) && e.getYVel() >= 0) {
                e.setOnGround(true);
                e.correctPosition(ground);
            } else {
                e.setOnGround(false);
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
