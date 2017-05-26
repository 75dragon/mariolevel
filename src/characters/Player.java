package characters;

import java.awt.Color;
import java.awt.Graphics;

import Level.Physics;

public class Player extends Characters
{

	Physics phys;

	public Player(int xPos, int yPos, int size, int health, Physics phy)
	{
		super(xPos, yPos, size, health);
		health = 1;
		jumpVel = -20;
		phys = phy;
		xMovementVel = 5;
	}

	public void drawPlayer(Graphics g)
	{
		g.setColor(Color.YELLOW);
		g.fillRect(xPos, yPos, size, size);
	}

}
