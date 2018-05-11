public class WavePart {

	//private Enemy enemyType; // the type of enemy in this wave part
	private int count; // the amount of enemies to be spawn
	private int ticksBetweenSpawn; // the enemy spawn rate
	private int startTime; // how far into the wave this wave part should start
	private boolean startedSpawning; // whether this wave part has already
										// started spawning

	// Constructs a part of a wave with only one enemy type
	//public WavePart(Enemy e, int c, int t, int s) {

	//}

	// gets start time of this wave
	public int getStartTime() {
		return startTime;
	}
	
	// spawns wave
	public void spawn() {
		//can't do this yet, needs other classes
	}
}
