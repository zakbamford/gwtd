import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.awt.Point;
public class GuiMain extends JFrame implements ActionListener
{
 private JRadioButton tower;
 private JRadioButton firetower;
 private JRadioButton icetower;
 private JRadioButton snipertower;
 private JRadioButton ubertower;
 private JButton startwave;
 private JTextArea towerinfo;
 private JPanel gamepanel;
 private JPanel buttonpanel;
 private JLabel logo;
 public GuiMain()
 {
	 super("GridWorld Tower Defense");
	 setLayout(new BorderLayout());
	 logo = new JLabel("GridWorld Defense");
	 add(logo, BorderLayout.SOUTH);
	//Initializing and adding the buttons to the button panel
	 buttonpanel = new JPanel();
	 buttonpanel.setLayout(new GridLayout(6,2));
	 tower = new JRadioButton("Basic Tower");
	 firetower = new JRadioButton("Fire Tower");
	 icetower = new JRadioButton("Ice Tower");
	 snipertower = new JRadioButton("Sniper Tower");
	 ubertower = new JRadioButton("Uber Tower");
	 startwave = new JButton("Next Wave");
	 ButtonGroup buttons = new ButtonGroup();
	 buttons.add(tower);
	 buttons.add(firetower);
	 buttons.add(icetower);
	 buttons.add(snipertower);
	 buttons.add(ubertower);
	 buttonpanel.add(tower);
	 buttonpanel.add(firetower);
	 buttonpanel.add(icetower);
	 buttonpanel.add(snipertower);
	 buttonpanel.add(ubertower);
	 buttonpanel.add(startwave);
	 
	 startwave.addActionListener(this);
	 //Adding the button panel to a panel that stores everything
	 add(buttonpanel, BorderLayout.EAST);
	 
	 towerinfo = new JTextArea(10, 15);
	 add(towerinfo, BorderLayout.WEST);
	 gamepanel = new GamePanel();
	 add(gamepanel, BorderLayout.CENTER);
	 //Add the tiles later
	 //Figure out how to add it to the border layout
	 
	 addWindowListener(new java.awt.event.WindowAdapter()
	 {
	   public void windowClosing(WindowEvent evt)
	   {
		   System.exit(0);
	   }
	 });
	 setSize(1800,1000);
	 setVisible(true); 
 }
 public void actionPerformed(ActionEvent e)
 {
	if(e.getSource() == startwave)
	{
		//Add enemies one at a time to the location
	}
 }

 public void paint(Graphics g)
 {
 super.paint(g);
 }
 private class MouseHandler implements MouseListener
 {
  public void mouseEntered(MouseEvent e)
  {
	  
  }
  public void mouseExited(MouseEvent e)
  {
	  
  }
  public void mouseClicked(MouseEvent e)
  {   
	  //DOESNT WORK, FIGURE OUT WHY LATER
	  Point point = new Point(e.getX(), e.getY());
	  for(int i = 0; i < 20; i++)
		 {
		   for(int j = 0; j < 30; j++)
		   {
			  Point gridpoint = new Point(grid[i][j].getX(), grid[i][j].getY());
			  if(gridpoint == point)
			  {
				grid[i][j] = new JButton("y");
			  }
			  
		   }
		 }
	    
		 if(tower.isSelected())
	     {
	    	 //if(player.getmoney >= tower.getcost
			 //place the tower
			 //else { Text area = not enough money}
	     }
	     if(firetower.isSelected())
	     {
	    	 //if(player.getmoney >= firetower.getcost
			 //place the tower
			 //else { Text area = not enough money}
	     }
	     if(icetower.isSelected())
	     {
	    	 //if(player.getmoney >= icetower.getcost
			 //place the tower
			 //else { Text area = not enough money}
	     }
	     if(snipertower.isSelected())
	     {
	    	 //if(player.getmoney >= snipertower.getcost
			 //place the tower
			 //else { Text area = not enough money}
	     }
	     if(ubertower.isSelected())
	     {
	    	 //if(player.getmoney >= ubertower.getcost
			 //place the tower
			 //else { Text area = not enough money} 
	     }
  }
  public void mouseReleased(MouseEvent e)
  {
	  
  }
  public void mousePressed(MouseEvent e)
  {
	  
  }
 }
 public static void main(String[] args)
 {
	 GuiMain application = new GuiMain();
 }
}


