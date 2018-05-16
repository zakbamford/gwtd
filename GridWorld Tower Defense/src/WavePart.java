public class WavePart {

	private Enemy enemy; // the enemy to be spawned in this wave part
	private int count; // the amount of enemies to be spawn
	private int ticksBetweenSpawn; // the enemy spawn rate
	private int startTime; // how far into the wave this wave part should start

	// Constructs a part of a wave with only one enemy type
	public WavePart(Enemy enemy, int count, int ticksBetweenSpawn, int startTime) {
		this.enemy = enemy;
		this.count = count;
		this.ticksBetweenSpawn = ticksBetweenSpawn;
		this.startTime = startTime;
	}

	// gets start time of this wave
	public int getStartTime() {
		return startTime;
	}
	
	// spawns wave
	public void spawn() {
		Enemy e;
		for (int i = 0; i < count; i++) {
			e = new Enemy(enemy);
			//spawn the enemy into track
		}
	}
}
