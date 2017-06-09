package characters;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends Characters
{
	int stompLaunchSpeed = -20;
	int runSpeed = xMovementVel + 10;

	public Player(int xPos, int yPos)
	{
		super(xPos, yPos);
		health = 1;
		jumpVel = -25;
		xMovementVel = 6;
		width = 20;
		height = 20;
	}
	
	public void runRight() {
		setXVel(runSpeed);
	}
	
	public void runLeft() {
		setXVel(-1*runSpeed);
	}
	
	public void stomp(Enemy enemy) {
		setYVel(stompLaunchSpeed);
		enemy.setHealth(0);
		updatePosition();
	}
	
	 //for testing player enemy collision
//	public void updatePosition() {
//		xPos += xVel;
//		yPos += yVel;
//		
//		//applyGravity();
//	}
	

	public void draw(Graphics g)
	{
		if(health > 0)
			g.setColor(Color.YELLOW);
		else
			g.setColor(Color.WHITE);
		g.fillRect(xPos, yPos, width, height);
	}
}