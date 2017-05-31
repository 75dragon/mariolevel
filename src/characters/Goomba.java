package characters;

import java.awt.Color;
import java.awt.Graphics;

public class Goomba extends Enemy {

	private Color myBrown = new Color(156, 104, 26);
	
	public Goomba(int xPos, int yPos) {
		super(xPos, yPos);
		health = 1;
		jumpVel = 0;
		isStompable = true;
		xMovementVel = 5;
		width = 20;
		height = 20;
	}
	
	public void draw(Graphics g) {
		g.setColor(myBrown);
		if(health == 0 && height > 0) {
			xVel = 0;
			height -= shrinkRate;
			yPos += shrinkRate;
		}
		g.fillRect(xPos, yPos, width, height);
	}
	
	
	
	
	
}
