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
	}
	
	
}
