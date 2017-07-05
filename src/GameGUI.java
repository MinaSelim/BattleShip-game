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
	private JButton[][] button;
	private Border emptyBorder = BorderFactory.createEmptyBorder();
	private Icon explosion = new ImageIcon(getClass().getResource("ressources/Explosion-Icon.png"));
	private Icon black_background = new ImageIcon(getClass().getResource("ressources/Black_Background-Icon.png"));
	private Icon grey_background = new ImageIcon(getClass().getResource("ressources/Grey-Background-Icon.png"));
	private BattleShipCalculations game;
	
	
	public GameGUI()
	{
		super("BattleShip");
		super.getContentPane().setBackground(Color.BLUE);
		game = new BattleShipCalculations();
		setLayout(new FlowLayout());
		button = new JButton[7][7];
		for(int i = 0; i<button.length ; i++)
			for(int j = 0; j<button.length ; j++)
			{
				button[i][j] = new JButton(" ");
				button[i][j].setBorder(emptyBorder);
				button[i][j].setIcon(black_background);
				button[i][j].addActionListener(new TheListener(i,j));
				add(button[i][j]);
			}
	}
	
	private class TheListener implements ActionListener
	{
		private int x,y;
		private Icon reveal;
		
		public TheListener(int a, int b)
		{
			x = a;
			y = b;
			if(game.thereIsaShip(x, y))
				reveal = explosion;
			else
				reveal = grey_background;
			
		}
		
		public void actionPerformed(ActionEvent arg0) 
		{
			button[x][y].setIcon(reveal);
			if(game.checkVictory(x, y))
			{
				JOptionPane.showMessageDialog(null, "You Win! it took you " +game.getGuesses() + " tries");
				setVisible(false);
				dispose();
			}
			
			
		}
		
	}
	}
