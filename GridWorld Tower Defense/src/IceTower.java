import javax.xml.stream.Location;
import java.util.ArrayList;

public class IceTower extends Tower {

	private Location loc;
	private int range;
	private int damage;
	private int fireRate;
	private double cost;
	private int ice;

	public IceTower() {
		damage = 10;
		fireRate = 1;
		range = 8;
		cost = 800;
		ice = 20;

	}

	public void attack() {

		ArrayList<Location> gr = getGrid().getOccupiedAdjacentLocations(
				getLocation());

		ArrayList<Enemy> a = new ArrayList<Enemy>();

		for (int i = 0; i < gr.size(); i++) {
			if (getGrid().get(gr.get(i)) instanceof Enemy) {
				a.add((Enemy) (getGrid().get(gr.get(i))));
			}

		}

		int random = (int) (Math.random() * a.size());
		int damageHealth = a.get(random).getHealth() - damage;

		a.get(random).setHealth(damageHealth);

		if (a.get(random).getColor().equals(Color.BLUE)) {

		} else {
			int slowSpeed = a.get(random).getSpeed() - ice;
			a.get(random).setSpeed(slowSpeed);
			a.get(random).setColor(Color.BLUE);
			Thread.sleep(2000); // slows speed for 2 seconds
			a.get(random).setColor(Color.RED);// sets color back to normal
			a.get(random).setSpeed(slowSpeed + ice);
		}

	}

}
