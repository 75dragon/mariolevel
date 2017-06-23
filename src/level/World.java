package level;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

import characters.Character;
import characters.Enemy;
import characters.FlyingRedTurtle;
import characters.Goomba;
import characters.Player;
import characters.RedTurtle;
import tiles.Tile;
import characters.Collision;

public class World
{
	Timer time;
	private Displayer displayer;
	public Player player;
	public Enemy goomba1, redTurtle1, goomba2, flyingTurtle1;
	Collision collision;
	private final int delay = 50;
	Tile[][] level;
	int xDim;
	int yDim;
	int tileDimentions;
	//TODO have two seperate lists, one for the char
	//and another for the player
	private ArrayList<Enemy> cList;
	private ArrayList<Player> pList;


	public World(int x, int y, int tileDimentions, Displayer displayer, Collision collision)
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
		// Maybe put some of these in their own methods
		pList = new ArrayList<>();
		cList = new ArrayList<>();
		this.player = new Player(20,20);
		goomba1 = new Goomba(100,350);
		goomba2 = new Goomba(300,350);
		redTurtle1 = new RedTurtle(200,350);
		flyingTurtle1 = new FlyingRedTurtle(150, 100);
		//goomba2.moveLeft();
		//goomba1.moveRight();
		//redTurtle1.moveLeft();
		pList.add(player);
		cList.add(goomba1);
		cList.add(redTurtle1);
		cList.add(goomba2);
		cList.add(flyingTurtle1);
	}
	
	// Check if Character health is 0
	//TODO whats health in mario???
	public void updateCharactersPoisition() {
		for(int i = 0; i< cList.size(); i++) {
			if(cList.get(i).getHealth() == 0 && cList.get(i).doneShrinking)
				cList.remove(i);
			else
				cList.get(i).updatePosition();
		}
		
		for(int i = 0; i < pList.size(); i++) {
			pList.get(i).updatePosition();
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
				updateCharactersPoisition();
				collision.checkPlayerEnemyCollision();
				collision.checkEnemyEnemyCollision();
				collision.checkMapCollision();
				displayer.repaint();
			}
		});
	}
	
	public void showGameOver() {
		displayer.showGameOver();
		time.stop();
	}
	
	public ArrayList<Enemy> getCList() {
		return cList;
	}
	
	public ArrayList<Player> getPList() {
		return pList;
	}
}
