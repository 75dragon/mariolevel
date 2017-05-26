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
		
		if( playerX1 < goombaX2 && playerX2 > goombaX1 &&
			playerY1 < goombaY2 && playerY2 > goombaY1	) {
			world.player.setHealth(0);
		}
		else
			world.player.setHealth(1);
			
		
		
		
		
		
		
		
	}
	
	
	
}
