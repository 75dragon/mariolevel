package characters;

import java.awt.Color;
import java.awt.Graphics;

public class FlyingRedTurtle extends Enemy{
	private Color charaColor = new  Color(255, 0, 0); 
	public FlyingRedTurtle(int x, int y){
		super(x,y);
		health = 2;
		jumpVel = 0;
		isStompable = true;
		xMovementVel = 0;
		yMovementVel = 5; 
		width = 50;
		height = 50;
	}
	
	//TODO Get back to applying gravity later
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
	
	public void draw(Graphics g){
		g.setColor(charaColor);
		tryShrinking(); 
		g.fillRect(xPos, yPos, width, height);
	}

	
}
