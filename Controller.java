import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;


public class Controller implements KeyListener{
    private HashMap<Integer, Function> controlsDown = new HashMap();
    private HashMap<Integer, Function> controlsUp = new HashMap<>();
    public Controller () {
        
    }

    public void addControlDown(int keyCode, Function func) {
        controlsDown.put(keyCode, func);
    }
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
        System.out.println(keyCode);
        if(controlsUp.containsKey(keyCode)) {
            controlsUp.get(keyCode).apply();
            System.out.println("HI");
        }
        
    }
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
}
