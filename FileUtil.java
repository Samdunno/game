import javax.imageio.ImageIO;
import javax.imageio.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

public class FileUtil {
    public static void loadImage() {
        
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

