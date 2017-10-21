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
	boolean falling = false;

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

	// public boolean checkCollision(Tile currentTile, Character
	// currentCharacter) {
	// if (currentCharacter.getX1() <= currentTile.getX2() &&
	// currentCharacter.getX2() >= currentTile.getX1()
	// && currentCharacter.getY1() <= currentTile.getY2() &&
	// currentCharacter.getY2() >= currentTile.getY1()
	// && !currentTile.isPassable()) {
	// // check collide from bottom
	// // check collide from left
	// if (currentCharacter.getX2() >= currentTile.getX1() &&
	// currentCharacter.getY1() == currentTile.getY1()
	// && currentCharacter.getX1() < currentTile.getX1()) {
	// collidedLeft = true;
	// }
	// // check collide from right
	//
	// // check collide from top
	// else if (currentCharacter.getY2() > currentTile.getY1() &&
	// currentCharacter.getY1() < currentTile.getY1()) {
	// collidedTop = true;
	// System.out.println("afasf");
	// }
	//
	// collided = true;
	// return true;
	// } else {
	// return false;
	// }
	// }

	// TODO Um yeah, iterate through both the player list and the enemy list
	// And check the blocks around them
	// If they are colliding with the player/enemy, move them back
	//
	public void checkMapCollision() {
		Tile[][] tiles = world.getLevel();
		ArrayList<Character> cList = world.charaList;

		for (int k = 0; k < cList.size(); k++) {
			Character currentCharacter = cList.get(k);
			for (int i = 0; i < tiles.length; i++) {
				for (int j = 0; j < tiles[i].length; j++) {
					Tile currentTile = tiles[i][j];

					if (currentCharacter instanceof Player) {
						if (!currentTile.isPassable()) {
							// colliding at the top of tile
							if (currentCharacter.getBounds().intersects(currentTile.getBounds())) {
								currentCharacter.setYPos(currentTile.getY1() - currentCharacter.getHeight());
								currentCharacter.setYVel(0);
								currentCharacter.setFalling(false);
								currentCharacter.setJump(false);
							} else {
								currentCharacter.setFalling(true);
							}

							// colliding at the left of tile
							if (currentCharacter.getBoundsRight().intersects(currentTile.getBounds())) {
								currentCharacter.setXPos(currentTile.getX1() - currentCharacter.getWidth());
								currentCharacter.setXVel(0);
							}

							// colliding at the right of tile
							if (currentCharacter.getBoundsLeft().intersects(currentTile.getBounds())) {
								currentCharacter.setXPos(currentTile.getX2());
								currentCharacter.setXVel(0);
							}

							// colliding at the bottom of tile
							if (currentCharacter.getBoundsTop().intersects(currentTile.getBounds())) {
								System.out.println("in");
								currentCharacter.setYPos(currentTile.getY2() + 5);
								currentCharacter.setYVel(0);

							}

						}
					}
					else {
						if (!currentTile.isPassable()) {
							// colliding at the top of tile
							if (currentCharacter.getBounds().intersects(currentTile.getBounds())) {
								currentCharacter.setYPos(currentTile.getY1() - currentCharacter.getHeight());
								currentCharacter.setYVel(0);
								currentCharacter.setFalling(false);
								currentCharacter.setJump(false);
							} else {
								currentCharacter.setFalling(true);
							}

							// colliding at the left of tile
							if (currentCharacter.getBoundsRight().intersects(currentTile.getBounds())) {
								currentCharacter.setXPos(currentTile.getX1() - currentCharacter.getWidth());
								((Enemy) currentCharacter).changeDirection();
							}

							// colliding at the right of tile
							if (currentCharacter.getBoundsLeft().intersects(currentTile.getBounds())) {
								currentCharacter.setXPos(currentTile.getX2());
								((Enemy) currentCharacter).changeDirection();
							}

							// colliding at the bottom of tile
							if (currentCharacter.getBoundsTop().intersects(currentTile.getBounds())) {
								System.out.println("in");
								currentCharacter.setYPos(currentTile.getY2() + 5);
								currentCharacter.setYVel(0);
								currentCharacter.setYPos(currentCharacter.getY() + 3);


							}

						}
					}
				}
			}
		}
	}
}
