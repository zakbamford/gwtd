
public class Grid {
	private Entity[][] entities;
	private final int x = 30;
	private final int y = 30;
	
	public Grid() {
		entities = new Entity[y][x];
	}
	
	public void addEntity(Entity entity) {
		Location loc = entity.getLoc();
		int x = loc.getX();
		int y = loc.getY();
		entities[x][y] = entity;
	}
	
	
}
