package Level;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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

		
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		int key = e.getKeyCode();
		if( key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_LEFT ) {
			world.player.setXVel(0);
		}
		
		
	}

	@Override
	public void keyTyped(KeyEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

}
