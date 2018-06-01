import java.util.ArrayList;

//Some methods taken from GridWorld BoundedGrid class

public class Grid {
	private Entity[][] entities;

	public Grid() {
		entities = new Entity[Constants.GRID_Y][Constants.GRID_X];
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

	public boolean isValid(Location loc) {
		return (loc.getX() >= 0 && loc.getX() < Constants.GRID_X) && (loc.getY() >= 0 && loc.getY() < Constants.GRID_Y);
	}
	
	public ArrayList<Location> getValidAdjacentLocations(Location loc) {
		ArrayList<Location> locs = new ArrayList<Location>();

		int d = Location.NORTH;
		for (int i = 0; i < Location.FULL_CIRCLE / Location.HALF_RIGHT; i++) {
			Location neighborLoc = loc.getAdjacentLocation(d);
			if (isValid(neighborLoc))
				locs.add(neighborLoc);
			d = d + Location.HALF_RIGHT;
		}
		return locs;
	}

	public ArrayList<Location> getOccupiedAdjacentLocations(Location loc) {
		ArrayList<Location> locs = new ArrayList<Location>();
		for (Location neighborLoc : getValidAdjacentLocations(loc)) {
			if (get(neighborLoc) != null)
				locs.add(neighborLoc);
		}
		return locs;
	}

}
