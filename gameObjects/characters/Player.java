package characters;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import baseClasses.GameObjectID;
import level.World;

public class Player extends Character
{
	int stompLaunchSpeed = -20;
	int runSpeed = xMovementVel + 10;
	boolean falling = false;

	public Player(int xPos, int yPos)
	{
		super(xPos, yPos);
		health = 1;
		jumpVel = -25;
		xMovementVel = 6;
		width = 20;
		height = 20;
		objectID = GameObjectID.PLAYER;
	}
	
	public void applyGravity()
	{
		yVel += 2;
		
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
	public void updatePosition() {
		xPos += xVel;
		yPos += yVel;
		if(falling) {
			applyGravity();
			//System.out.println("applying g");
		}
	}
	
	public boolean isFalling() {
		return falling;
	}
	
	public void setFalling(boolean falling) {
		this.falling = falling;
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
	
	public Rectangle getBounds() {
		return new Rectangle(xPos+(width/3), yPos+height/2, width/3, height/2);
	}
	public Rectangle getBoundsTop() {
		return new Rectangle(xPos+(width/3), yPos-2, width/3, height/2);
	}
	public Rectangle getBoundsRight() {
		return new Rectangle(xPos+width-width/5, yPos+3, width/5, height-6);
	}
	public Rectangle getBoundsLeft() {
		return new Rectangle(xPos, yPos+3, width/5, height-6);
	}
	
	
	

}