import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

public class Wave implements ActionListener {

	private int currentPart;
	private ArrayList<WavePart> parts;
	private Timer timer;

	// Constructs a wave of enemies consisting of different wave parts
	public Wave(ArrayList<WavePart> parts) {
		currentPart = 0;
		this.parts = parts;
	}

	// Spawns this wave
	// precondition: subwaves are sorted by spawn time
	// postcondition: entire wave has been spawned
	public void spawn() {
		timer = new Timer(20, this);
		timer.start();
		actionPerformed(null);
	}

	public void actionPerformed(ActionEvent e) {
		parts.get(currentPart).spawn();
		currentPart++;
		if (currentPart == parts.size()) {
			timer.stop();
		}
	}
}