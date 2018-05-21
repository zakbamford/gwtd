public class Player {
	private int money;
	private int lives;

	public Player(int m, int l) {
		money = m;
		lives = l;
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
