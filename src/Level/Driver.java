package Level;

public class Driver
{
	Frame frame;
	Displayer display;
	World world;
	Player player;
	Physics physics;
	
	public Driver() {
		frame = new Frame();
		display = new Displayer(400,400);
		player = new Player();
		physics = new Physics();
		world = new World(1,1,1, display, player, physics);
		frame.add(display);
		frame.pack();
		frame.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		Driver d = new Driver();
	}
	
	
}
