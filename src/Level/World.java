package Level;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import characters.Player;

public class World
{
	private Timer time;
	private Displayer displayer;
	Player player;
	private final int delay = 50;
	private final int groundLevel = 350;
	private int yVel = 0;

	Tile[][] level;
	int xDim;
	int yDim;
	int tileDimentions;

	public World(int x, int y, int tileDimentions, Displayer displayer, Physics physics)
	{
		this.displayer = displayer;
		displayer.setWorld(this);
		this.player = new Player(20,20,20,1, physics);
		gameStart();
		time.start();

		xDim = x;
		yDim = y;
		this.tileDimentions = tileDimentions;
		level = new Tile[xDim][yDim];
	}

	public void createBaseLevel()
	{
		for (int i = 0; i < xDim; i++)
		{
			for (int j = 0; j < yDim; j++)
			{
				level[i][j] = new Tile(i, j, 30, false);
			}
		}
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

		time = new Timer(50, new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{

				player.updatePosition();
				displayer.repaint();
			}
		});
	}

}
