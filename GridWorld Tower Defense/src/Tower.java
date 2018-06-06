import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

public abstract class Tower extends Entity implements ActionListener {

	protected int range;
	protected int damage;
	protected int fireRate;
	protected double cost;
	protected Timer timer;

	public Tower(int fireRate) {
		this.fireRate = fireRate;
		timer = new Timer((1000 / fireRate), this);
		timer.start();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == timer) {
			System.out.println("Timer tick");
			act();
		}
	}

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
