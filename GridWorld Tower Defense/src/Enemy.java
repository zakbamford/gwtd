import java.awt.Image;
import java.util.ArrayList;

public class Enemy extends Entity {

	private int health;
	private int dir;
	private int speed;
	private int trackStage;
	private Enemy spawnOnDeath;
	private Image img;
	private Player player;

	public Enemy(int health, int speed, Enemy spawnOnDeath, Image img, Player player) {
		this.health = health;
		dir = 90;
		this.speed = speed;
		trackStage = 0;
		this.spawnOnDeath = spawnOnDeath;
		this.img = img;
		this.setPlayer(player);
	}

	public Enemy(Enemy enemy) {
		health = enemy.getHealth();
		dir = 90;
		speed = enemy.getSpeed();
		trackStage = 0;
		spawnOnDeath = enemy.getSpawnOnDeath();
		img = enemy.getImg();
		setPlayer(enemy.getPlayer());
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
	
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
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
		
	}

	private void reachGoal() {
		removeSelfFromGrid();
		// need to take lives from player here
	}

	private boolean nextMoveIsValid() {
		Location loc = Path.path[trackStage];
		int newCoord;
		switch (dir) {
		case 0:
			newCoord = loc.getY() + speed;
			if (newCoord >= loc.getY())
				return false;
			break;
		case 90:
			newCoord = loc.getX() + speed;
			if (newCoord >= loc.getX())
				return false;
			break;
		case 180:
			newCoord = loc.getY() - speed;
			if (newCoord <= loc.getY())
				return false;
			break;
		case 270:
			newCoord = loc.getX() - speed;
			if (newCoord <= loc.getX())
				return false;
			break;
		}
		return true;
	}

	private int movesLeftInSide() {
		Location loc = Path.path[trackStage];
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
		return Path.path[trackStage + 1];
	}

	private boolean atEndOfTrack() {
		int finalStage = Path.path.length - 1;
		Location finalLoc = Path.path[finalStage];
		if (trackStage != finalStage) {
			return false;
		} else {
			switch (loc.getDirectionToward(finalLoc)) {
			case 0:
				if (loc.getY() >= finalLoc.getY())
					return true;
				break;
			case 90:
				if (loc.getX() >= finalLoc.getX())
					return true;
			case 180:
				if (loc.getY() <= finalLoc.getY())
					return true;
			case 270:
				if (loc.getX() <= finalLoc.getX())
					return true;
			}
			return false;
		}
	}
}
