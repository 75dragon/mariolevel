package characters;

import java.awt.Graphics;

public abstract class Characters {
	protected int health, xPos, yPos, width, height;
	protected int xVel, yVel, jumpVel, xMovementVel;
	protected boolean jumped = true;
	public int yMovementVel = 5;
								
	
	public Characters(int x, int y) {
		xPos = x;
		yPos = y;
		xVel = 0;
		yVel = 0;
		// any class that inherits from Characters must set
		// health, jumpVel, xMovementVel and size variables
	}
	
	public void setJumped(boolean j) {
		jumped = j;
	}
	
	public boolean getJumped() {
		return jumped;
	}

	public void jump() {
		if (!jumped) {
			setYVel(jumpVel);
			jumped = true;
			updatePosition();
		}
	}
	
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
		if ( yPos > 350 )
		{
			yPos = 350;
			yVel = 0;
		}
		applyGravity();
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
	
	//Does thing, to be overwritten
	public void draw(Graphics g) {
		
	}
	
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
