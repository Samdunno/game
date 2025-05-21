import javax.imageio.ImageIO;
import javax.imageio.*;

import java.awt.Image;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileUtil {
    public static Image loadImage(String pathString) {
        BufferedImage img;

        try {
            img = ImageIO.read(new File(pathString));
            return img.getScaledInstance(64, 64, 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static BufferedImage cell1() {
        BufferedImage img;

        try {
            img = ImageIO.read(new File("character.png"));
            return img.getSubimage(25, 10, 36, 36);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static BufferedImage Load(String fileName) {
        // BufferedImage img;

        try {
            return ImageIO.read(new File(fileName));
            // return img.getSubimage(25, 10, 36, 36);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static Sprites SpriteLoader(String fileName, String[] sprintNames, int cols, int millisecondsPerFrame,
            String defaultState) {

        var img = FileUtil.Load(fileName);
        var colw = (float) (img.getWidth()) / cols;
        var rowh = (float) img.getHeight() / sprintNames.length;
        var sprites = new HashMap<String, Sprite>();

        for (int r = 0; r < sprintNames.length; r++) {
            var name = sprintNames[r];
            var frames = new ArrayList<Image>();

            for (int c = 0; c < cols; c++) {
                var frame = img.getSubimage((int) (c * colw), (int) (r * rowh), (int) colw, (int) rowh);
                if (!ImageBlank(frame)) 
                    frames.add(frame);
            }

            var framearray = frames.toArray(new Image[frames.size()]);

            sprites.put(name, new Sprite(name, framearray, millisecondsPerFrame));
        }

        var retSprites = new Sprites(defaultState, sprites);

        return retSprites;

    }

    private static Boolean ImageBlank(BufferedImage image) {
        boolean isBlank = true;
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                if (image.getRGB(x, y) != 0) { // Assuming 0 represents a "blank" pixel
                    isBlank = false;
                    return false;
                    // break;
                }
            }
            if (!isBlank) {
                break;
            }
        }

        if (isBlank) {
            System.out.println("Image is blank");
            return true;
            
        } else {
            System.out.println("Image is not blank");
            return false;
            
        }
    }

}
