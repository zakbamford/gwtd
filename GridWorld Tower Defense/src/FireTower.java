import java.util.ArrayList;

public class FireTower extends Tower {

	public FireTower(Location loc, World world) {
		super(1);
		damage = 20;
		range = 2;
		cost = 500;
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
		return inRange;
	}

	public void attack(ArrayList<Enemy> enemies) {
		if (enemies.size() > 0) {
			for (Enemy e : enemies) {
				world.addLaser(loc.getX() * Constants.PIXELS_PER_SQUARE_HORIZ
						+ Constants.PIXELS_PER_SQUARE_HORIZ / 2, loc.getY()
						* Constants.PIXELS_PER_SQUARE_VERT
						+ Constants.PIXELS_PER_SQUARE_VERT / 2, e.getLoc()
						.getX() + e.getImage().getWidth(null) / 2, e.getLoc()
						.getY() + e.getImage().getHeight(null) / 2);
				e.setHealth(e.getHealth() - damage);
			}
		}
	}
}