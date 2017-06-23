package characters;

import java.util.ArrayList;

import level.World;
import tiles.Tile;

public class Collision {
	private World world;
	private ArrayList<Enemy> cList;
	private ArrayList<Player> pList;
	private Player player;
	private boolean collided = false;

	// **********************************************************
	private boolean collidedLeft = false;
	private boolean collidedRight = false;
	private boolean collidedTop = false;
	private boolean collidedBottom = false;

	// **********************************************************

	// this is terrible. You should just instead just modify the world's array
	// directly with getters and setters
	// make sure that there are no bugs inside the code when everything is
	// immidatly removed
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

		for (int i = 0; i < cList.size(); i++) {
			Enemy currentEnemy = cList.get(i);
			// See the bottom of the Characters class for meaning of X1, X2, Y1
			// and Y2
			// Check to see if the player collides with the enemy from the top.
			// If the enemy is stompable, kill it
			// if( player.getX2() > currentEnemy.getX1() && player.getY2() >
			// currentEnemy.getY1() &&
			// player.getY1() < currentEnemy.getY1() && player.getX1() <
			// currentEnemy.getX2() && currentEnemy.isStompable()) {
			// player.stomp(currentEnemy);
			// System.out.println("adfasdf");
			// }
			// // else if the player collides with the side of the enemy or if
			// the enemy is not stompable and the
			// // player attempts to stomp
			if (player.getX1() < currentEnemy.getX2() && player.getX2() > currentEnemy.getX1()
					&& player.getY1() < currentEnemy.getY2() && player.getY2() > currentEnemy.getY1()) {
				if (player.jumping) {
					player.stomp(currentEnemy);
				} else {
					// System.out.println("death");
					// world.showGameOver();
				}
			}
		}
	}

	// Changes direction of enemy movement if they run into each other from the
	// side
	public void checkEnemyEnemyCollision() {
		updateCharactersList();
		// Start counting at 1 because index 0 of the cList is the player
		for (int i = 0; i < cList.size() - 1; i++) {
			Enemy currentEnemy = cList.get(i);
			Enemy nextEnemy = cList.get(i + 1);
			if ((currentEnemy.getX2() >= nextEnemy.getX1() && currentEnemy.getX1() < nextEnemy.getX1())
					|| (currentEnemy.getX1() > nextEnemy.getX1() && currentEnemy.getX1() <= nextEnemy.getX2())) {
				currentEnemy.changeDirection();
				nextEnemy.changeDirection();
			}
		}
	}

	public boolean hasCollided() {
		return collided;
	}

	public boolean checkCollision(Tile currentTile, Character currentCharacter) {
		if (currentCharacter.getX1() <= currentTile.getX2() && currentCharacter.getX2() >= currentTile.getX1()
				&& currentCharacter.getY1() <= currentTile.getY2() && currentCharacter.getY2() >= currentTile.getY1()
				&& !currentTile.isPassable()) {
			// check collide from bottom
			// check collide from left
			if (currentCharacter.getX2() >= currentTile.getX1() && currentCharacter.getY1() == currentTile.getY1()
					&& currentCharacter.getX1() < currentTile.getX1()) {
				collidedLeft = true;
			}
			// check collide from right

			// check collide from top
			else if (currentCharacter.getY2() > currentTile.getY1() && currentCharacter.getY1() < currentTile.getY1()) {
				collidedTop = true;
				System.out.println("afasf");
			}

			collided = true;
			return true;
		} else {
			return false;
		}
	}

	// TODO Um yeah, iterate through both the player list and the enemy list
	// And check the blocks around them
	// If they are colliding with the player/enemy, move them back
	//
	public void checkMapCollision() {
		Tile[][] tiles = world.getLevel();
		Player currentPlayer = pList.get(0);

		for (int i = 0; i < tiles.length; i++) {
			for (int j = 0; j < tiles[i].length; j++) {
				Tile currentTile = tiles[i][j];

				if (!currentTile.isPassable()) {
					// colliding at the top of tile
					if (currentPlayer.getBounds().intersects(currentTile.getBounds())) {
						currentPlayer.setYPos(currentTile.getY1() - currentPlayer.getHeight());
						currentPlayer.setYVel(0);
						currentPlayer.setFalling(false);
						currentPlayer.setJump(false);
					} else {
						currentPlayer.setFalling(true);
					}

					// colliding at the left of tile
					if (currentPlayer.getBoundsRight().intersects(currentTile.getBounds())) {
						currentPlayer.setXPos(currentTile.getX1() - currentPlayer.getWidth());
						currentPlayer.setXVel(0);
					}

					// colliding at the right of tile
					if (currentPlayer.getBoundsLeft().intersects(currentTile.getBounds())) {
						currentPlayer.setXPos(currentTile.getX2());
						currentPlayer.setXVel(0);
					}

					// colliding at the bottom of tile
					if (currentPlayer.getBoundsTop().intersects(currentTile.getBounds())) {
						System.out.println("in");
						currentPlayer.setYPos(currentTile.getY2()+5);
						currentPlayer.setYVel(0);
						
					}

				}

			}
		}
	}
}
