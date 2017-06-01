package characters;

public abstract class Enemy extends Characters {
	protected boolean isStompable;
	protected int shrinkRate = 15;
	
	public Enemy(int x, int y) {
		super(x,y);
	}
	
	public boolean getStompable() {
		return isStompable;
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
	
	public void tryShrinking() {
		if(health == 0 && !doneShrinking) {
			xVel = 0;
			height -= shrinkRate;
			yPos += shrinkRate;
			if(height <= 0)
				doneShrinking = true;
		}
	}
}