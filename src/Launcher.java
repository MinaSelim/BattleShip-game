import javax.swing.JFrame;

public class Launcher{

	public static void main(String[] args) 
	{
		GameGUI gui = new GameGUI();
		gui.setSize(1220,600);
		gui.setVisible(true);
		gui.setResizable(false);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
	}
	

}
