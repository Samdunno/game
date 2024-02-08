import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Camera {

    Player player;
    GamePanel panel;
    Rectangle lastFrameClip;
    Rectangle cameraBuffer;

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
            // lastFrameClip = new Rectangle(0, 0, panel.getWidth(), panel.getHeight());
        }

        //center buffer in bounds
        cameraBuffer.setLocation((int) (lastFrameClip.getX() + (lastFrameClip.getWidth() - cameraBuffer.getWidth())/2), 
        (int)(lastFrameClip.getY() + (lastFrameClip.getHeight() - cameraBuffer.getHeight()) /2) );

        //check if our player is within buffer of clip bounds
        if (player.getX() + player.getWidth() > cameraBuffer.getX() + cameraBuffer.getWidth()) {
            //move cam right
            // moveX = (int) (cameraBuffer.getX() + cameraBuffer.getWidth() - (player.getX() + player.getWidth()));
            moveX = (int) (player.getX() + player.getWidth() - (cameraBuffer.getX() + cameraBuffer.getWidth()));

        } else if (player.getX() < cameraBuffer.getX() ) {
            moveX = (int) ( player.getX() - cameraBuffer.getX() );

        }

        if (player.getY() + player.getHeight() > cameraBuffer.getY() + cameraBuffer.getHeight()) {
            //move cam down
            // cameraBuffer.setLocation((int)cameraBuffer.getX(), (int)(player.getY() + player.getHeight() - cameraBuffer.getHeight()));
            moveY = (int) (player.getY() + player.getHeight() -(cameraBuffer.getY() + cameraBuffer.getHeight()));
        } else if (player.getY() < cameraBuffer.getY() ) {
            //move cam up
            // cameraBuffer.setLocation((int)cameraBuffer.getX(), (int)player.getY());
            moveY = (int) (player.getY() - cameraBuffer.getY()  );
        }

        
        // g.translate((int)lastClipBounds.getX(), (int)lastClipBounds.getY());
        if (moveX != 0 || moveY != 0) {
            
            System.out.println("Move x: " + String.valueOf(moveX) + " Move y: " + String.valueOf(moveY));
            // lastClipBounds.x = moveX;
            //moveY = 0;// moveY/2;
            lastFrameClip.translate(moveX, moveY);
            
        }

        //output frame info TODO:remove me
        g.drawString(cameraBuffer.toString().replace("java.awt.Rectangle", "Camera Buffer "), 10, 10);
        g.drawString(lastFrameClip.toString().replace("java.awt.Rectangle", "Cam Clip "), 10, 20);
        g.drawString("Player X: " + String.valueOf(player.getX() + "Player Y: " + String.valueOf(player.getY())), 10, 40);
        g.drawString(g.getClipBounds().toString().replace("java.awt.Rectangle", "Frame Clip "), 10, 50);

        //inverse for graphics translate
        g.translate(-(int)lastFrameClip.getX(), -(int)lastFrameClip.getY());  
        
    }


}
