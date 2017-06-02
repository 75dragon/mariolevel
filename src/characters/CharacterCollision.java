package characters;

import java.util.ArrayList;

import Level.World;

public class CharacterCollision {
	private World world;
	private ArrayList<Characters> cList;
	private Player player;
	//this is terrible. You should just instead just modify the world's array directly with getters and setters
	//make sure that there are no bugs inside the code when everything is immidatly removed
	public void setWorld(World world) {
		this.world = world;
	}
	
	public void updateCharactersList() {
		cList = world.getCList();
	}
		
	public void checkPlayerEnemyCollision() {
		updateCharactersList();
		player = (Player) cList.get(0);	// Cast as Player because cList returns a Characters object
		
		for(int i = 1; i < cList.size(); i++) {
			Enemy currentEnemy = (Enemy) cList.get(i); // Cast as Enemy because cList returns a Characters object
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
				//System.out.println("death");
				//	world.showGameOver();
			}
		}
	}
	
	// Changes direction of enemy movement if they run into each other from the side
	public void checkEnemyEnemyCollision() {
		updateCharactersList();
		// Start counting at 1 because index 0 of the cList is the player
		for(int i = 1; i < cList.size()-1; i++) {
			Enemy currentEnemy = (Enemy) cList.get(i);
			Enemy nextEnemy = (Enemy) cList.get(i+1);
			if( ( currentEnemy.getX2() >= nextEnemy.getX1() && currentEnemy.getX1() < nextEnemy.getX1()) ||
			    ( currentEnemy.getX1() > nextEnemy.getX1() && currentEnemy.getX1() <= nextEnemy.getX2()) ) {
				currentEnemy.changeDirection();
				nextEnemy.changeDirection();
			}
		}
	}
	
	public void checkMapCollision()
	{
		// TODO Um yeah, iterate through both the player list and the enemy list
		// And check the blocks around them
		// If they are colliding with the player/enemy, move them back
		// 
	}
}
