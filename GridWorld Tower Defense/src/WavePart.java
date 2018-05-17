public class WavePart {

	private int count; // the amount of enemies to be spawn
	private int ticksBetweenSpawn; // the enemy spawn rate
	private int startTime; // how far into the wave this wave part should start
	private Enemy enemy; // the enemy to be spawned in this wave part
	private Track track; //the track on which to spawn the enemies

	// Constructs a part of a wave with only one enemy type
	public WavePart(int count, int ticksBetweenSpawn, int startTime, Enemy enemy, Track track) {
		this.count = count;
		this.ticksBetweenSpawn = ticksBetweenSpawn;
		this.startTime = startTime;
		this.enemy = enemy;
		this.track = track;
	}

	// gets start time of this wave
	public int getStartTime() {
		return startTime;
	}
	
	// spawns wave
	public void spawn() {
		for (int i = 0; i < count; i++) {
			track.addEnemy(new Enemy(enemy));
		}
	}
}
