import java.awt.Image;

import javax.swing.ImageIcon;


public abstract class Entity implements Actor {
	protected Location loc;
	protected Grid grid;
	protected Player player;
	protected World world;
	protected Image img;
	
	public abstract void act();
	
	public void removeSelfFromGrid() {
		grid.remove(loc.getY(), loc.getX());
	}

	public Location getLoc() {
		return loc;
	}

	public void setLoc(Location loc) {
		this.loc = loc;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
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
