package Level;

public class World
{
	Tile[][] level;
	int xDim;
	int yDim;
	int tileDimentions;
	
	public World(int x, int y, int tileDimentions)
	{
		xDim = x;
		yDim = y;
		this.tileDimentions = tileDimentions;
		level = new Tile[xDim][yDim];
	}
	
	public void createBaseLevel()
	{
		for ( int i = 0; i < xDim; i++ )
		{
			for ( int j = 0; j < yDim; j++ )
			{
				level[i][j] = new Tile(i, j, 30, false);
			}
		}
	}
	
	public Tile[][] getLevel()
	{
		return level;
	}
	
	
}
