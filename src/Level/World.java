package Level;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import characters.Player;

public class World implements ActionListener
{
	private Timer time;
	private Displayer displayer;
	Player player;
	private Physics physics;
	private final int delay = 50;
	private int yVel = 0;
	
	Tile[][] level;
	int xDim;
	int yDim;
	int tileDimentions;
	
	public World(int x, int y, int tileDimentions, Displayer displayer, Player player, Physics physics)
	{
		this.displayer = displayer;
		displayer.setWorld(this);
		this.player = player;
		this.physics = physics;
		time = new Timer(delay, this);
		time.start();
		
		xDim = x;
		yDim = y;
		this.tileDimentions = tileDimentions;
		level = new Tile[xDim][yDim];
	}
	
	public void createBaseLevel()
	{
		for ( int i = 0; i < xDim; i++ )
		{
			for ( int j = 0; j < yDim; j++ )
			{
				level[i][j] = new Tile(i, j, 30, false);
			}
		}
	}
	
	public Tile[][] getLevel()
	{
		return level;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(player.getY() <= 350) {
			player.setYVel( player.getYVel() + physics.gravity );
			
//			player.setPosition(player.getX(), player.getY() + yVel);
//			yVel += physics.gravity;
		}
		else {
			player.setYVel(0);
		}
		player.updatePosition();
		displayer.repaint();
		
	}
	
	
}
