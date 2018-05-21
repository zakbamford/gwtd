
public abstract class Entity implements Actor {
	protected Location loc;
	protected Grid grid;
	
	public void act() {
	}
	
	public void removeSelfFromGrid() {
		grid.remove(loc.getY(), loc.getX());
	}

	public Location getLoc() {
		return loc;
	}

	public void setLoc(Location loc) {
		this.loc = loc;
	}
}
