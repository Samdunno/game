import javax.swing.*;
import java.awt.*;
public class GameFrame
{
    public static void main(String[] args) {
        JFrame frame = new JFrame("GrizzlyMilk");
        GamePanel panel = new GamePanel();
        frame.add(panel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        panel.update();
    }
}