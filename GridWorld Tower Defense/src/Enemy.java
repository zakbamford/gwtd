import java.awt.Image;

public class Enemy extends Entity implements Actor {

	private int health;
	private int dir;
	private int speed;
	private int trackStage;
	private Enemy spawnOnDeath;
	private Track track;
	private Image img;

	public Enemy(int health, int speed, Track track, Image img) {
		this.health = health;
		this.speed = speed;
		this.track = track;
		this.img = img;
	}
	
	public Enemy(Enemy e) {
		health = e.getHealth();
		speed = e.getSpeed();
		track = e.getTrack();
		img = e.getImg();
	}
	
	public void act() {
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

	public Track getTrack() {
		return track;
	}

	public void setTrack(Track track) {
		this.track = track;
	}

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}
	
	private void move() {
		if (track.nextMoveIsValid(this)) {
			moveUninterrupted();
		} else {
			moveInterrupted();
		}
	}
	
	private void moveUninterrupted() {
		switch (dir) {
		case 0:
			y += speed;
			break;
		case 90:
			x += speed;
			break;
		case 180:
			y -= speed;
			break;
		case 270:
			x -= speed;
			break;
		}
	}
	
	private void moveInterrupted() {
		int moves = track.movesLeftInSide(this);
		int more = speed - moves;
		switch (dir) {
		case 0:
			loc.setY(loc.getY() + moves);
			break;
		case 90:
			x += moves;
			break;
		case 180:
			y -= moves;
			break;
		case 270:
			x -= moves;
			break;
		}
		
	}
}
