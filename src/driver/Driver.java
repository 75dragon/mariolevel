package driver;

import Level.Displayer;
import Level.Frame;
import Level.Physics;
import Level.World;
import characters.Player;

import characters.CharacterCollision;
import control.Keyboard;


public class Driver
{
	Frame frame;
	Displayer display;
	World world;
	Player player;
	Physics physics;
	Keyboard listener;
	CharacterCollision collision;
	
	public Driver() {
		frame = new Frame();
		display = new Displayer(800,800);
		//player = new Player(20,20,20,1);
		physics = new Physics();
		collision = new CharacterCollision();
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
