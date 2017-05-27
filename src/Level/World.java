package Level;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import characters.Goomba;
import characters.Player;
import characters.PlayerEnemyCollision;

public class World
{
	Timer time;
	private Displayer displayer;
	public Player player;
	public Goomba goomba;
	PlayerEnemyCollision collision;
	private final int delay = 50;
	Tile[][] level;
	int xDim;
	int yDim;
	int tileDimentions;



	public World(int x, int y, int tileDimentions, Displayer displayer, PlayerEnemyCollision collision)
	{
		this.displayer = displayer;
		this.collision = collision;
		this.player = new Player(20,20);
		goomba = new Goomba(200,350);
		displayer.setWorld(this);
		collision.setWorld(this);
		gameStart();
		time.start();
		xDim = x;
		yDim = y;
		this.tileDimentions = tileDimentions;
		level = new Tile[xDim][yDim];
	}
	
	

	public Tile[][] getLevel()
	{
		return level;
	}

	/**
	 * Starts the timer that plays the game
	 * ALL THIS METHOD SHOULD DO IT CALL A BUNCH OF METHODS IN OTHER CLASSES TO MAKE
	 * THEM "MOVE:", THEN CALL THE DISPLAYER CLASS TO DRAW STUFF.
	 */
	public void gameStart()
	{
		time = new Timer(delay, new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				collision.checkCollide();
				if(player.getY() == 350) {
					player.setJumped(false);
				}
				player.updatePosition();
				displayer.repaint();
			}
		});
	}
	
	public void showGameOver() {
		displayer.showGameOver();
		time.stop();
	}
	
	

}
