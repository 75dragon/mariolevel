package characters;

public abstract class Characters {
	protected int health, xPos, yPos, size;
	protected int xVel, yVel, jumpVel;
	
	public Characters(int x, int y, int size, int health) {
		xPos = x;
		yPos = y;
		this.size = size;
		this.health = health;
		xVel = 0;
		yVel = 0;
	}
	
	public void jump() {
		if(yVel == 0) {
			setYVel(jumpVel);
		}
		updatePosition();
	}
	
	public void moveRight() {
		setXVel(5);
	}
	
	public void moveLeft() {
		setXVel(-5);
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
