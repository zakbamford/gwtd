import java.util.ArrayList;

public class SniperTower extends Tower {

	public SniperTower(Location loc, World world) {
		super(1);
		damage = 30;
		range = 9001;
		cost = 1000;
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
			world.addLaser(loc.getX() * Constants.PIXELS_PER_SQUARE_HORIZ
					+ Constants.PIXELS_PER_SQUARE_HORIZ / 2, loc.getY()
					* Constants.PIXELS_PER_SQUARE_VERT
					+ Constants.PIXELS_PER_SQUARE_VERT / 2, enemies.get(0)
					.getLoc().getX()
					+ enemies.get(0).getImage().getWidth(null) / 2, enemies
					.get(0).getLoc().getY()
					+ enemies.get(0).getImage().getHeight(null) / 2);
			Enemy e = enemies.get(0);
			e.setHealth(e.getHealth() - damage);
		}
	}
}