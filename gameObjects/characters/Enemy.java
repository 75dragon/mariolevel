package characters;

import baseClasses.GameObjectID;
import java.awt.image.BufferedImage;

public abstract class Enemy extends Character {
	protected boolean isStompable;
	protected int shrinkRate = 15;

	
	public Enemy(int x, int y) {
		super(x,y);
		objectID = GameObjectID.ENEMY;
	}
	
	public Enemy(int x, int y, BufferedImage image) {
		super(x, y, image);
		}
	
	public boolean isStompable() {
		return isStompable;
	}
	
	public void updatePosition() {
		xPos += xVel;
		yPos += yVel;
		applyGravity();
		if(xPos <= 0 || xPos >= 1000)
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