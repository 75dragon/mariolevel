package characters;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class FlyingRedTurtle extends Enemy{
	
	private Color charaColor = new  Color(255, 0, 0); 
	
	
	public FlyingRedTurtle(int x, int y){
		super(x,y);
	}
	
	public FlyingRedTurtle(int x, int y, BufferedImage img){
		super(x,y, img);
		health = 2;
		jumpVel = 0;
		isStompable = true;
		xMovementVel = 1;
		yMovementVel = 1; 
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
	
	@Override
	public void applyGravity(){
		if (yPos < 50)
		{
			yVel += 2;
		}
		if (yPos > 150){
			yVel -= 2;
		}
	}
	
	
	
	
	public void draw(Graphics g){
		//g.setColor(charaColor);
		tryShrinking(); 
		g.fillRect(xPos, yPos, width, height);
		g.drawImage(image, getX(), getY(), null);
	}

	
}
