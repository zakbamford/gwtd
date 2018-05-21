import java.util.ArrayList;


public class World {
	private ArrayList<Enemy> enemies;
	private Grid grid;
	
	public World() {
		enemies = new ArrayList<Enemy>();
		grid = new Grid();
	}

	public void addEnemy(Enemy enemy) {
		enemies.add(enemy);
	}
	
	public void setEnemies(ArrayList<Enemy> enemies) {
		this.enemies = enemies;
	}

	public Grid getGrid() {
		return grid;
	}
}
