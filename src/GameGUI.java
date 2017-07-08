import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

public class GameGUI extends JFrame
{
	private JButton[][] playerButton, cpuButton;
	private Border emptyBorder = BorderFactory.createEmptyBorder();
	private Icon explosion = new ImageIcon(getClass().getResource("ressources/Explosion-Icon.png"));
	private Icon black_background = new ImageIcon(getClass().getResource("ressources/Black_Background-Icon.png"));
	private Icon grey_background = new ImageIcon(getClass().getResource("ressources/Grey-Background-Icon.png"));
	private Icon white_background = new ImageIcon(getClass().getResource("ressources/White_Background-Icon.png"));
	private BattleShipCalculations enemyShips, playerShips;
	private ArtificialIntelligence AI;
	
	
	
	public GameGUI()
	{
		super("BattleShip");
		super.getContentPane().setBackground(Color.BLUE);
		enemyShips = new BattleShipCalculations();
		playerShips = new BattleShipCalculations();
		AI = new ArtificialIntelligence(playerShips);
		setLayout(new FlowLayout());
		playerButton = new JButton[7][7];
		cpuButton = new JButton[7][7];
		
		for(int i = 0; i<playerButton.length ; i++)
		{
			for(int j = 0; j<playerButton.length ; j++)
			{
				playerButton[i][j] = new JButton(" ");
				playerButton[i][j].setBorder(emptyBorder);
				playerButton[i][j].setIcon(black_background);
				playerButton[i][j].addActionListener(new TheListener(i,j));
				add(playerButton[i][j]);
			}
			for(int j = 0; j<cpuButton.length ; j++)
			{
				cpuButton[i][j] = new JButton(" ");
				cpuButton[i][j].setBorder(emptyBorder);
				cpuButton[i][j].setIcon(white_background);
				add(cpuButton[i][j]);
			}
		}
	}
	
	private class TheListener implements ActionListener
	{
		private int x,y;
		private Icon reveal;
		private boolean pressed = false;
		
		public TheListener(int a, int b)
		{
			x = a;
			y = b;
			if(enemyShips.thereIsaShip(x, y))
				reveal = explosion;
			else
				reveal = grey_background;
			
		}
		
		public void actionPerformed(ActionEvent arg0) 
		{
			if(!pressed)
			{
				pressed = true;
				JButton a = (JButton) arg0.getSource();
				a.setIcon(reveal);
				if(enemyShips.checkVictory(x, y))
				{
					JOptionPane.showMessageDialog(null, "You Win!");
					setVisible(false);
					dispose();
					System.exit(0);
				}
				AI.choice();
				if(playerShips.thereIsaShip(AI.getX(), AI.getY()))
				{
					cpuButton[AI.getX()][AI.getY()].setIcon(explosion);
					if(playerShips.checkVictory(AI.getX(),AI.getY()))
					{
						JOptionPane.showMessageDialog(null, "You lose!");
						setVisible(false);
						dispose();
					}
					
				}
				else
					cpuButton[AI.getX()][AI.getY()].setIcon(grey_background);
				
			}
				
			
		}
		
	}
	}
