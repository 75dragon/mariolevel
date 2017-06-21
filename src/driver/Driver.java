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
	Player player; //Not Used
	Keyboard listener;
	Collision collision;
	
	public Driver() {
		frame = new Frame();
		display = new Displayer(1600,500);
		//player = new Player(20,20,20,1);
		collision = new Collision();
		// Items passed into constructor for world class are completely arbitrary,
		// so that the program will compile
		world = new World(100,10,30, display, collision);
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
