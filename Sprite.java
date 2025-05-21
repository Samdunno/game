import java.awt.Image;
import java.time.Instant;

public class Sprite {
    private Image[] frames;
    private String name;
    private int currentFrame;
    private Instant lastFrameChange;
    private int millisecondsPerFrame;

    public Image[] GetFrames() {
        return frames;
    }

    public void ResetFrame() {
        this.currentFrame = 0;
        this.lastFrameChange = Instant.now();
    }

    public void AdvanceFrame() {
        if (currentFrame >= frames.length - 1)
            currentFrame = 0;
        else
            currentFrame++;

        lastFrameChange = Instant.now();
    }

    public Boolean ReadyToAdvance() {
        if (Instant.now().isAfter(lastFrameChange.plusMillis((long)millisecondsPerFrame)))
            return true;
        else
            return false;
    }
    
    public Image GetImage() {
        if (ReadyToAdvance()) {
                AdvanceFrame();
        }

        return frames[currentFrame];
    }

    public Sprite(String name, Image[] frames, int millisecondsPerFrame ) {
        this.frames = frames;
        this.name = name;
        this.millisecondsPerFrame = millisecondsPerFrame;
        lastFrameChange = Instant.now();
        currentFrame = 0;
    }
}
