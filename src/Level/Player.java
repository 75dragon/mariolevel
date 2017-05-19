package Level;
import java.awt.Color;
import java.awt.Graphics;

public class Player {
	private int health;
	int xPos = 20, yPos = 20, width = 20, yVel;
	
	public Player() {
		health = 1;
		yVel = 0;
	}
	
	public void drawPlayer(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(xPos, yPos, width, width);
	}
	
	public void setPosition(int newX, int newY) {
		xPos = newX;
		yPos = newY;
	}
	
	public int getX() {
		return xPos;
	}
	
	public int getY() {
		return yPos;
	}
	
	public int getYVel() {
		return yVel;
	}
	
}
