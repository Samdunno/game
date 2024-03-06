import java.awt.Graphics;
import java.awt.Rectangle;

public class Camera {

    Player player;
    GamePanel panel;
    Rectangle lastFrameClip;
    Rectangle cameraBuffer;
    int bufferAreaWidth;
    int bufferAreaHeight;


    public Camera(Player player, GamePanel panel, Rectangle cameraBuffer) 
    {
        this.player = player;
        this.panel = panel;
        this.cameraBuffer = cameraBuffer;
    }

    public float getX() {
        return player.getX();
    }

    public float getY() {
        return player.getY();
    }

    public void TranslateCamera(Graphics g) {
        var moveX = 0;
        var moveY = 0;

        //init frame to 0,0 and size of the game panel
        if (lastFrameClip == null) {
            lastFrameClip = g.getClipBounds();
        }

        //check if our player is within buffer of clip bounds
        if (player.getX() + player.getWidth() > cameraBuffer.getX() + cameraBuffer.getWidth()) {
            //move cam right
            // moveX = (int) (cameraBuffer.getX() + cameraBuffer.getWidth() - (player.getX() + player.getWidth()));
            moveX = (int)((player.getX() + player.getWidth() - (cameraBuffer.getX() + cameraBuffer.getWidth())) / 10.0);

        } else if (player.getX() < cameraBuffer.getX() ) {
            moveX = (int) (( player.getX() - cameraBuffer.getX() ) / 10.0);
        }

        if (player.getY() + player.getHeight() > cameraBuffer.getY() + cameraBuffer.getHeight()) {
            //move cam down
            moveY = (int) (player.getY() + player.getHeight() -(cameraBuffer.getY() + cameraBuffer.getHeight()));
        } else if (player.getY() < cameraBuffer.getY() ) {
            //move cam up
            moveY = (int) (player.getY() - cameraBuffer.getY()  );
        }
        
        if (moveX != 0 || moveY != 0) {
            
            // System.out.println("Move x: " + String.valueOf(moveX) + " Move y: " + String.valueOf(moveY));
            lastFrameClip.translate(moveX, moveY);
            
        }

        //frame debug
        // g.drawString(cameraBuffer.toString().replace("java.awt.Rectangle", "Camera Buffer "), 10, 10);
        // g.drawString(lastFrameClip.toString().replace("java.awt.Rectangle", "Cam Clip "), 10, 20);
        // g.drawString("Player X: " + String.valueOf(player.getX() + "Player Y: " + String.valueOf(player.getY())), 10, 40);
        // g.drawString(g.getClipBounds().toString().replace("java.awt.Rectangle", "Frame Clip "), 10, 50);

        //inverse for graphics translate
        g.translate(-(int)lastFrameClip.getX(), -(int)lastFrameClip.getY());  
        
        //center buffer in new location
        var framloc = g.getClipBounds();
        cameraBuffer.setLocation((int) (framloc.getX() + (framloc.getWidth() - cameraBuffer.getWidth())/2), 
            (int)(framloc.getY() + (framloc.getHeight() - cameraBuffer.getHeight()) /2) );

        //camera buffer debug
        // g.drawRect((int) cameraBuffer.getX(),(int)  cameraBuffer.getY(), (int) cameraBuffer.getWidth(), (int) cameraBuffer.getHeight());

    }


}
