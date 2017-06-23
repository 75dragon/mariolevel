package characters;

<<<<<<< HEAD:gameObjects/characters/Enemy.java
import baseClasses.GameObjectID;

public abstract class Enemy extends Character {
=======
import java.awt.image.BufferedImage;

public abstract class Enemy extends Characters {
>>>>>>> 38be04eb6535109855a255af2034a2dc54ef56e4:src/characters/Enemy.java
	protected boolean isStompable;
	protected int shrinkRate = 15;

	
<<<<<<< HEAD:gameObjects/characters/Enemy.java
	public Enemy(int x, int y) {
		super(x,y);
		objectID = GameObjectID.ENEMY;
=======
	public Enemy(int x, int y, BufferedImage image) {
		super(x, y, image);
>>>>>>> 38be04eb6535109855a255af2034a2dc54ef56e4:src/characters/Enemy.java
	}
	
	public boolean isStompable() {
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