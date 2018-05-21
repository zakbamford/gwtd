
//Some method names and signatures taken from GridWorld BoundedGrid class

public class Grid {
	private Entity[][] entities;
	private final int x = 30;
	private final int y = 20;
	
	public Grid() {
		entities = new Entity[y][x];
	}
	
	public void addEntity(Entity entity) {
		Location loc = entity.getLoc();
		int x = loc.getX();
		int y = loc.getY();
		entities[x][y] = entity;
	}
	
	public Entity get(int x, int y) {
		return entities[y][x];
	}
	
	public Entity remove(int x, int y) {
		Entity e = entities[y][x];
		entities[y][x] = null;
		return e;
	}
	
	public boolean add(int x, int y, Entity entity) {
		if (entities[y][x] == null) {
			entities[y][x] = entity;
			return true;
		}
		return false;
	}
	
	
}
