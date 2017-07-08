import java.util.Random;

public class ArtificialIntelligence 


{
	private BattleShipCalculations playerShips;
	private boolean[][] valueUsed;
	private int x,y , hit1_x, hit1_y , hit2_x , hit2_y; 
	private int hits_remaining = 0;
	private boolean  hit_horizontal, left_failed, right_failed, top_failed, bottom_failed;
	
	
	public ArtificialIntelligence(BattleShipCalculations player)
	{
		playerShips = player;
		valueUsed = new boolean[7][7];
	}
	
	public int getX() {return x;}
	public int getY() {return y;}
	
	public void choice()
	{
		switch(hits_remaining)
		{
		case 0:
			randomPick();
			break;
		case 2:
			if(!left_failed && hit1_y>0 && !valueUsed[hit1_x][hit1_y - 1])
			{
				
				y = hit1_y - 1;
				x = hit1_x;
				valueUsed[x][y] = true;
				System.out.println("C2: tried to the left at" + x + "," +y  );
				if(playerShips.thereIsaShip(x, y))
				{
					hit2_y = y;
					hit2_x = x;
					hit_horizontal = true;
					left_failed = false;
					hits_remaining--;
				}
				else
					left_failed = true;
			}
			else if(!right_failed && hit1_y < 6 && !valueUsed[hit1_x][hit1_y + 1])
			{
				y = hit1_y +1;
				x = hit1_x;
				valueUsed[x][y] = true;
				System.out.println("C2: tried to the right at" + x + "," +y  );
				if(playerShips.thereIsaShip(x, y))
				{
					hit2_y = y;
					hit2_x = x;
					hit_horizontal = true;
					right_failed = false;
					hits_remaining--;
				}
				else
					right_failed = true;
			}
			else if(!top_failed && hit1_x > 0 && !valueUsed[hit1_x -1][hit1_y])
			{
				y = hit1_y;
				x = hit1_x - 1;
				valueUsed[x][y] = true;
				System.out.println("C2: tried to the top at" + x + "," +y  );
				if(playerShips.thereIsaShip(x, y))
				{
					hit2_y = y;
					hit2_x = x;
					hit_horizontal = false;
					top_failed = false;
					hits_remaining--;
				}
				else
					top_failed = true;
			}
			else if(!bottom_failed && hit1_x < 6 && !valueUsed[hit1_x + 1] [hit1_y])
			{
				y = hit1_y;
				x = hit1_x + 1;
				valueUsed[x][y] = true;
				System.out.println("C2: tried to the bottom at" + x + "," +y  );
				if(playerShips.thereIsaShip(x, y))
				{
					hit2_y = y;
					hit2_x = x;
					hit_horizontal = false;
					bottom_failed = false;
					hits_remaining--;
				}
				else
					bottom_failed = true;
			}
			else
			{
				randomPick();
				System.out.println("ERROR: case 2 random pick");
			}
			break;
			
			
			
		case 1:
			if(hit_horizontal)
			{
				if(hit2_y > 0 && !valueUsed[hit2_x][hit2_y - 1])
				{
					y = hit2_y - 1;
					x = hit2_x;
					valueUsed[x][y] = true;
					System.out.println("C1: tried to the left at" + x + "," +y);
					if(playerShips.thereIsaShip(x, y))
						hits_remaining--;
				}
				else if(hit1_y > 0 && !valueUsed[hit2_x][hit1_y - 1])
				{
					y = hit1_y - 1;
					x = hit2_x;
					valueUsed[x][y] = true;
					System.out.println("C1: tried to the left at" + x + "," +y);
					if(playerShips.thereIsaShip(x, y))
						hits_remaining--;
				}
				else if( hit2_y<6 && !valueUsed[hit2_x][hit2_y + 1])
				{
					y = hit2_y + 1;
					x = hit2_x;
					valueUsed[x][y] = true;
					System.out.println("C1: tried to the right at" + x + "," +y);
					if(playerShips.thereIsaShip(x, y))
						hits_remaining--;
					
				}
				else if( hit1_y<6 && !valueUsed[hit2_x][hit1_y + 1])
				{
					y = hit1_y + 1;
					x = hit2_x;
					valueUsed[x][y] = true;
					System.out.println("C1: tried to the right at" + x + "," +y);
					if(playerShips.thereIsaShip(x, y))
						hits_remaining--;
				}
				else
				{
					System.out.println("Error: Case 1 random");
					randomPick();
				}
			}
			else
			{
				if( hit2_x > 0 && !valueUsed[hit2_x - 1][hit2_y])
				{
					y = hit2_y;
					x = hit2_x - 1;
					valueUsed[x][y] = true;
					System.out.println("C1: tried to the top at" + x + "," +y);
					if(playerShips.thereIsaShip(x, y))
						hits_remaining--;

				}
				else if( hit1_x > 0 && !valueUsed[hit1_x - 1][hit2_y])
				{
					y = hit2_y;
					x = hit1_x - 1;
					valueUsed[x][y] = true;
					System.out.println("C1: tried to the top at" + x + "," +y);
					if(playerShips.thereIsaShip(x, y))
						hits_remaining--;
				}
				else if(hit2_x < 6 && !valueUsed[hit2_x +1][hit2_y])
				{
					y = hit2_y;
					x = hit2_x + 1;
					valueUsed[x][y] = true;
					System.out.println("C1: tried to the bottom at" + x + "," +y);
					if(playerShips.thereIsaShip(x, y))
						hits_remaining--;
				}
				else if(hit1_x < 6 && !valueUsed[hit1_x +1][hit2_y])
				{
					y = hit2_y;
					x = hit1_x + 1;
					valueUsed[x][y] = true;
					System.out.println("C1: tried to the bottom at" + x + "," +y);
					if(playerShips.thereIsaShip(x, y))
						hits_remaining--;
				}
				else
				{
					System.out.println("Error: Case 1 random");
					randomPick();
				}
			}
			
		
	
		}
	}
	
	
	private void  randomPick()
	{
		randomize();
		top_failed = false;
		left_failed = false;
		right_failed = false;
		bottom_failed = false;
		hit_horizontal = false;
		hits_remaining = 0;
		if(!valueUsed[x][y])
		{
			if(playerShips.thereIsaShip(x, y))
			{
				valueUsed[x][y] = true;
				hits_remaining = 2;
				hit1_x = x;
				hit1_y = y;
			}
			else
				valueUsed[x][y] = true;
			
		}
		else
			randomPick();
	}
	
	
	
	
	private void randomize()
	{
		Random random = new Random();
		x = random.nextInt(7);
		y = random.nextInt(7);
	}

}
