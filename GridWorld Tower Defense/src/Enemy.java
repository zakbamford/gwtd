import java.awt.Image;

public class Enemy implements Actor {

	private int health;
	private int x;
	private int y;
	private int dir;
	private int speed;
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

	private void move() {
		
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
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
}
