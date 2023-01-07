public interface Movable extends GameObject {
    final static float GRAVITY = 0.2f;
    public void move();
    public float getXVel();
    public float getYVel();
    public void setXVel(float xVel);
    public void setYVel(float yVel);

}
