import javax.xml.stream.Location;
import java.util.ArrayList;

public class SniperTower extends Tower {

	private Location loc;
	private int range;
	private int damage;
	private int fireRate;
	private double cost;

	public SniperTower() {
		damage = 25;
		fireRate = 5;
		range = 8;// infinite
		cost = 500;

	}

	public void act() {
		ArrayList<Location> gr = getGrid().getOccupiedLocations(getLocation());

		ArrayList<Enemy> a = new ArrayList<Enemy>();

		for (int i = 0; i < gr.size(); i++) {
			if (getGrid().get(gr.get(i)) instanceof Enemy) {
				a.add((Enemy) (getGrid().get(gr.get(i))));
			}

		}
		if (a.size > 0) {
			int time = fireRate;
			fireRate--;

			if (fireRate == 0) {
				attack();
				fireRate = time;
			}

		}

	}

	public void attack() {

		ArrayList<Location> gr = getGrid().getOccupiedLocations(getLocation());

		ArrayList<Enemy> a = new ArrayList<Enemy>();

		for (int i = 0; i < gr.size(); i++) {
			if (getGrid().get(gr.get(i)) instanceof Enemy) {
				a.add((Enemy) (getGrid().get(gr.get(i))));
			}

		}

		// decrease health of enemy based on damage
		int random = (int) (Math.random() * a.size());
		int damageHealth = a.get(random).getHealth() - damage;
		a.get(random).setHealth(damageHealth);

	}

}
