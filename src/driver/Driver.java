package driver;

import characters.Player;

import characters.Collision;
import control.Keyboard;
import level.Displayer;
import level.Frame;
import level.World;


public class Driver
{
	Frame frame;
	Displayer display;
	World world;
	Player player;
	Keyboard listener;
	Collision collision;
	
	public Driver() {
		frame = new Frame();
		display = new Displayer(1200,500);
		collision = new Collision();
		world = new World(100,10,40, display, collision);
		listener = new Keyboard(world);
		frame.addKeyListener(listener);
		frame.add(display);
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		Driver d = new Driver();
	}
}
