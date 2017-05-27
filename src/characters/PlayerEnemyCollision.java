package characters;

import Level.World;

public class PlayerEnemyCollision {
	World world;
	
	public void setWorld(World world) {
		this.world = world;
	}
		
	public void checkCollide() {
		int playerX1 = world.player.getX1();
		int playerX2 = world.player.getX2();
		int playerY1 = world.player.getY1();
		int playerY2 = world.player.getY2();
		
		int goombaX1 = world.goomba.getX1();
		int goombaX2 = world.goomba.getX2();
		int goombaY1 = world.goomba.getY1();
		int goombaY2 = world.goomba.getY2();
		
		// Top collide, for stomping
		if( playerX2 > goombaX1 && playerY2 > goombaY1 &&
			 playerY1 < goombaY1 && playerX1 < goombaX2) {
			System.out.println("Collided with top");
		}
		else if( playerX1 < goombaX2 && playerX2 > goombaX1 &&
			playerY1 < goombaY2 && playerY2 > goombaY1	) {
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
	
	
	
	
	
	
	
	
}
