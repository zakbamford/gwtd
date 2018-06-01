import javax.xml.stream.Location;
import java.util.ArrayList;

public class UberTower extends Tower {

	private Location loc;
	private int range;
	private int damage;
	private double fireRate;
	private double cost;

	public UberTower() {
		damage = 80;
		fireRate = .2; // timer before it acts again
		range = 8;//
		cost = 1000;

	}

	public void act() {
		ArrayList<Location> gr = getGrid().getOccupiedAdjacentLocations(
				getLocation());

		ArrayList<Enemy> a = new ArrayList<Enemy>();

		for (int i = 0; i < gr.size(); i++) {
			if (getGrid().get(gr.get(i)) instanceof Enemy) {
				a.add((Enemy) (getGrid().get(gr.get(i))));
			}

		}

		if (a.size > 0) {
			double time = fireRate;
			fireRate--;

			if (fireRate < 0) {
				attack();
				attack();
				attack();
				attack();
				attack();
				fireRate = time;

			}

		}

	}

}
