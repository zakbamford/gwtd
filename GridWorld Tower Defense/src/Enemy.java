public abstract class Enemy implements Actor {

	private int health;
	private int x;
	private int y;
	private Track track;

	public void act() {
		move();
	}

	private void move() {
		
	}

}
