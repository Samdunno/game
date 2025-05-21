import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

public class Sprites {
    public String CurrentState;
    public Map<String, Sprite> Sprites;// = new HashMap<String, Integer>();

    public Sprites(String currentState, Map<String, Sprite> sprites) {
        this.CurrentState = currentState;
        this.Sprites = sprites; 
    }

    public void SetState(String newState) {
        if (Sprites.containsKey(newState)) {
            this.CurrentState = newState;
            Sprites.get(newState).ResetFrame();
        }
    }

    public Sprite  GetCurrentSprite() {
        return this.Sprites.get(this.CurrentState);
    }

}
