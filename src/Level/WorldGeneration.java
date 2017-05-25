package Level;

import java.util.Random;

public class WorldGeneration
{
	Tile[][] theWorld;
	int xDim;
	int yDim;
	Random rand;
	public WorldGeneration(int x, int y)
	{
		rand = new Random();
		xDim = x;
		yDim = y;
		theWorld = new Tile[x][y];
	}
	
	public void basics()
	{
		for (int i = 0; i < yDim; i++)
		{
			for (int j = 0; j < xDim - 1; j++)
			{
				theWorld[i][j] = new Tile(i, j, 30, false);
			}
		}
		for (int j = 0; j < xDim; j++)
		{
			theWorld[yDim - 1][j] = new Tile(yDim - 1, j, 30, true);
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
		while( done < i)
		{
			check = true;
			hold = rand.nextInt(yDim - 15) + 10;
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
			theWorld[yDim - 1][holdPits[j]] = new Tile(yDim - 1, j, 30, false);
			theWorld[yDim - 1][holdPits[j + 1]] = new Tile(yDim - 1, j + 1, 30, false);
			theWorld[yDim - 1][holdPits[j + 2]] = new Tile(yDim - 1, j + 2, 30, false);
			theWorld[yDim - 1][holdPits[j + 3]] = new Tile(yDim - 1, j + 3, 30, false);
			theWorld[yDim - 1][holdPits[j + 4]] = new Tile(yDim - 1, j + 4, 30, false);
		}
	}
	
	/**
	 * @param x
	 * @param y
	 */
	public void addRamdomBlocks(int amount)
	{
		
	}
}
