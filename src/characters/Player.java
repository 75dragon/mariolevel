package characters;

import java.awt.Color;
import java.awt.Graphics;

import Level.Physics;

public class Player extends Characters
{
	Physics phys;

	public Player(int xPos, int yPos)
	{
		super(xPos, yPos);
		health = 1;
		jumpVel = -20;
		xMovementVel = 5;
		width = 20;
		height = 20;
		
	}
	
//	public void updatePosition() {
//		xPos += xVel;
//		yPos += yVel;
//		
//		//applyGravity();
//	}
	

	public void drawPlayer(Graphics g)
	{
		if(health > 0)
			g.setColor(Color.YELLOW);
		else
			g.setColor(Color.WHITE);
		g.fillRect(xPos, yPos, width, height);
	}

}
