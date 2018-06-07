import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class WavePart implements ActionListener {

	private int count; // the amount of enemies to be spawn
	private int ticksBetweenSpawn; // the enemy spawn rate
	private int spawned; // the amount of enemies that have been spawned so far
	private Enemy refEnemy; // the enemy to be spawned in this wave part
	private World world; // the world in which to spawn this enemy
	private Timer timer;

	// Constructs a part of a wave with only one enemy type
	public WavePart(int count, int ticksBetweenSpawn, Enemy refEnemy, World world) {
		this.count = count;
		this.ticksBetweenSpawn = ticksBetweenSpawn;
		spawned = 0;
		this.refEnemy = refEnemy;
		this.world = world;
	}

	// spawns wave
	public void spawn() {
		timer = new Timer(ticksBetweenSpawn * Constants.MILLIS_PER_TICK, this);
		timer.start();
		actionPerformed(null);
	}

	public void actionPerformed(ActionEvent e) {
		Enemy enemy = new Enemy(refEnemy);
		world.addEnemy(enemy);
		spawned++;
		if (spawned == count)
			timer.stop();
	}
}