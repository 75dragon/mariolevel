package tiles;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import baseClasses.GameObject;
import baseClasses.GameObjectID;

public class Tile extends GameObject
{
	public boolean passable;
	Color color = Color.BLUE;

	public Tile(int xPos, int yPos, int width, boolean passable)
	{
		super(xPos, yPos);
		this.width = width;
		this.passable = passable;
		objectID = GameObjectID.TILE;
	}

	public void drawMe(Graphics g)
	{
		if (!passable)
		{
			g.setColor(color);
			g.fillRect(xPos * width, yPos * width, width, width);

			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(Color.RED);
			g2d.draw(getBounds());

		}
		g.setColor(Color.BLACK);
		g.drawString(xPos + " " + yPos, width * xPos, width * yPos);
	}

	public Rectangle getBounds()
	{
		return new Rectangle(xPos * width, yPos * width, width, width);
	}

	public boolean isPassable()
	{
		return passable;
	}

	public int getX()
	{
		return xPos;
	}

	public int getY()
	{
		return yPos;
	}

	public int getX1()
	{
		return getX() * width;
	}

	public int getX2()
	{
		return getX1() + width;
	}

	public int getY1()
	{
		return getY() * width;
	}

	public int getY2()
	{
		return getY1() + width;
	}

}
