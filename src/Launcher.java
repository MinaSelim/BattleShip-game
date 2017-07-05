import javax.swing.JFrame;

public class Launcher{

	public static void main(String[] args) 
	{
		GameGUI gui = new GameGUI();
		gui.setSize(620,600);
		gui.setVisible(true);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	

}
