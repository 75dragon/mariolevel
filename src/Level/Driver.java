package Level;

import characters.Player;

public class Driver
{
	Frame frame;
	Displayer display;
	World world;
	Player player;
	Physics physics;
	Keyboard listener;
	
	public Driver() {
		frame = new Frame();
		display = new Displayer(400,400);
		//player = new Player(20,20,20,1);
		physics = new Physics();
		// Items passed into constructor for world class are completely arbitrary,
		// so that the program will compile
		world = new World(1,1,1, display, physics);
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
