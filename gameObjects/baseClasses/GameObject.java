package baseClasses;

import java.awt.Rectangle;

public abstract class GameObject {
	public GameObjectID objectID;
	protected int width, height, xPos, yPos;
	
	public GameObject(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(xPos, yPos, width, width);
	}
}
