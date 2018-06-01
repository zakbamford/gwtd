import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class TowerPanel extends JPanel implements Actor, ActionListener {

	private final int x = 30;
	private final int y = 20;
	private final JButton[][] grid;
	private final int PIXELS_PER_SQUARE = 50; // this will be changed
	private World world;

	public TowerPanel(World world) {
		this.world = world;
		grid = new JButton[y][x];
		setLayout(new GridLayout(20, 30));
		// GIVE CREDIT TO RDONUK (stackoverflow.com) FOR HELP WITH THE GUI
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				grid[i][j] = new JButton();
				grid[i][j].addActionListener(this);
				grid[i][j].setBackground(Color.green);
				add(grid[i][j]);
			}
		}
	}

	public void act() {

	}

	public void actionPerformed(ActionEvent event) {
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				if (event.getSource() == grid[i][j])
					System.out.println("Button at [" + i + ", " + j + "] pressed.");
			}
		}
	}

	/*
	 * public void paint(Graphics g) { int enemyX, enemyY; Image img;
	 * super.paint(g); for (Enemy e : world.getEnemies()) { img = e.getImage();
	 * enemyX = e.getLoc().getX(); enemyY = e.getLoc().getY(); g.drawImage(img,
	 * enemyX, enemyY, this); } Grid grid = world.getGrid(); Entity e; for (int
	 * i = 0; i < y; i++) { for (int j = 0; j < x; j++) { e = grid.get(i, j);
	 * g.drawImage(e.getImage(), j * PIXELS_PER_SQUARE, i * PIXELS_PER_SQUARE,
	 * this); } } }
	 */

}
