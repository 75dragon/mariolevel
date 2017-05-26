package Level;

import java.util.Random;

public class WorldGeneration
{
	Tile[][] theWorld;
	int xDim;
	int yDim;
	Random rand;
	/**
	 * the params are the x/y dimention.
	 * we will store our array like Tile[x][y]. So make sure you
	 * are accessing it like that!
	 * @param x - minimum of a hundred please
	 * @param y - minimum of ten please
	 */
	public WorldGeneration(int x, int y)
	{
		rand = new Random();
		xDim = x;
		yDim = y;
		theWorld = new Tile[x][y];
		basics();
		addPits(5, 3);
		addRamdomBlocks(x + y);
	}
	
	/**
	 * just build a very simple level, its all open, passable tiles until 
	 * you reach the floor - on layer of tiles that represents the ground
	 */
	public void basics()
	{
		for (int yy = 0; yy < yDim; yy++)
		{
			for (int xx = 0; xx < xDim - 1; xx++)
			{
				theWorld[xx][yy] = new Tile(xx, yy, 30, false);
			}
		}
		for (int xx = 0; xx < xDim; xx++)
		{
			theWorld[xx][yDim - 1] = new Tile(xx, yDim - 1, 30, true);
		}
	}
	
	/**
	 * note: the first and last 15 tiles must not be pits:
	 * 	its the end / beginning of the level!
	 * @param x how many pits there should be
	 * @param width how wide the pits are to jump over
	 */
	public void addPits( int i , int width )
	{
	
		int[] holdPits = new int[i];
		boolean check;
		int hold;
		int done = 0;
		while( done < i )
		{
			check = true;
			hold = rand.nextInt(xDim - 15) + 10;
			for (int j = 0; j < done; j++)
			{
				if (Math.abs(hold - holdPits[j]) > width)
				{
					check = false;
				}
			}
			if (check)
			{
				holdPits[done] = hold;
				done++;
			}
		}
		
		for(int j = 0; j < i; j++ )
		{
			for (int xx = holdPits[j]; xx - holdPits[j] < width; xx++ )
			{
				theWorld[holdPits[xx]][yDim - 1] = new Tile(xx, yDim - 1, 30, false);
			}
		}
	}
	
	/**
	 * just create some completely random block in the place
	 * why not?
	 * @param amount of blocks to place
	 */
	public void addRamdomBlocks(int amount)
	{
		int holdx;
		int holdy;
		for( int i = 0; i < amount; i++ )
		{
			holdx = rand.nextInt(xDim - 15) + 10;
			holdy = rand.nextInt(yDim);
			theWorld[holdx][holdy] = new Tile( holdx, holdy, 30, true );
		}
	}
}
