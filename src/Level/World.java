package Level;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

import characters.Characters;
import characters.Enemy;
import characters.Goomba;
import characters.Player;
import characters.RedTurtle;
import characters.CharacterCollision;

public class World
{
	Timer time;
	private Displayer displayer;
	public Player player;
	public Enemy goomba1, redTurtle1;
	CharacterCollision collision;
	private final int delay = 50;
	Tile[][] level;
	int xDim;
	int yDim;
	int tileDimentions;
	private ArrayList<Characters> cList;


	public World(int x, int y, int tileDimentions, Displayer displayer, CharacterCollision collision)
	{
		this.displayer = displayer;
		this.collision = collision;
		initializeCharacters();
		displayer.setWorld(this);
		collision.setWorld(this);
		gameStart();
		time.start();
		xDim = x;
		yDim = y;
		this.tileDimentions = tileDimentions;
		WorldGeneration WG = new WorldGeneration(x, y);
		level = WG.getWorld();
	}
	
	// initializes arrayList, instantiates characters and places characters in arrayList
	public void initializeCharacters() {
		cList = new ArrayList<>();
		this.player = new Player(20,20);
		goomba1 = new Goomba(100,350);
		redTurtle1 = new RedTurtle(200,350);
		goomba1.moveRight();
		redTurtle1.moveLeft();
		cList.add(player);
		cList.add(goomba1);
		cList.add(redTurtle1);
	}
	
	public void updateCharactersPoisition() {
		for(int i = 0; i< cList.size(); i++) {
			if(cList.get(i).getHealth() == 0)
				cList.remove(i);
			else
				cList.get(i).updatePosition();
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
		time = new Timer(delay, new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				collision.checkPlayerEnemyCollision();
				collision.checkEnemyEnemyCollision();
				if(player.getY() == 350) {
					player.setJumped(false);
				}
				updateCharactersPoisition();
				displayer.repaint();
			}
		});
	}
	
	public void showGameOver() {
		displayer.showGameOver();
		time.stop();
	}
	
	public ArrayList<Characters> getCList() {
		return cList;
	}
	
	

}
