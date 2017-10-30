package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import level.World;

public class Keyboard implements KeyListener {
	private World world;
	private Stack<Integer> keysPressed;
	private Stack<Integer> keysReleased;

	public Keyboard(World world) {
		this.world = world;
		keysPressed = new Stack<>();
		keysReleased = new Stack<>();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
//		if(key == KeyEvent.VK_SPACE && !world.player.isJumping()) {
//			world.player.setJump(true);
//			world.player.setYVel(-25);
//		}
		if(key == KeyEvent.VK_SPACE) {
			world.player.setJump(true);
			world.player.setYVel(-25);
		}
		
		if(key == KeyEvent.VK_RIGHT) {
			world.player.moveRight();
		}
		
		if(key == KeyEvent.VK_LEFT) {
			world.player.moveLeft();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keysReleased.push(e.getKeyCode());

		while (!keysReleased.isEmpty()) {
			int key = keysReleased.pop();
			if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_LEFT || key == KeyEvent.VK_UP
					|| key == KeyEvent.VK_DOWN || key == KeyEvent.VK_V) {
				world.player.setXVel(0);
			}
			
			
			
		}

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
