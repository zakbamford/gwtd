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

	public void attack() {
		ArrayList<Location> locs = grid.getOccupiedAdjacentLocations(loc);

		ArrayList<Enemy> a = new ArrayList<Enemy>();

		for (int k = 0; k < gr.size(); k++) {
			if (getGrid().get(gr.get(k)) instanceof Enemy) {
				a.add((Enemy) (getGrid().get(gr.get(k))));
			}

		}

		for (int i = 0; i < a.size(); i++) {
			// decrease health of enemy based on damage
			int damageHealth = a.get(i).getHealth() - damage;
			a.get(i).setHealth(damageHealth);

		}
	}

	@Override
	public void attack(ArrayList<Enemy> enemies) {
		// TODO Auto-generated method stub

	}

}
