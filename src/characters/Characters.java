package characters;

public abstract class Characters {
	protected int health, xPos, yPos, size;
	protected int xVel, yVel, jumpVel, xMovementVel;
	protected boolean jumped = true;
	
	public Characters(int x, int y, int size, int health) {
		xPos = x;
		yPos = y;
		this.size = size;
		this.health = health;
		xVel = 0;
		yVel = 0;
	}
	
	public void setJumped(boolean j) {
		jumped = j;
	}

	public void jump() {
		if (!jumped) {
			setYVel(jumpVel);
			jumped = true;
			updatePosition();
		}
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
	
}
