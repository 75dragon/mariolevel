package Main;

import characters.Player;

import characters.Collision;
import control.Keyboard;
import level.Displayer;
import level.Frame;
import level.HUD;
import level.World;


public class Main
{
	Frame frame;
	Displayer display;
	World world;
	Player player;
	Keyboard listener;
	Collision collision;
	HUD hud;
	
	public Main() {
		frame = new Frame();
		display = new Displayer(1200,500);
		collision = new Collision();
		hud = new HUD();
		world = new World(100,10,40, display, collision, hud);
		listener = new Keyboard(world);
		frame.addKeyListener(listener);
		frame.add(display);
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		Main d = new Main();
	}
}
