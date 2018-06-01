import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Player {
	private int money;
	private int lives;
	private World world;

	public Player() {
		money = 100;
		lives = 100;
		world = new World();
	}

	public int getMoney() {
		return money;
	}

	public int getLives() {
		return lives;
	}

	public void giveMoney() {
		money += 10;
	}

	public void takeLives() {
		lives--;
	}

	public World getWorld() {
		return world;
	}

	public void purchase(BasicTower t) {
		money -= t.getCost();
	}

	public void purchase(FireTower t) {
		money -= t.getCost();
	}

	public void purchase(IceTower t) {
		money -= t.getCost();
	}

	public void purchase(SniperTower t) {
		money -= t.getCost();
	}

	public void purchase(UberTower t) {
		money -= t.getCost();
	}

	public void lose()
	{
		if (//enemy reaches end)
		{
			lives--;
		}
		if (lives == 0)
		{
			//game over
		}
	}
}
