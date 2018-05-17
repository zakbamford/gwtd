
public abstract class Entity implements Actor {
	protected Location loc;
	
	public void act() {
	}
	
	public void removeSelfFromGrid() {
		//to be completed later
	}

	public Location getLoc() {
		return loc;
	}

	public void setLoc(Location loc) {
		this.loc = loc;
	}
}
