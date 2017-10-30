package level;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;

public class HUD {
	private World world;
	private Timer timer;
	private JLabel timerLabel;
	private int initTime = 60;

	public HUD() {
		timerLabel = new JLabel(Integer.toString(initTime));
		timer = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				initTime--;
				
				if(initTime == 0) {
					
				}
				
			}
		});
	}
	
	public void setWorld(World w) {
		world = w;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.setFont(new Font("SERIF", Font.BOLD, 22));
		g.drawString(Integer.toString(initTime), world.player.getX(), world.player.getY() - 210);
	}

	public JLabel getTimerLabel() {
		return timerLabel;
	}

	public void startGameTimer() {
		timer.start();
	}

	public void stopGameTimer() {
		timer.stop();
	}
}
