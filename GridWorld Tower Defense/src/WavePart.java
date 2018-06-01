public class WavePart implements Actor {

	private int count; // the amount of enemies to be spawn
	private int ticksBetweenSpawn; // the enemy spawn rate
	private int ticksSinceSpawn; // how long since the last enemy was spawned
	private int startTime; // how far into the wave this wave part should start
	private int spawned; //the amount of enemies that have been spawned so far
	private Enemy enemy; // the enemy to be spawned in this wave part
	private World world; //the world in which to spawn this enemy

	// Constructs a part of a wave with only one enemy type
	public WavePart(int count, int ticksBetweenSpawn, int startTime, Enemy enemy, World world) {
		this.count = count;
		this.ticksBetweenSpawn = ticksBetweenSpawn;
		this.startTime = startTime;
		spawned = 0;
		this.enemy = enemy;
		this.world = world;
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
		while (spawned < count) {
			if (ticksSinceSpawn == ticksBetweenSpawn) {
				world.addEnemy(enemy);
				ticksSinceSpawn = 0;
				spawned++;
			}
		}
	}
	
	public boolean isDone() {
		return (spawned >= count);
	}
}
