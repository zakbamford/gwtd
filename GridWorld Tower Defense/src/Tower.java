import javax.xml.stream.Location;

import java.util.ArrayList;

public abstract class Tower extends Entity {

	protected int range;
	protected int damage;
	protected int fireRate;
	protected double cost;

	public void act() {
		attack(getEnemies());
	}

	public abstract ArrayList<Enemy> getEnemies();

	public abstract void attack(ArrayList<Enemy> enemies);

	public double getCost() {
		return cost;

	}

	public void setCost(double cost) {
		this.cost = cost;

	}

	public int getDamage() {
		return damage;

	}

	public void setDamage(int damage) {
		this.damage = damage;

	}

	public int fireRate() {
		return fireRate;

	}

	public void setFireRate(int firerate) {
		this.fireRate = firerate;

	}
}
