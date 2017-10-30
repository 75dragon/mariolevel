package characters;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import baseClasses.GameObjectID;
import level.World;

public class Player extends Character
{
	int stompLaunchSpeed = -20;
	int runSpeed = 3;


	public Player(int xPos, int yPos, BufferedImage img)
	{
		super(xPos, yPos, img);
		health = 1;
		jumpVel = -25;
		xMovementVel = 6;
		width = 30;
		height = 30;
		objectID = GameObjectID.PLAYER;
	}
	
	public void applyGravity()
	{
		yVel += 2;
	}
	
	public void run() {
		setXVel(xMovementVel*runSpeed);
	}
	
	public void stomp(Enemy enemy) {
		setYVel(stompLaunchSpeed);
		enemy.setHealth(0);
		updatePosition();
	}
	
	 //for testing player enemy collision
	public void updatePosition() {
		xPos += xVel;
		yPos += yVel;
		if(falling) {
			applyGravity();
			//System.out.println("applying g");
		}
	}
	

	

	public void draw(Graphics g)
	{
		if(health > 0)
			g.setColor(Color.YELLOW);
		else
			g.setColor(Color.WHITE);
		g.fillRect(xPos, yPos, width, height);
		
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Color.RED);
		g2d.draw(getBounds());
		g2d.setColor(Color.BLUE);
		g2d.draw(getBoundsTop());
		g2d.setColor(Color.PINK);
		g2d.draw(getBoundsRight());
		g2d.setColor(Color.GREEN);
		g2d.draw(getBoundsLeft());
	}
	

	
	
	

}