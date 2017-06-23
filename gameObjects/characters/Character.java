package characters;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import baseClasses.GameObject;
import baseClasses.GameObjectID;
import level.World;

public abstract class Character extends GameObject {
	protected int health;
	protected int xVel, yVel, jumpVel, xMovementVel;
<<<<<<< HEAD:gameObjects/characters/Character.java
	protected boolean jumping = true;
	public int yMovementVel = 5;
	public boolean doneShrinking = false;
	public World world;
								
	public Character(int xPos, int yPos) {
		super(xPos,yPos);
=======
	protected int floor = 350;
	protected boolean jumped = true;
	public int yMovementVel = 5;
	public boolean doneShrinking = false;
	public World w;
	BufferedImage image;
								
	public Characters(int x, int y, BufferedImage img) {
		xPos = x;
		yPos = y;
		width = 40;
		height = 40;
>>>>>>> 38be04eb6535109855a255af2034a2dc54ef56e4:src/characters/Characters.java
		xVel = 0;
		yVel = 0;
		image = img;
		// any class that inherits from Characters must set
		// health, jumpVel, xMovementVel and size variables
	}
	
	public void setWorld(World world) {
		this.world = world;
	}
	
	
	public void setJump(boolean j) {
		jumping = j;
	}
	
	public boolean isJumping() {
		return jumping;
	}

//	public void jump() {
//		if (!jumped) {
//			setYVel(jumpVel);
//			jumped = true;
//			updatePosition();
//		}
//	}
	
	public void moveUp() {
		setYVel(-1*yMovementVel);
	}
	
	public void moveDown() {
		setYVel(yMovementVel);
	}
	
	public void moveRight() {
		setXVel(xMovementVel);
	}
	
	public void moveLeft() {
		setXVel(-1*xMovementVel);
	}
	
	public void showPosition() {
		System.out.println( "xPos: " + xPos + "\nyPos: " + yPos + "\n" );
	}
	
	public void setPosition(int newX, int newY) {
		xPos = newX;
		yPos = newY;
	}
	
	public void updatePosition() {
		xPos += xVel;
		yPos += yVel;
		if ( yPos > 350 ) //350 is the ground
		{
			yPos = 350;
			yVel = 0;
		}
//		else if( yPos < 220)
//		{ 
//				yPos = 220;
//				yVel = 0;
//				
//		}
		applyGravity();
		
		if(xPos < 0) 
			xPos = 0;
		else if(xPos > 3000)
			xPos = 3000;
	}
	
	public void applyGravity()
	{
		if (yPos < 350)
		{
			yVel += 2;
		}
	}
	
	public void setXVel(int xVel) {
		this.xVel = xVel;
	}
	
	public void setYVel(int yVel) {
		this.yVel = yVel;
	}
	
	public int getXVel() {
		return xVel;
	}
	
	public int getYVel() {
		return yVel;
	}
	
	public int getX() {
		return xPos;
	}
	
	public int getY() {
		return yPos;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getHealth() {
		return health;
	}
	
	public void setHealth(int health) {
		this.health = health;
	}
	
	public int getX1() {
		return getX();
	}
	
	public int getX2() {
		return getX() + width;
	}
	
	public int getY1() {
		return getY();
	}
	
	public int getY2() {
		return getY() + height;
	}
	
	public void setXPos(int xPos) {
		this.xPos = xPos;
	}
	
	public void setYPos(int yPos) {
		this.yPos = yPos;
	}
	
	
	
	
	
	
	// Does nothing, to be overwritten by derived classes
	public abstract void draw(Graphics g);
	
	/*		(x1, y1)		(x2, y1)
	 * 		-----------------
	 * 		|				|
	 *		|				| 		
	 *		|				|
	 * 		|				|	
	 * 		-----------------
	 * 		(x1, y2)		(x2, y2)
	 */
	
	
}
