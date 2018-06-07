import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.Timer;

public class GuiMain extends JFrame {
	private JRadioButton tower;
	private JRadioButton firetower;
	private JRadioButton icetower;
	private JRadioButton snipertower;
	private JRadioButton ubertower;
	private JRadioButton invisiblebutton;
	private JButton startwave;
	private JButton getinfo;
	private JTextArea playerinfo;
	private JTextArea towerinfo;
	private JButton[][] grid;
	private JPanel buttonpanel;
	private GamePanel gamepanel;
	private World world;
	private Timer timer;
	private BufferedImage image;
	private ImageLoader loader;

	public GuiMain(World world) {
		super("Tower Defense");
		setResizable(false);
		setLayout(new BorderLayout());
		this.world = world;
		// Initializing and adding the buttons to the button panel
		buttonpanel = new JPanel();
		buttonpanel.setLayout(new GridLayout(10, 1));
		tower = new JRadioButton("Basic Tower");
		firetower = new JRadioButton("Fire Tower");
		icetower = new JRadioButton("Ice Tower");
		snipertower = new JRadioButton("Sniper Tower");
		ubertower = new JRadioButton("Uber Tower");
		startwave = new JButton("Next Wave");
		getinfo = new JButton("Get info of selected tower");
		playerinfo = new JTextArea(10, 5);
		towerinfo = new JTextArea(10, 15);
		grid = new JButton[20][30];
		invisiblebutton = new JRadioButton();
		gamepanel = new GamePanel();
		ButtonHandler buttonHandler = new ButtonHandler();
		ButtonGroup buttons = new ButtonGroup();
		towerinfo.setText(
				"Welcome to GridWorld Defense! \n How to play: \n Build towers to kill enemies. \n Don't let the enemies get \n to your base. \n If you lose all your health, \n then it's game over for you. \n Good Luck!");
		towerinfo.setEditable(false);
		buttons.add(tower);
		buttons.add(firetower);
		buttons.add(icetower);
		buttons.add(snipertower);
		buttons.add(ubertower);
		buttons.add(invisiblebutton);
		buttonpanel.add(tower);
		tower.setBackground(Color.white);
		buttonpanel.add(firetower);
		firetower.setBackground(Color.red);
		buttonpanel.add(icetower);
		icetower.setBackground(Color.CYAN);
		buttonpanel.add(snipertower);
		snipertower.setBackground(Color.gray);
		buttonpanel.add(ubertower);
		ubertower.setBackground(Color.MAGENTA);
		buttonpanel.add(startwave);
		startwave.setBackground(Color.orange);
		startwave.addActionListener(buttonHandler);
		buttonpanel.add(getinfo);
		getinfo.setBackground(Color.PINK);
		getinfo.addActionListener(buttonHandler);
		playerinfo.setBackground(Color.yellow);
		buttonpanel.add(playerinfo);
		playerinfo.setText("Player Info: \n Money: 2000 \n Health: 200 \n Wave: 0");
		playerinfo.setEditable(false);
		// Adding the button panel to a panel that stores everything
		add(buttonpanel, BorderLayout.EAST);

		add(towerinfo, BorderLayout.WEST);
		gamepanel = new GamePanel();
		gamepanel.setLayout(new GridLayout(20, 30));
		// GIVE CREDIT TO RDONUK (stackoverflow.com) FOR HELP WITH THE GUI
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 30; j++) {
				grid[i][j] = new JButton();
				grid[i][j].setBackground(Color.green);
				gamepanel.add(grid[i][j]);
				grid[i][j].addActionListener(buttonHandler);
			}
		}

		for (Location l : world.getPath().getFullGridPath())
			grid[l.getY()][l.getX()].setBackground(Color.YELLOW);
		add(gamepanel, BorderLayout.CENTER);
		// Add the tiles later
		// Figure out how to add it to the border layout
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				System.exit(0);
			}
		});

		setSize(1600, 900);
		setVisible(true);
	}

	private class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == startwave) {
				timer = new Timer(Constants.MILLIS_PER_TICK, this);
				timer.start();
				world.spawnNextWave();
				startwave.setEnabled(false);

			} else if (e.getSource() == timer) {
				gamepanel.updateUI();
				for (int i = 0; i < world.getEnemies().size(); i++) {
					world.getEnemies().get(i).act();
				}
				if (world.waveIsDone()) {
					startwave.setEnabled(true);
				}
				playerinfo.setText("Player Info: \n Money: " + world.getMoney() + "\n Health: " + world.getLives() +  "\n Wave: " + world.getCurrentWave());
			} else {
				for (int r = 0; r < 20; r++) {
					for (int c = 0; c < 30; c++) {
						if (e.getSource() == grid[r][c]) {
							if (tower.isSelected() && grid[r][c].getBackground() == Color.green) {
								grid[r][c].setBackground(Color.white);
								invisiblebutton.setSelected(true);
								BasicTower b = new BasicTower(new Location(c, r), world);
								world.getGrid().add(c, r, b);
							}
							if (firetower.isSelected() && grid[r][c].getBackground() == Color.green) {
								grid[r][c].setBackground(Color.red);
								invisiblebutton.setSelected(true);
							}
							if (icetower.isSelected() && grid[r][c].getBackground() == Color.green) {
								grid[r][c].setBackground(Color.cyan);
								invisiblebutton.setSelected(true);
							}
							if (snipertower.isSelected() && grid[r][c].getBackground() == Color.green) {
								grid[r][c].setBackground(Color.gray);
								invisiblebutton.setSelected(true);
								SniperTower b = new SniperTower(new Location(c, r), world);
								world.getGrid().add(c, r, b);
							}
							if (ubertower.isSelected() && grid[r][c].getBackground() == Color.green) {
								grid[r][c].setBackground(Color.MAGENTA);
								invisiblebutton.setSelected(true);
							}
						}
					}
				}
			}
			if (e.getSource() == getinfo) {
				if (tower.isSelected()) {
					towerinfo.setText(
							"Basic Tower. \n The most basic tower in the game \n Shoots lazers at the enemies. \n Damage: 10 \n Fire Rate: 1 ammo per second \n Range: 1 space in any direction \n COST: 200");
				}
				if (firetower.isSelected()) {
					towerinfo.setText(
							"Fire Tower. \n A tower made of fire \n Shoots fire in all directions. \n Damage: 8 \n Fire Rate: 1 ammo per second \n Range: 1 space in any direction \n COST: 1000");
				}
				if (icetower.isSelected()) {
					towerinfo.setText(
							"Ice Tower. \n Slows down enemies \n Shoots lazers at the enemies. \n Damage: 10 \n Fire Rate: 1 ammo per second \n Range: 1 space in any direction \n COST: 200");
				}
				if (snipertower.isSelected()) {
					towerinfo.setText(
							"Sniper Tower. \n  \n Shoots lazers at the enemies. \n Damage: 25 \n Fire Rate: 1 ammo per 3 seconds \n Range: 8 spaces in any direction \n COST: 500");
				}
				if (ubertower.isSelected()) {
					towerinfo.setText(
							"Uber Tower. \n This will kill everything \n Same as basic tower \n Damage: 100 \n Fire Rate: 5 ammo per second \n Range: Everywhere \n COST: 50,000");
				}
			}
		}
	}

	class GamePanel extends JPanel {
		// this needs to be worked on
		public void paint(Graphics g) {
			// Draw Swing components first
			super.paint(g);
			for (Enemy e : world.getEnemies()) {
				g.drawImage(e.getImage(), e.getLoc().getX(), e.getLoc().getY(), this);
			}
			Graphics2D g2 = (Graphics2D) g;
			for (int i = 0; i < world.getLasers().size(); i++) {
				g2.setStroke(new BasicStroke(15));
				g.setColor(Color.RED);
				g2.draw(world.getLasers().get(i));
				world.getLasers().remove(i);
			}
		}
	}

	public static void main(String[] args) {
		World w = new World();
		new GuiMain(w);
	}
}