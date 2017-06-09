package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import level.World;

public class Keyboard implements KeyListener
{
	World world;
	public Keyboard( World world )
	{
		this.world = world;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_SPACE) {
			world.player.jump();
		}
		
		if(key == KeyEvent.VK_RIGHT) {
			world.player.moveRight();
		}
		
		if(key == KeyEvent.VK_LEFT) {
			world.player.moveLeft();
		}
		
		// To do, add running for player
		
		// for testing player/enemy collision
//		if(key == KeyEvent.VK_UP) {
//			world.player.moveUp();
//		}
//		if(key == KeyEvent.VK_DOWN) {
//			world.player.moveDown();
//		}

		
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		int key = e.getKeyCode();
		if( key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_LEFT  ||
			key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN) {
			world.player.setXVel(0);
			//world.player.setYVel(0);
		}
		
		
	}

	@Override
	public void keyTyped(KeyEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

}
