import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;


public class GamePanel extends JPanel implements Actor {

	private final int x = 30;
	private final int y = 20;
	
	public GamePanel() {
		JButton[][] grid = new JButton[y][x];
		setLayout(new GridLayout(20, 30));
		 //GIVE CREDIT TO RDONUK (stackoverflow.com) FOR HELP WITH THE GUI
		 for(int i = 0; i < 20; i++)
		 {
		   for(int j = 0; j < 30; j++)
		   {
			   grid[i][j] = new JButton();
			   grid[i][j].setBackground(Color.green);
			   add(grid[i][j]);
		   }
		 }
	}
	
	public void act() {
		
	}

}
