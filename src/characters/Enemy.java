package characters;

public abstract class Enemy extends Characters {
	protected boolean topHurt;
	protected int shrinkRate = 15;
	
	public Enemy(int x, int y) {
		super(x,y);
	}
}
