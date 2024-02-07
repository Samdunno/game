import java.awt.event.*;
import java.util.HashMap;

/**The {@code Controller} class is the class that can handle key events.
 * It stores a control down, and a control up HashMap that can be added to,
 * or rebound.
 */
public class Controller implements KeyListener{
    private HashMap<Integer, Function> controlsDown = new HashMap();
    private HashMap<Integer, Function> controlsUp = new HashMap<>();
    /**Creates a new {@code Controller} */
    public Controller () {
        
    }

    /**
     * Adds a new KeyBinding when a key is pressed down.
     * @param keyCode
     * @param func
     */
    public void addControlDown(int keyCode, Function func) {
        controlsDown.put(keyCode, func);
    }

    /**
     * Adds a new KeyBinding when a key is Released.
     * @param keyCode
     * @param func
     */
    public void addControlUp(int keyCode, Function func) {
        controlsUp.put(keyCode, func);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if(controlsDown.containsKey(keyCode)) {
            controlsDown.get(keyCode).apply();
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if(controlsUp.containsKey(keyCode)) {
            controlsUp.get(keyCode).apply();
        }
        
    }
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
}
