import java.awt.Image;

public abstract class Entity implements Actor {
	protected Location loc;
	protected Grid grid;
	protected World world;
	protected Image img;

	public abstract void act();

	public void removeSelfFromGrid() {
		world.removeEnemy((Enemy) this);
	}

	public Location getLoc() {
		return loc;
	}

	public void setLoc(Location loc) {
		this.loc = loc;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

	public Image getImage() {
		return img;
	}

	public void setImage(Image image) {
		img = image;
	}
}