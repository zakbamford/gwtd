import java.util.ArrayList;

public class FireTower extends Tower {

	public FireTower() {
		damage = 8;
		fireRate = 1; // per second
		range = 6;
		cost = 1000;

	}

	public ArrayList<Enemy> getEnemies() {
		ArrayList<Enemy> enemies = world.getEnemies();
		ArrayList<Enemy> inRange = new ArrayList<Enemy>();
		for (Enemy e : enemies) {
			if (e.getLoc().distanceTo(loc) <= (range * Constants.PIXELS_PER_SQUARE))
				inRange.add(e);
		}
		return inRange;
	}

	public void attack(ArrayList<Enemy> enemies) {
		for (Enemy e : enemies) {
			e.setHealth(e.getHealth() - damage);
		}
	}

}
