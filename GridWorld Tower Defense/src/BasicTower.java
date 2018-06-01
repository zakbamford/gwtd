import java.util.ArrayList;

public class BasicTower extends Tower {

	public BasicTower() {
		damage = 10;
		fireRate = 1;
		range = 8;
		cost = 200;
	}

	public ArrayList<Enemy> getEnemies() {
		ArrayList<Enemy> enemies = world.getEnemies();
		ArrayList<Enemy> inRange = new ArrayList<Enemy>();
		for (Enemy e : enemies) {
			if (e.getLoc().distanceTo(loc) <= (range * Constants.PIXELS_PER_SQUARE))
				inRange.add(e);
		}
		ArrayList<Enemy> ret = new ArrayList<Enemy>();
		ret.add(inRange.get(0)); // this will be the enemy closest to the goal
									// that the tower can attack
		return ret;
	}

	public void attack(ArrayList<Enemy> enemies) {
		Enemy e = enemies.get(0);
		e.setHealth(e.getHealth() - damage);
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
