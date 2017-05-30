package characters;

public abstract class Enemy extends Characters {
	protected boolean topHurt;
	protected int shrinkRate = 15;
	
	public Enemy(int x, int y) {
		super(x,y);
	}
	
	public boolean getTopHurt() {
		return topHurt;
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
		if(xPos <= 0 || xPos >= 780)
			changeDirection();
	}
	
	public void changeDirection() {
			xVel *= -1;
	}
	

	
}
