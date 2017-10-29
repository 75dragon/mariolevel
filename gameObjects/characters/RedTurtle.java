package characters;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import level.World;

public class RedTurtle extends Enemy {

	public RedTurtle(int xPos, int yPos, World wor, BufferedImage image) {
		super(xPos, yPos, wor, image);
		health = 1;
		jumpVel = 0;
		isStompable = true;
		xMovementVel = 5;
		//width = 50;
		//height = 50;
	}
	
	public void draw(Graphics g) {
		//g.setColor(Color.RED);
		tryShrinking();
		g.fillRect(xPos, yPos, width, height);
		g.drawImage(image, xPos, yPos, width, height, null);
	}
}
