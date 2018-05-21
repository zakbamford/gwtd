public class WavePart implements Actor {

	private int count; // the amount of enemies to be spawn
	private int ticksBetweenSpawn; // the enemy spawn rate
	private int ticksSinceSpawn; //how long since the last enemy was spawned
	private int startTime; // how far into the wave this wave part should start
	private Enemy enemy; // the enemy to be spawned in this wave part

	// Constructs a part of a wave with only one enemy type
	public WavePart(int count, int ticksBetweenSpawn, int startTime, Enemy enemy) {
		this.count = count;
		this.ticksBetweenSpawn = ticksBetweenSpawn;
		this.startTime = startTime;
		this.enemy = enemy;
	}

	public void act() {
		ticksSinceSpawn++;
	}
	
	// gets start time of this wave
	public int getStartTime() {
		return startTime;
	}
	
	// spawns wave
	public void spawn() {
		for (int i = 0; i < count; i++) {
			if (ticksSinceSpawn == ticksBetweenSpawn) {
				grid.add(Path.)
				ticksSinceSpawn = 0;
			}
		}
	}
}
