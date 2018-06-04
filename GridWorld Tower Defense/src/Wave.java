import java.util.ArrayList;

public class Wave {

	private ArrayList<WavePart> parts;

	// Constructs a wave of enemies consisting of different wave parts
	public Wave(ArrayList<WavePart> parts) {
		this.parts = parts;
	}

	// Spawns this wave
	// precondition: subwaves are sorted by spawn time
	// postcondition: entire wave has been spawned
	public void spawn() {

		System.out.println("Spawning, parts.size = " + parts.size());
		int i = 0;
		while (i < parts.size()) {
			if (parts.get(i).getStartTime() == Constants.TIME) {
				parts.get(i).spawn();
				i++;
			}
		}
	}

	public boolean isDone() {
		for (WavePart p : parts) {
			if (!p.isDone())
				return false;
		}
		return true;
	}
}