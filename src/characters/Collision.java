package characters;

import java.util.ArrayList;

import Level.World;

public class Collision {
	private World world;
	private ArrayList<Enemy> cList;
	private ArrayList<Player> pList;
	private Player player;
	//this is terrible. You should just instead just modify the world's array directly with getters and setters
	//make sure that there are no bugs inside the code when everything is immidatly removed
	public void setWorld(World world) {
		this.world = world;
	}
	
	// Updates both Player and Enemy lists
	public void updateCharactersList() {
		cList = world.getCList();
		pList = world.getPList();
	}
		
	public void checkPlayerEnemyCollision() {
		updateCharactersList();
		player = pList.get(0);
		
		for(int i = 0; i < cList.size(); i++) {
			Enemy currentEnemy = cList.get(i);
			// See the bottom of the Characters class for meaning of X1, X2, Y1 and Y2
			// Check to see if the player collides with the enemy from the top. If the enemy is stompable, kill it
			if( player.getX2() > currentEnemy.getX1() && player.getY2() > currentEnemy.getY1() &&
				player.getY1() < currentEnemy.getY1() && player.getX1() < currentEnemy.getX2() && currentEnemy.getStompable()) {
				player.stomp(currentEnemy); 
			}
			// else if the player collides with the side of the enemy or if the enemy is not stompable and the
			// player attempts to stomp
			else if( player.getX1() < currentEnemy.getX2() && player.getX2() > currentEnemy.getX1() &&
					 player.getY1() < currentEnemy.getY2() && player.getY2() > currentEnemy.getY1()	) {
				System.out.println("death");
				//	world.showGameOver();
			}
		}
	}
	
	// Changes direction of enemy movement if they run into each other from the side
	public void checkEnemyEnemyCollision() {
		updateCharactersList();
		// Start counting at 1 because index 0 of the cList is the player
		for(int i = 0; i < cList.size()-1; i++) {
			Enemy currentEnemy = cList.get(i);
			Enemy nextEnemy = cList.get(i+1);
			if( ( currentEnemy.getX2() >= nextEnemy.getX1() && currentEnemy.getX1() < nextEnemy.getX1()) ||
			    ( currentEnemy.getX1() > nextEnemy.getX1() && currentEnemy.getX1() <= nextEnemy.getX2()) ) {
				currentEnemy.changeDirection();
				nextEnemy.changeDirection();
			}
		}
	}
	
	// TODO Um yeah, iterate through both the player list and the enemy list
	// And check the blocks around them
	// If they are colliding with the player/enemy, move them back
	// 
	public void checkMapCollision() {
		updateCharactersList();
		//Tile currentTile[][] = world.worl
	

	}
}
