import java.util.ArrayList;

public class Wave implements Actor {

	private ArrayList<WavePart> parts;
	private int ticks;

	// Constructs a wave of enemies consisting of different wave parts
	public Wave(ArrayList<WavePart> parts) {
		this.parts = parts;
	}

	// Spawns this wave
	// precondition: subwaves are sorted by spawn time
	// postcondition: entire wave has been spawned
	public void spawn() {
		int i = 0;
		while (i < parts.size()) {
			if (ticks == parts.get(i).getStartTime()) {
				parts.get(i).spawn();
				i++;
			}
		}
	}
	
	public void act() {
		ticks++;
	}
	
	public int getTicks() {
		return ticks;
	}
}