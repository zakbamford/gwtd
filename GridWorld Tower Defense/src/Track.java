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
	
	public void addEnemy(Enemy enemy) {
		enemies.add(enemy);
	}

	public boolean nextMoveIsValid(Enemy enemy) {
		Location loc = turnLocs.get(enemy.getTrackStage());
		int newCoord;
		switch (enemy.getDir()) {
		case 0:
			newCoord = enemy.getY() + enemy.getSpeed();
			if (newCoord >= loc.getCol()) {
				return false;
			}
			break;
		case 90:
			newCoord = enemy.getX() + enemy.getSpeed();
			if (newCoord >= loc.getRow()) {
				return false;
			}
			break;
		case 180:
			newCoord = enemy.getY() - enemy.getSpeed();
			if (newCoord <= loc.getCol()) {
				return false;
			}
			break;
		case 270:
			newCoord = enemy.getX() - enemy.getSpeed();
			if (newCoord <= loc.getRow()) {
				return false;
			}
			break;
		}
		return true;
	}
	
	public int movesLeftInSide(Enemy enemy) {
		Location loc = turnLocs.get(enemy.getTrackStage());
		switch (enemy.getDir()) {
		case 0:
			return loc.getCol() - enemy.getX();
		case 90:
			return loc.getRow() - enemy.getY();
		case 180:
			return loc.getCol() + enemy.getX();
		case 270:
			return loc.getRow() + enemy.getY();
		default:
			return -1;
		}
	}
	
	public Location getNextLoc(Enemy enemy) {
		int stage = enemy.getTrackStage();
		Location loc = new Location(enemy.getLocation())
	}
}
