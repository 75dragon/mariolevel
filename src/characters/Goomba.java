package characters;

import java.awt.Color;
import java.awt.Graphics;

public class Goomba extends Enemy {

	private Color myBrown = new Color(156, 104, 26);
	
	public Goomba(int xPos, int yPos) {
		super(xPos, yPos);
		health = 1;
		jumpVel = 0;
		topHurt = false;
		xMovementVel = 3;
		width = 20;
		height = 20;
	}
	
	public void drawGoomba(Graphics g) {
		g.setColor(myBrown);
		g.fillRect(xPos, yPos, width, height);
	}
	
	
}
