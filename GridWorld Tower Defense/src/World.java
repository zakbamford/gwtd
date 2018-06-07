import java.awt.geom.Line2D;
import java.util.ArrayList;

public class World {
	private int wave;
	private int money;
	private int lives;
	private ArrayList<Enemy> enemies;
	private ArrayList<Enemy> enemyList;
	private ArrayList<Wave> waves;
	private ArrayList<Line2D.Double> lasers;
	private Grid grid;
	private Path path;
	private ImageLoader loader;
	private World world;

	public World() {
		wave = 0;
		money = 1000;
		lives = 100;
		enemies = new ArrayList<Enemy>();
		grid = new Grid();
		enemyList = new ArrayList<Enemy>();
		waves = new ArrayList<Wave>();
		lasers = new ArrayList<Line2D.Double>();
		loader = new ImageLoader();
		initImages();
		initTrack();
		initWave1();
		initWave2();
	}

	private void initImages() {
		enemyList.add(new Enemy(10, 5, loader.getRedBug().getImage(), this));
		enemyList.add(new Enemy(15, 7, loader.getBlueBug().getImage(), this));
		enemyList.add(new Enemy(15, 10, loader.getGreenBug().getImage(), this));
	}

	private void initTrack() {
		ArrayList<Location> locs = new ArrayList<Location>();
		locs.add(new Location(0, 8));
		locs.add(new Location(4, 8));
		locs.add(new Location(4, 14));
		locs.add(new Location(9, 14));
		locs.add(new Location(9, 17));
		locs.add(new Location(12, 17));
		locs.add(new Location(12, 8));
		locs.add(new Location(8, 8));
		locs.add(new Location(8, 3));
		locs.add(new Location(15, 3));
		locs.add(new Location(15, 7));
		locs.add(new Location(19, 7));
		locs.add(new Location(19, 12));
		locs.add(new Location(16, 12));
		locs.add(new Location(16, 16));
		locs.add(new Location(25, 16));
		locs.add(new Location(25, 4));
		locs.add(new Location(22, 4));
		locs.add(new Location(22, 1));
		locs.add(new Location(28, 1));
		locs.add(new Location(28, 6));
		locs.add(new Location(29, 6));
		path = new Path(locs);
	}

	private void initWave1() {
		ArrayList<WavePart> parts = new ArrayList<WavePart>();
		parts.add(new WavePart(10, 5, 0, enemyList.get(0), this));
		waves.add(new Wave(parts));
	}

	private void initWave2() {
		ArrayList<WavePart> parts = new ArrayList<WavePart>();
		parts.add(new WavePart(10, 25, 0, enemyList.get(2), this));
		parts.add(new WavePart(20, 5, 0, enemyList.get(0), this));
		waves.add(new Wave(parts));
	}

	private void initWave3() {

	}

	private void initWave4() {

	}

	private void initWave5() {

	}

	private void initWave6() {

	}

	private void initWave7() {

	}

	private void initWave8() {

	}

	private void initWave9() {

	}

	private void initWave10() {

	}

	public int getCurrentWave() {
		return wave;
	}

	public boolean waveIsDone() {
		return enemies.size() == 0;
	}

	public void spawnNextWave() {
		waves.get(wave).spawn();
		wave++;
	}

	public void addEnemy(Enemy enemy) {
		enemies.add(enemy);
	}

	public ArrayList<Enemy> getEnemies() {
		return enemies;
	}

	public ArrayList<Enemy> getEnemyList() {
		return enemyList;
	}

	public void setEnemyList(ArrayList<Enemy> enemyList) {
		this.enemyList = enemyList;
	}

	public Wave getWave(int num) {
		return waves.get(num);
	}

	public boolean addEntity(int x, int y, Entity entity) {
		return grid.add(x, y, entity);
	}

	public Grid getGrid() {
		return grid;
	}

	public Path getPath() {
		return path;
	}

	public void removeEnemy(Enemy enemy) {
		System.out.println("Removed enemy: " + enemies.remove(enemy));
	}

	public void addLaser(int x1, int y1, int x2, int y2) {
		lasers.add(new Line2D.Double(x1, y1, x2, y2));
	}

	public ArrayList<Line2D.Double> getLasers() {
		return lasers;
	}

	public int getMoney() {
		return money;
	}

	public int getLives() {
		return lives;
	}

	public void giveMoney() {
		money += 10;
	}

	public void takeLives(int lives) {
		this.lives -= lives;
	}

	public World getWorld() {
		return world;
	}

	public void purchase(BasicTower t) {
		money -= t.getCost();
	}

	public void purchase(FireTower t) {
		money -= t.getCost();
	}

	public void purchase(IceTower t) {
		money -= t.getCost();
	}

	public void purchase(SniperTower t) {
		money -= t.getCost();
	}

	public void purchase(UberTower t) {
		money -= t.getCost();
	}

	public void lose()
	{
		if (//enemy reaches end)
		{
			lives--;
		}
		if (lives == 0)
		{
			//game over
		}
	}
}
