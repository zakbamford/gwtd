import java.util.ArrayList;

public class BasicTower extends Tower {

	public BasicTower(Location loc, World world) {
		super(1);
		damage = 1;
		range = 2;
		cost = 200;
		this.loc = loc;
		this.world = world;
	}

	public ArrayList<Enemy> getEnemies() {
		ArrayList<Enemy> enemies = world.getEnemies();
		ArrayList<Enemy> inRange = new ArrayList<Enemy>();
		for (int i = 0; i < enemies.size(); i++) {
			if (enemies.get(i).getLoc().distanceTo(loc) <= (range * Constants.PIXELS_PER_SQUARE_VERT)) {
				inRange.add(enemies.get(i));
			}
		}
		ArrayList<Enemy> ret = new ArrayList<Enemy>();
		if (inRange.size() > 0)
			ret.add(inRange.get(0));
		return ret;
	}

	public void attack(ArrayList<Enemy> enemies) {
		if (enemies.size() > 0) {
			Enemy e = enemies.get(0);
			e.setHealth(e.getHealth() - damage);
		}
	}

	public double getCost() {
		return cost;

	}

	public void setCost(double cost) {
		this.cost = cost;

	}

	public int getDamage() {
		return damage;

	}

	public void setDamage(int damage) {
		this.damage = damage;

	}

	public int fireRate() {
		return fireRate;

	}

	public void setFireRate(int firerate) {
		this.fireRate = firerate;

	}
}