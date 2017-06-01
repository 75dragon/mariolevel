package Level;

import java.awt.Color;
import java.awt.Graphics;

public class Tile
{
	int x; // multiplicative factor?
	int y; // multiplicative factor?
	int width;
	boolean passable;
	Color color = Color.BLUE;
	
	public Tile ( int x, int y, int width, boolean passable )
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.passable = passable;
	}
	
	public void drawMe( Graphics g )
	{			
		if ( !passable )
		{		

			g.setColor(color);
			g.fillRect(x * width, y * width, width, width);
		}

	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
}

