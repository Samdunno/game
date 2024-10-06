public class BasicAttack implements Skill, Collider {
    private Cooldown cooldown;
    private float x, y;
    private int width, height;
    private GameObject attacker;
        
    public BasicAttack(GameObject attacker, Cooldown cooldown, int radiusOfAttack) {
        this.width = radiusOfAttack;
        this.height = radiusOfAttack;
        this.cooldown = cooldown;
        this.x = attacker.getX();
        this.y = attacker.getY();
        this.attacker = attacker;
    }
    @Override
    public boolean isColliding(Collider c) {
        if(attacker.isColliding(c)) {
            //TODO
            //Add damage logic.
            return true;
        }
        return false;
    }
    @Override
    public boolean isCooldownUp() {
        // TODO Auto-generated method stub
        return cooldown.timeUp();
    }
    @Override
    public void startCooldown() {
        // TODO Auto-generated method stub
      cooldown.startTimer();  
    }
    @Override
    public int getHeight() {
        // TODO Auto-generated method stub
        return height;
    }
    @Override
    public int getWidth() {
        // TODO Auto-generated method stub
        return width;
    }
    @Override
    public int getX() {
        // TODO Auto-generated method stub
        return (int)x;
    }
    @Override
    public int getY() {
        // TODO Auto-generated method stub
        return (int)y;
    }

    
}
