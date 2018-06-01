import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
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
	private JTextArea playerinfo = new JTextArea(10, 5);
	private JTextArea towerinfo = new JTextArea(10, 15);
	private JButton[][] grid = new JButton[20][30];
	private JPanel buttonpanel;
	private GamePanel gamepanel;
	private Player player;
	private Timer timer;
	private ImageLoader loader;

	// private ImageLoader loader;

	public GuiMain(Player player) {
		super("Tower Defense");
		towerinfo
				.setText("Welcome to GridWorld Defense! \n How to play: \n Build towers to kill enemies. \n Don't let the enemies get \n to your base. \n If you lose all your health, \n then it's game over for you. \n Good Luck!");
		towerinfo.setEditable(false);
		setLayout(new BorderLayout());
		this.player = player;
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
		invisiblebutton = new JRadioButton();
		gamepanel = new GamePanel();
		loader = new ImageLoader();
		ButtonHandler buttonHandler = new ButtonHandler();
		ButtonGroup buttons = new ButtonGroup();
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
		playerinfo
				.setText("Player Info: \n Money: 2000 \n Health: 200 \n Wave: 0");
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

		for (Location l : player.getWorld().getPath().getFullPath())
			grid[l.getY()][l.getX()].setBackground(Color.YELLOW);

		add(gamepanel, BorderLayout.CENTER);
		// Add the tiles later
		// Figure out how to add it to the border layout
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				System.exit(0);
			}
		});
		setSize(1800, 1000);
		setVisible(true);
	}

	private class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == startwave) {
				System.err.println("Timer started");
				timer = new Timer(20, this);
				player.getWorld().spawnNextWave();
			} else if (e.getSource() == timer) {
				System.err.println("timer tick");
				gamepanel.updateUI();
				for (Enemy en : player.getWorld().getEnemies()) {
					en.act();
				}
				for (int i = 0; i < Constants.GRID_X; i++) {
					for (int j = 0; j < Constants.GRID_Y; j++)
						player.getWorld().getGrid().get(i, j).act();
				}
				if (player.getWorld().waveIsDone())
					timer.stop();
			} else {
				for (int r = 0; r < 20; r++) {
					for (int c = 0; c < 30; c++) {
						if (e.getSource() == grid[r][c]) {
							System.out.println("Button at [" + r + ", " + c
									+ "] pressed.");
							if (tower.isSelected()
									&& grid[r][c].getBackground() == Color.green) {
								grid[r][c].setBackground(Color.white);
								invisiblebutton.setSelected(true);
							}
							if (firetower.isSelected()
									&& grid[r][c].getBackground() == Color.green) {
								grid[r][c].setBackground(Color.red);
								invisiblebutton.setSelected(true);
							}
							if (icetower.isSelected()
									&& grid[r][c].getBackground() == Color.green) {
								grid[r][c].setBackground(Color.cyan);
								invisiblebutton.setSelected(true);
							}
							if (snipertower.isSelected()
									&& grid[r][c].getBackground() == Color.green) {
								grid[r][c].setBackground(Color.gray);
								invisiblebutton.setSelected(true);
							}
							if (ubertower.isSelected()
									&& grid[r][c].getBackground() == Color.green) {
								grid[r][c].setBackground(Color.MAGENTA);
								invisiblebutton.setSelected(true);
							}
						}
					}
				}
			}
			if (e.getSource() == getinfo) {
				if (tower.isSelected()) {
					towerinfo
							.setText("Basic Tower. \n The most basic tower in the game \n Shoots lazers at the enemies. \n Damage: 10 \n Fire Rate: 1 ammo per second \n Range: 1 space in any direction \n COST: 200");
				}
				if (firetower.isSelected()) {
					towerinfo
							.setText("Fire Tower. \n A tower made of fire \n Shoots fire in all directions. \n Damage: 8 \n Fire Rate: 1 ammo per second \n Range: 1 space in any direction \n COST: 1000");
				}
				if (icetower.isSelected()) {
					towerinfo
							.setText("Ice Tower. \n Slows down enemies \n Shoots lazers at the enemies. \n Damage: 10 \n Fire Rate: 1 ammo per second \n Range: 1 space in any direction \n COST: 200");
				}
				if (snipertower.isSelected()) {
					towerinfo
							.setText("Sniper Tower. \n  \n Shoots lazers at the enemies. \n Damage: 25 \n Fire Rate: 1 ammo per 3 seconds \n Range: 8 spaces in any direction \n COST: 500");
				}
				if (ubertower.isSelected()) {
					towerinfo
							.setText("Uber Tower. \n This will kill everything \n Same as basic tower \n Damage: 100 \n Fire Rate: 5 ammo per second \n Range: Everywhere \n COST: 50,000");
				}
			}
		}
	}

	class GamePanel extends JPanel {
		// this needs to be worked on
		public void paint(Graphics g) {
			super.paint(g);
			for (Enemy e : player.getWorld().getEnemies()) {
				g.drawImage(e.getImage(), e.getLoc().getX(), e.getLoc().getY(),
						this);
			}
		}
	}

	public static void main(String[] args) {
		Player p = new Player();
		new GuiMain(p);
	}
}
