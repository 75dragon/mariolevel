package level;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
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
	public Enemy goomba3, goomba4, goomba5, redTurtle2, redTurtle3;
	Collision collision;
	private final int delay = 50;
	Tile[][] level;
	int xDim;
	int yDim;
	int tileDimentions;
	int floor = 50;
	
	// Images
	BufferedImage marioImage, goombaImage, redTurtleImage;
	
	
	//TODO have two seperate lists, one for the char
	//and another for the player
	private ArrayList<Enemy> cList;
	private ArrayList<Player> pList;
	public ArrayList<Character> charaList;


	public World(int x, int y, int tileDimentions, Displayer displayer, Collision collision)
	{
		this.displayer = displayer;
		this.collision = collision;
		loadImages();
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
	
	
    public void loadImages()
    {
        try
        {
        	marioImage = ImageIO.read( new File("src/dropoutbear.jpg") ); //getClass().getResource("/dropoutbear.jpg") );
            goombaImage = ImageIO.read( new File("src/taylor.jpg") );
            redTurtleImage = ImageIO.read( new File("src/lilyachty.jpg") ); 
        } 
        catch ( IOException e )
        {
            e.printStackTrace();
        }
        
    }
	
	// initializes arrayList, instantiates characters and places characters in arrayList
	public void initializeCharacters() {
		// Maybe put some of these in their own methods
		pList = new ArrayList<>();
		cList = new ArrayList<>();
		charaList = new ArrayList<>();
		flyingTurtle1 = new FlyingRedTurtle(150, 100);
		//goomba2.moveLeft();
		//goomba1.moveRight();
		//redTurtle1.moveLeft();

		player = new Player(20,20, marioImage);
		goomba1 = new Goomba(200,floor, goombaImage);
		goomba2 = new Goomba(400,floor, goombaImage);
		redTurtle1 = new RedTurtle(500,floor, redTurtleImage);
		
		goomba3 = new Goomba(1000,floor, goombaImage);
		goomba4 = new Goomba(900,floor, goombaImage);
		goomba5 = new Goomba(450,floor, goombaImage);
		redTurtle2 = new RedTurtle(600,floor, redTurtleImage);
		redTurtle3 = new RedTurtle(500,floor, redTurtleImage);
		
		
		
		
		goomba2.moveLeft();
		goomba1.moveRight();
		redTurtle1.moveLeft();
		goomba3.moveRight();
		goomba4.moveLeft();
		goomba5.moveRight();
		redTurtle2.moveLeft();
		redTurtle3.moveRight();
		
		pList.add(player);
		cList.add(goomba1);
		cList.add(redTurtle1);
		cList.add(goomba2);
		cList.add(flyingTurtle1);
		cList.add(goomba3);
		cList.add(goomba4);
		cList.add(goomba5);
		cList.add(redTurtle2);
		cList.add(redTurtle3);
		copyIntoCharaList();
	}
	
	public void copyIntoCharaList() {
		charaList.add(player);
		charaList.add(goomba1);
		charaList.add(redTurtle1);
		charaList.add(goomba2);
		charaList.add(flyingTurtle1);
		charaList.add(goomba3);
		charaList.add(goomba4);
		charaList.add(goomba5);
		charaList.add(redTurtle2);
		charaList.add(redTurtle3);
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

			//	player.checkJump();
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
