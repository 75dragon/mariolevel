package characters;
import java.awt.Color;
import java.awt.Graphics;

public class Player extends Characters {
	
	public Player(int xPos, int yPos, int size, int health) {
		super(xPos, yPos, size, health);
		health = 1;
		jumpVel = -20;
	}
	
	public void drawPlayer(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(xPos, yPos, size, size);
	}
}
