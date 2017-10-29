package characters;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import level.World;

public class Goomba extends Enemy {

	//private Color myBrown = new Color(156, 104, 26);
	
	public Goomba(int xPos, int yPos, World wor, BufferedImage image) {
		super(xPos, yPos, wor, image);
		health = 1;
		jumpVel = 0;
		isStompable = true;
		xMovementVel = 5;
		//width = 50;
		//height = 50;
	}
	
	public void draw(Graphics g) {
		//g.setColor(myBrown);
		tryShrinking();
		g.fillRect(xPos, yPos, width, height);
		g.drawImage(image, xPos, yPos, width, height, null);
		if ( image == null )
		{
			System.out.println("your bad");
		}
	}
}
