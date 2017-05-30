package characters;

import java.util.ArrayList;

import Level.World;

public class CharacterCollision {
	World world;
	
	public void setWorld(World world) {
		this.world = world;
	}
		
	public void checkPlayerEnemyCollide() {
		int playerX1 = world.player.getX1();
		int playerX2 = world.player.getX2();
		int playerY1 = world.player.getY1();
		int playerY2 = world.player.getY2();
		
		int goomba1X1 = world.goomba1.getX1();
		int goomba1X2 = world.goomba1.getX2();
		int goomba1Y1 = world.goomba1.getY1();
		int goomba1Y2 = world.goomba1.getY2();
		
		// Top collide, for enemy stomping
		if( playerX2 > goomba1X1 && playerY2 > goomba1Y1 &&
			playerY1 < goomba1Y1 && playerX1 < goomba1X2 && world.goomba1.getJumped()) {
			world.player.stomp(world.goomba1); 
		}
		// for all other collisions
		else if( playerX1 < goomba1X2 && playerX2 > goomba1X1 &&
			playerY1 < goomba1Y2 && playerY2 > goomba1Y1	) {
			System.out.println("death");
			//			world.showGameOver();
		}
	}
	
	/*		(x1, y1)		(x2, y1)
	 * 		-----------------
	 * 		|				|
	 *		|				| 		
	 *		|				|
	 * 		|				|	
	 * 		-----------------
	 * 		(x1, y2)		(x2, y2)
	 */
	
	// Changes direction of enemy movement if they collide
	public void checkEnemyEnemyCollision() {
		int goomba1X1 = world.goomba1.getX1();
		int goomba1X2 = world.goomba1.getX2();
		int goomba1Y1 = world.goomba1.getY1();
		int goomba1Y2 = world.goomba1.getY2();
		
		int redTurtle1X1 = world.redTurtle1.getX1();
		int redTurtle1X2 = world.redTurtle1.getX2();
		int redTurtle1Y1 = world.redTurtle1.getY1();
		int redTurtle1Y2 = world.redTurtle1.getY2();
		
		if( ( goomba1X2 >= redTurtle1X1 && goomba1X1 < redTurtle1X1) ||
			( goomba1X1 > redTurtle1X1 && goomba1X1 <= redTurtle1X2) ) {
			world.goomba1.changeDirection();
			world.redTurtle1.changeDirection();
			
		}
	}
}
