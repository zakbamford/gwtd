import java.awt.Image;
import java.util.ArrayList;

public class Enemy extends Entity {

	private int health;
	private int dir;
	private int speed;
	private int trackStage;
	private Enemy spawnOnDeath;
	private Image img;
	private ArrayList<Location> path;

	public Enemy(int health, int speed, Enemy spawnOnDeath, Image img, ArrayList<Location> path) {
		this.health = health;
		dir = 90;
		this.speed = speed;
		trackStage = 0;
		this.spawnOnDeath = spawnOnDeath;
		this.img = img;
		this.setPath(path);
	}

	public Enemy(Enemy enemy) {
		health = enemy.getHealth();
		dir = 90;
		speed = enemy.getSpeed();
		trackStage = 0;
		spawnOnDeath = enemy.getSpawnOnDeath();
		img = enemy.getImg();
		setPath(enemy.getPath());
	}

	public void act() {
		if (health <= 0)
			die();
		else if (atEndOfTrack())
			reachGoal();
		else
			move();
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getDir() {
		return dir;
	}

	public void setDir(int dir) {
		this.dir = dir;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getTrackStage() {
		return trackStage;
	}

	public void settrackStage(int getTrackStage) {
		this.trackStage = getTrackStage;
	}

	public Enemy getSpawnOnDeath() {
		return spawnOnDeath;
	}

	public void setSpawnOnDeath(Enemy spawnOnDeath) {
		this.spawnOnDeath = spawnOnDeath;
	}

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}

	public ArrayList<Location> getPath() {
		return path;
	}

	public void setPath(ArrayList<Location> path) {
		this.path = path;
	}

	private void move() {
		if (nextMoveIsValid()) {
			moveUninterrupted();
		} else {
			moveInterrupted();
		}
	}

	private void moveUninterrupted() {
		switch (dir) {
		case 0:
			loc.setY(loc.getY() + speed);
			break;
		case 90:
			loc.setX(loc.getX() + speed);
			break;
		case 180:
			loc.setY(loc.getY() - speed);
			break;
		case 270:
			loc.setX(loc.getX() - speed);
			break;
		}
	}

	private void moveInterrupted() {
		int moves = movesLeftInSide();
		int more = speed - moves;
		switch (dir) {
		case 0:
			loc.setY(loc.getY() + moves);
			break;
		case 90:
			loc.setX(loc.getX() + moves);
			break;
		case 180:
			loc.setY(loc.getY() - moves);
			break;
		case 270:
			loc.setY(loc.getY() + moves);
			break;
		}
		dir = loc.getDirectionToward(getNextLoc());
		switch (dir) {
		case 0:
			loc.setY(loc.getY() + more);
			break;
		case 90:
			loc.setX(loc.getX() + more);
			break;
		case 180:
			loc.setY(loc.getY() - more);
			break;
		case 270:
			loc.setY(loc.getY() + more);
			break;
		}
	}

	private void die() {
		removeSelfFromGrid();
		// need to give money to player here
	}

	private void reachGoal() {
		removeSelfFromGrid();
		// need to take lives from player here
	}

	private boolean nextMoveIsValid() {
		Location loc = path.get(trackStage);
		int newCoord;
		switch (dir) {
		case 0:
			newCoord = loc.getY() + speed;
			if (newCoord >= loc.getY()) {
				return false;
			}
			break;
		case 90:
			newCoord = loc.getX() + speed;
			if (newCoord >= loc.getX()) {
				return false;
			}
			break;
		case 180:
			newCoord = loc.getY() - speed;
			if (newCoord <= loc.getY()) {
				return false;
			}
			break;
		case 270:
			newCoord = loc.getX() - speed;
			if (newCoord <= loc.getX()) {
				return false;
			}
			break;
		}
		return true;
	}

	private int movesLeftInSide() {
		Location loc = path.get(trackStage);
		switch (dir) {
		case 0:
			return loc.getY() - loc.getY();
		case 90:
			return loc.getX() - loc.getX();
		case 180:
			return loc.getY() + loc.getY();
		case 270:
			return loc.getX() + loc.getX();
		default:
			return -1;
		}
	}

	private Location getNextLoc() {
		int stage = trackStage + 1;
		return path.get(stage);
	}

	private boolean atEndOfTrack() {
		// need to write this
		return false;
	}
}
