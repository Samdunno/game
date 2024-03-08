import javax.imageio.ImageIO;
import javax.imageio.*;

import java.awt.Image;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

public class FileUtil {
    public static Image loadImage(String pathString) {
        BufferedImage img;

        try{
            img = ImageIO.read(new File(pathString));
            return img.getScaledInstance(64, 64, 0);
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public static BufferedImage cell1() {
        BufferedImage img;

        try{
            img = ImageIO.read(new File("character.png"));
            return img.getSubimage(25, 10, 36, 36);
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
        
    }

}

