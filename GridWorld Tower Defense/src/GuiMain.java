import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
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
	private ImageIcon img;
	private BufferedImage image;

	// private ImageLoader loader;

	public GuiMain(Player player) {
		super("Tower Defense");
		setResizable(false);
		towerinfo.setText(
				"Welcome to GridWorld Defense! \n How to play: \n Build towers to kill enemies. \n Don't let the enemies get \n to your base. \n If you lose all your health, \n then it's game over for you. \n Good Luck!");
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
		playerinfo.setText("Player Info: \n Money: 2000 \n Health: 200 \n Wave: 0");
		playerinfo.setEditable(false);
		// Adding the button panel to a panel that stores everything
		add(buttonpanel, BorderLayout.EAST);
		try {
			image = ImageIO.read(new File("C:\\f\\Bug.gif"));
			img = new ImageIcon(image);
		} catch (Exception ex) {
			System.out.println(ex);
		}

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

		for (Location l : player.getWorld().getPath().getFullGridPath())
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
		public void actionPerformed(ActionEvent en) {

			if (en.getSource() == startwave) {
				timer = new Timer(20, this);
				timer.start();
				player.getWorld().spawnNextWave();

			} else if (en.getSource() == timer) {
				Constants.TIME++;
				// System.out.println(Constants.TIME);
				gamepanel.updateUI();
				for (Enemy ene : player.getWorld().getEnemies()) {
					ene.act();
				}
				for (int i = 0; i < Constants.GRID_X; i++) {
					// for (int j = 0; j < Constants.GRID_Y; j++)
					// player.getWorld().getGrid().get(i, j).act();
				}
				if (player.getWorld().waveIsDone())
					timer.stop();
			} else {
				for (int r = 0; r < 20; r++) {
					for (int c = 0; c < 30; c++) {
						if (en.getSource() == grid[r][c]) {
							if (tower.isSelected() && grid[r][c].getBackground() == Color.green) {
								grid[r][c].setBackground(Color.white);
								invisiblebutton.setSelected(true);
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
							}
							if (ubertower.isSelected() && grid[r][c].getBackground() == Color.green) {
								grid[r][c].setBackground(Color.MAGENTA);
								invisiblebutton.setSelected(true);
							}
						}
					}
				}
			}
			if (en.getSource() == getinfo) {
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
			for (Enemy e : player.getWorld().getEnemies()) {
				g.drawImage(e.getImage(), e.getLoc().getX(), e.getLoc().getY(), this);
			}
			
			// DEBUG ONLY: PAINT PIXEL PATH
		/*	Path p = player.getWorld().getPath();
			ArrayList<Location> l = p.getFullPixelPath();
			ArrayList<Location> ll = p.getFullGridPath();
			Graphics2D g2 = (Graphics2D)g;
			for (int i = 0; i < l.size()-1; i++) {
				g2.setStroke(new BasicStroke(5));
				g2.setColor(Color.BLACK);
				g.drawLine(l.get(i).getX(), l.get(i).getY(), l.get(i+1).getX(), l.get(i+1).getY());
			}*/
			
			
		}
	}

	public static void main(String[] args) {
		Player p = new Player();
		new GuiMain(p);
	}
}