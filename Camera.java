public class Camera {

    Player player;


    public Camera(Player player) 
    {
        this.player = player;
    }

    public float getX() {
        return player.getX();
    }

    public float getY() {
        return player.getY();
    }


}
