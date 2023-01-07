import javax.swing.*;
import java.util.ArrayList;
import java.awt.*;
import java.util.Date;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.List;

public class GamePanel extends JPanel {
    private final int WIDTH = 800;
    private final int HEIGHT = 600;
    private final float WORLD_FACTOR = 10f;
    Player player = new Player(500f, 100f, 0f, 0f);
    ArrayList<GameObject> go = new ArrayList<GameObject>();
    ArrayList<Movable> movers = new ArrayList<Movable>();

    Date lastUpdate = new Date();

    Ground ground;

    public GamePanel() {
        this.setFocusable(true);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        ground = new Ground(0, HEIGHT - 50, 800, 50, new Color(65, 250, 100));
        go.add(ground);
        go.add(player);
        movers.add(player);

        // Runnable r = new Runnable(updateComponents());
        new Thread(() -> updateComponents()).start();

        // Thread t2 = new Thread(() => updateComponents());

        // Thread t1 = new Thread(new Runnable() {
        // @Override
        // public void run() {
        // // code goes here.
        // System.out.println("word");
        // }
        // });
        // t1.start();

    }

    public void updateComponents() {
        while (true) {
            // System.out.println("waiting");
            long elapsedMs = new Date().getTime() - lastUpdate.getTime();

            try {

                ArrayList<CollisionCheck> cc = new ArrayList<CollisionCheck>();
                // List<Pair<String, Integer>> result = new ArrayList<>();
                for (Movable m : this.movers) {
                    for (GameObject g : go) {
                        if (m != g)
                            cc.add(new CollisionCheck(m, g));
                        
                    }
                }


                // List<CollisionCheck> cc = this.movers.stream().
                //     flatMap(m -> this.go.stream().map(g -> g)).collect(Collectors.toList());
                    // flatMap(m -> this.go.stream().filter(g -> g != m).map(g -> new CollisionCheck(m, g))).collect(Collectors.toList());

                //apply gravity
                for (Movable m : movers) {
                    applyGravity(elapsedMs, m);
                    moveObjects(elapsedMs, m);
                    m.move();
                }

                lastUpdate = new Date();
                repaint();
                Thread.sleep(5);

            } catch (Exception e) {
                // TODO: handle exception
            }
            
        }

    }

    public void applyGravity(long elapsedMs, Movable mo) {
        // 9.8m/s2
        float accel = 9.8f;
        float velChange = accel * (elapsedMs / 1000f);

        mo.setYVel(mo.getYVel() + velChange);

    }

    public void moveObjects(long elapsedMs, Movable mo) {
        mo.setX(mo.getX() + mo.getXVel() * (elapsedMs / 1000f) * WORLD_FACTOR);
        mo.setY(mo.getY() + mo.getYVel() * (elapsedMs / 1000f) * WORLD_FACTOR);
        System.out.println(mo.getY());
    }

    public void checkCollision(Movable m, GameObject go) {
        boolean xCol = false, yCol = false;
        if (m.getX() <= go.getX() + go.getWidth() && m.getX() + m.getWidth() >= go.getX()) {
            // System.out.println("x overlap");
            xCol = true;
        }

        if (m.getY() <= go.getY() + go.getHeight() && m.getY() + m.getHeight() >= go.getY()) {
            // System.out.println("y overlap");
            yCol = true;
        }

        if (xCol && yCol)
            System.out.println("collision!!!!!");

    }

    public void update() {
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (GameObject go : go) {
            g.setColor(go.getColor());
            switch (go.getShape()) {
                case RECTANGLE:
                    g.fillRect((int) go.getX(), (int) go.getY(), go.getWidth(), go.getHeight());
                    break;
                case OVAL:
                    g.fillOval((int) go.getX(), (int) go.getY(), go.getWidth(), go.getHeight());
                default:
                    break;
            }
        }
    }
}
