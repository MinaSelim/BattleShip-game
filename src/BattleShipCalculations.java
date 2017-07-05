import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class BattleShipCalculations 
{
	private boolean[][] ship_location = new boolean[7][7];
	private Boolean[][] ship_location_clone = new Boolean[7][7];
	private Random random = new Random();
	private int x, y, guesses;
	
	
	
	public BattleShipCalculations()
	{
		positionShip();
		positionShip();
		positionShip();
		guesses = 0;

		for(int i=0; i<7; i++)
		{
			for(int j=0; j<7; j++)
				ship_location_clone[i][j] = ship_location[i][j];
			System.out.println();
		}
	}
	
	public boolean checkVictory(int x_position, int y_position)
	{
		ship_location_clone[x_position][y_position] = false;
		guesses++;
		List ships = twoDArrayToList(ship_location_clone);
		return !ships.contains(true);
	}
	
	public int getGuesses()
	{
		return guesses;
	}
	
	public boolean thereIsaShip(int a, int b)
	{
		return ship_location[a][b];
	}
	
	
	private void positionShip()
	{
		randomize();
		int z;
		if(canAddShipToTheRight() && canAddShipToTheLeft() && canAddShipToTheTop() && canAddShipToTheBottom())
		{
			z= random.nextInt(4);
			switch(z)
			{
			case 0: addShipToTheRight(); break;
			case 1: addShipToTheLeft(); break;
			case 2: addShipToTheTop(); break;
			default: addShipToTheBottom(); break;
			}
			
		}
		else if(canAddShipToTheRight() && canAddShipToTheLeft() && canAddShipToTheTop())
		{
			z= random.nextInt(3);
			switch(z)
			{
			case 0: addShipToTheRight(); break;
			case 1: addShipToTheLeft(); break;
			default: addShipToTheTop(); break;
			}
		}
		else if(canAddShipToTheRight() && canAddShipToTheLeft() && canAddShipToTheBottom())
		{
			z= random.nextInt(3);
			switch(z)
			{
			case 0: addShipToTheRight(); break;
			case 1: addShipToTheLeft(); break;
			default: addShipToTheBottom(); break;
			}
		}
		else if(canAddShipToTheRight() && canAddShipToTheTop() && canAddShipToTheBottom())
		{
			z= random.nextInt(3);
			switch(z)
			{
			case 0: addShipToTheRight(); break;
			case 1: addShipToTheTop(); break;
			default: addShipToTheBottom(); break;
			}
		}
		else if(canAddShipToTheLeft() && canAddShipToTheTop() && canAddShipToTheBottom())
		{
			z= random.nextInt(3);
			switch(z)
			{
			case 0: addShipToTheLeft(); break;
			case 1: addShipToTheTop(); break;
			default: addShipToTheBottom(); break;
			}
		}
		else if(canAddShipToTheRight() && canAddShipToTheLeft())
		{
			z= random.nextInt(2);
			switch(z)
			{
			case 0: addShipToTheRight(); break;
			default: addShipToTheLeft();
			}
		}
		else if(canAddShipToTheRight() && canAddShipToTheTop())
		{
			z= random.nextInt(2);
			switch(z)
			{
			case 0: addShipToTheRight(); break;
			default: addShipToTheTop();
			}
		}
		else if(canAddShipToTheRight() && canAddShipToTheBottom())
		{
			z= random.nextInt(2);
			switch(z)
			{
			case 0: addShipToTheRight(); break;
			default: addShipToTheBottom();
			}
		}
		else if(canAddShipToTheLeft() && canAddShipToTheTop())
		{
			z= random.nextInt(2);
			switch(z)
			{
			case 0: addShipToTheLeft(); break;
			default: addShipToTheTop();
			}
		}
		else if(canAddShipToTheLeft() && canAddShipToTheBottom())
		{
			z= random.nextInt(2);
			switch(z)
			{
			case 0: addShipToTheLeft(); break;
			default: addShipToTheBottom();
			}
		}
		else if(canAddShipToTheTop() && canAddShipToTheBottom())
		{
			z= random.nextInt(2);
			switch(z)
			{
			case 0: addShipToTheLeft(); break;
			default: addShipToTheBottom();
			}
		}
		else if(canAddShipToTheRight())
			addShipToTheRight();
		else if(canAddShipToTheLeft())
			addShipToTheLeft();
		else if(canAddShipToTheTop())
			addShipToTheTop();
		else if(canAddShipToTheBottom())
			addShipToTheBottom();
		else
			positionShip();
		
		
	}
	
	private void randomize()
	{
		do
		{
			x = random.nextInt(7);
			y = random.nextInt(7);
		} while(ship_location[x][y]);
	}
	private void addShipToTheRight()
	{
		System.out.println("addedShipToTheRight at "+x + "," +y );
		ship_location[x][y] = true;
		ship_location[x][y+1] = true;
		ship_location[x][y+2] = true;
	}
	private void addShipToTheLeft()
	{
		System.out.println("addedShipToTheLeft at "+x + "," +y );
		ship_location[x][y] = true;
		ship_location[x][y-1] = true;
		ship_location[x][y-2] = true;
	}
	private void addShipToTheTop()
	{
		System.out.println("addedShipToTheTop at "+x + "," +y );
		ship_location[x][y] = true;
		ship_location[x-1][y] = true;
		ship_location[x-2][y] = true;
	}
	private void addShipToTheBottom()
	{
		System.out.println("addedShipToTheBottom at "+x + "," +y );
		ship_location[x][y] = true;
		ship_location[x+1][y] = true;
		ship_location[x+2][y] = true;
	}
	private boolean canAddShipToTheRight()
	{
		try
		{
			return !ship_location[x][y] && !ship_location[x][y+1] && !ship_location[x][y+2] ;
		}
		catch(Exception ArrayIndexOutOfBoundsException)
		{
			return false;
		}
	}
	private boolean canAddShipToTheLeft()
	{
		try
		{
			return !ship_location[x][y] && !ship_location[x][y-1] && !ship_location[x][y-2] ;
		}
		catch(Exception ArrayIndexOutOfBoundsException)
		{
			return false;
		}
	}
	private boolean canAddShipToTheTop()
	{	
		try
		{	
			return !ship_location[x][y] && !ship_location[x-1][y] && !ship_location[x-2][y] ;
		}
		catch(Exception ArrayIndexOutOfBoundsException)
		{
			return false;
		}
		
	}
	private boolean canAddShipToTheBottom()
	{
		try
		{	
			return !ship_location[x][y] && !ship_location[x+1][y] && !ship_location[x+2][y] ;
		}
		catch(Exception ArrayIndexOutOfBoundsException)
		{
			return false;
		}
	}
	private <T> List<T> twoDArrayToList(T[][] twoDArray) {
	    List<T> list = new ArrayList<T>();
	    for (T[] array : twoDArray) {
	        list.addAll(Arrays.asList(array));
	    }
	    return list;
	}

}
