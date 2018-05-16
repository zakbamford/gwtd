import java.util.ArrayList;

public class Track implements Actor {
	private ArrayList<Enemy> enemies;
	private ArrayList<Location> turnLocs;

	public Track(ArrayList<Enemy> enemies) {
		this.enemies = enemies;
	}

	public void act() {
		for (Enemy e : enemies) {
			e.act();
		}
	}
}
