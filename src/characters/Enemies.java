package characters;

import java.awt.Color;
import java.awt.Graphics;

public class Enemies {
	private int x, y, size; 
	private int rVal,gVal,bVal; 
	private int health;
	
	public Enemies(int xNew,int yNew,int sizeNew, int healthNew){
		this.x = xNew; 
		this.y = yNew;
		this.size = sizeNew; 
		this.health = healthNew; 
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getrVal() {
		return rVal;
	}

	public void setrVal(int rVal) {
		this.rVal = rVal;
	}

	public int getgVal() {
		return gVal;
	}

	public void setgVal(int gVal) {
		this.gVal = gVal;
	}

	public int getbVal() {
		return bVal;
	}

	public void setbVal(int bVal) {
		this.bVal = bVal;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
	//TODO: Get The Color
	//Set the RGB Values
	public void getColor(){
		this.rVal = 255; 
		this.gVal = 0;
		this.bVal = 0; 
	}
	
	//TODO: Draw the Enemies 
	public void drawEnemies(Graphics g){
		g.setColor(new Color(rVal, gVal, bVal));
		g.fillRect(x, y, size, size);
	}

}
