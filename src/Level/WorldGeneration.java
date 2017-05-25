package Level;

public class WorldGeneration
{
	Tile[][] theWorld;
	int xDim;
	int yDim;
	public WorldGeneration(int x, int y)
	{
		xDim = x;
		yDim = y;
		theWorld = new Tile[x][y];
	}
	
	public void basics()
	{
		for (int i = 0; i < xDim; i++)
		{
			for (int j = 0; j < yDim - 1; j++)
			{
				theWorld[i][j] = new Tile(i, j, 30, false);
			}
		}
		for (int j = 0; j < xDim; j++)
		{
			theWorld[j][j] = new Tile(i, j, 30, false);
		}
	}
	
	public void addPits()
	{
		
	}
	
	public void addRamdomBlocks()
	{
		
	}
}
