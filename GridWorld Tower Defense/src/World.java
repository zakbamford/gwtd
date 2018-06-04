import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class World {
	private int wave;
	private ArrayList<Enemy> enemies;
	private ArrayList<Enemy> enemyList;
	private ArrayList<Wave> waves;
	private Grid grid;
	private Path path;

	public World() {
		wave = 0;
		enemies = new ArrayList<Enemy>();
		grid = new Grid();
		enemyList = new ArrayList<Enemy>();
		waves = new ArrayList<Wave>();
		initImages();
		initTrack();
		initWave1();
	}

	private void initImages() {
		try {
			// read in images
			BufferedImage img = ImageIO.read(new File("H:\\APCS\\Bug.gif"));
			// add enemies to enemy list
			enemyList.add(new Enemy(10, 5, null, img, this));
		} catch (IOException e) {
			System.err
					.println("Some or all resources not found, exiting game.");
			System.exit(0);
		}
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
		parts.add(new WavePart(10, 25, 0, enemyList.get(0), this));
		waves.add(new Wave(parts));
	}

	private void initWave2() {

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
		return waves.get(wave).isDone();
	}

	public void spawnNextWave() {
		waves.get(wave).spawn();
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
}