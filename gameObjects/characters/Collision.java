package characters;

import java.util.ArrayList;

import level.World;
import tiles.Tile;

public class Collision
{
	private World world;
	private ArrayList<Enemy> cList;
	private ArrayList<Player> pList;
	private Player player;
	private boolean collided = false;
	boolean falling = false;

	public void setWorld(World world)
	{
		this.world = world;
	}

	// Updates both Player and Enemy lists
	public void updateCharactersList()
	{
		cList = world.getCList();
		pList = world.getPList();
	}

	/**
	 * checks if the player hits an enemy if so, if player is jumping its a kill
	 * and true else, true and player is killed
	 * 
	 * @return if collided
	 */
	public boolean checkPlayerEnemyCollision()
	{
		updateCharactersList();
		player = pList.get(0);
		for (int i = 0; i < cList.size(); i++)
		{
			Enemy currentEnemy = cList.get(i);
			if (player.getX1() < currentEnemy.getX2() && player.getX2() > currentEnemy.getX1()
					&& player.getY1() < currentEnemy.getY2() && player.getY2() > currentEnemy.getY1())
			{
				if (player.jumping)
				{
					player.stomp(currentEnemy);
				} else
				{
					// System.out.println("death");
					// world.showGameOver();
				}
				return true;
			}
		}
		return false;
	}

	/**
	 * Changes direction of enemy movement if they run into each other from the
	 * side
	 */
	public void checkEnemyEnemyCollision()
	{
		updateCharactersList();
		// Start counting at 1 because index 0 of the cList is the player
		for (int i = 0; i < cList.size() - 1; i++)
		{
			for (int j = i + 1; j < cList.size(); j++)
			{
				Enemy currentEnemy = cList.get(i);
				Enemy nextEnemy = cList.get(j);
				if ((currentEnemy.getX2() >= nextEnemy.getX1() && currentEnemy.getX1() < nextEnemy.getX1())
						|| (currentEnemy.getX1() > nextEnemy.getX1() && currentEnemy.getX1() <= nextEnemy.getX2()))
				{
					currentEnemy.changeDirection();
					nextEnemy.changeDirection();
				}
			}
		}
	}

	public boolean hasCollided()
	{
		return collided;
	}

	/**
	 * checks the collision between a tile and char
	 * @param currentTile
	 * @param currentCharacter
	 * @return true if they are overlapping, false otherwise
	 */
	public boolean checkCollision(Tile currentTile, Character currentCharacter)
	{
		if (currentCharacter.getX1() <= currentTile.getX2() && currentCharacter.getX2() >= currentTile.getX1()
				&& currentCharacter.getY1() <= currentTile.getY2() && currentCharacter.getY2() >= currentTile.getY1()
				&& !currentTile.isPassable())
		{
			// check collide from bottom
			// check collide from left
			if (currentCharacter.getX2() >= currentTile.getX1() && currentCharacter.getY1() == currentTile.getY1()
					&& currentCharacter.getX1() < currentTile.getX1())
			{
				return true;
			}
			// check collide from right
			// check collide from top
			if (currentCharacter.getY2() > currentTile.getY1() && currentCharacter.getY1() < currentTile.getY1())
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * give it a char, and checks if it currently collides into terrain if so,
	 * return true if it does, false otherwise
	 * 
	 * @param ch
	 *            the charater
	 * @param xPos
	 *            xposition, the future location in tiles
	 * @param yPos
	 *            yposition, the future location in tiles
	 * @return true if your hitting terrain
	 */
	public boolean checkMapCollision(Character ch, int xPos, int yPos)
	{
		Tile[][] tiles = world.getLevel();
		if (checkCollision(tiles[xPos][yPos], ch) || checkCollision(tiles[xPos + 1][yPos], ch)
				|| checkCollision(tiles[xPos][yPos + 1], ch) || checkCollision(tiles[xPos + 1][yPos + 1], ch))
		{
			return true;
		}
		return false;
		// for (int k = 0; k < cList.size(); k++)
		// {
		// Character currentCharacter = cList.get(k);
		// for (int i = 0; i < tiles.length; i++)
		// {
		// for (int j = 0; j < tiles[i].length; j++)
		// {
		// Tile currentTile = tiles[i][j];
		//
		// if (currentCharacter instanceof Player)
		// {
		// if (!currentTile.isPassable())
		// {
		// // colliding at the top of tile
		// if (currentCharacter.getBounds().intersects(currentTile.getBounds()))
		// {
		// currentCharacter.setYPos(currentTile.getY1() -
		// currentCharacter.getHeight());
		// currentCharacter.setYVel(0);
		// currentCharacter.setFalling(false);
		// currentCharacter.setJump(false);
		// } else
		// {
		// currentCharacter.setFalling(true);
		// }
		//
		// // colliding at the left of tile
		// if
		// (currentCharacter.getBoundsRight().intersects(currentTile.getBounds()))
		// {
		// currentCharacter.setXPos(currentTile.getX1() -
		// currentCharacter.getWidth());
		// currentCharacter.setXVel(0);
		// }
		//
		// // colliding at the right of tile
		// if
		// (currentCharacter.getBoundsLeft().intersects(currentTile.getBounds()))
		// {
		// currentCharacter.setXPos(currentTile.getX2());
		// currentCharacter.setXVel(0);
		// }
		//
		// // colliding at the bottom of tile
		// if
		// (currentCharacter.getBoundsTop().intersects(currentTile.getBounds()))
		// {
		// System.out.println("in");
		// currentCharacter.setYPos(currentTile.getY2() + 5);
		// currentCharacter.setYVel(0);
		//
		// }
		//
		// }
		// } else
		// {
		// if (!currentTile.isPassable())
		// {
		// // colliding at the top of tile
		// if (currentCharacter.getBounds().intersects(currentTile.getBounds()))
		// {
		// currentCharacter.setYPos(currentTile.getY1() -
		// currentCharacter.getHeight());
		// currentCharacter.setYVel(0);
		// currentCharacter.setFalling(false);
		// currentCharacter.setJump(false);
		// } else
		// {
		// currentCharacter.setFalling(true);
		// }
		//
		// // colliding at the left of tile
		// if
		// (currentCharacter.getBoundsRight().intersects(currentTile.getBounds()))
		// {
		// currentCharacter.setXPos(currentTile.getX1() -
		// currentCharacter.getWidth());
		// ((Enemy) currentCharacter).changeDirection();
		// }
		//
		// // colliding at the right of tile
		// if
		// (currentCharacter.getBoundsLeft().intersects(currentTile.getBounds()))
		// {
		// currentCharacter.setXPos(currentTile.getX2());
		// ((Enemy) currentCharacter).changeDirection();
		// }
		//
		// // colliding at the bottom of tile
		// if
		// (currentCharacter.getBoundsTop().intersects(currentTile.getBounds()))
		// {
		// System.out.println("in");
		// currentCharacter.setYPos(currentTile.getY2() + 5);
		// currentCharacter.setYVel(0);
		// currentCharacter.setYPos(currentCharacter.getY() + 3);
		//
		// }
		//
		// }
		// }
		// }
		// }
		// }
	}
}
