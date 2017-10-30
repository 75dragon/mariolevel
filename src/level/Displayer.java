package level;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import characters.Enemy;
import characters.Player;

public class Displayer extends JPanel
{
	private World world;
	private JLabel gameOverLabel = new JLabel();
	
	public Displayer(int x, int y) 
	{
		this.setPreferredSize(new Dimension(x, y));
		this.setVisible(true);
		setBackground(Color.GRAY);
		initializeGameOverLabel();
	}
	
	/**
	 * creates a game over screen
	 */
	public void initializeGameOverLabel() {
		gameOverLabel.setText("");
		gameOverLabel.setForeground(Color.RED);
		gameOverLabel.setFont( new Font("", Font.BOLD, 40) );
		add(gameOverLabel);
	}
	
	public void setWorld( World world )
	{
		this.world = world;
	}
	
	/**
	 * draws all the chars
	 * @param g graphics object
	 */
	public void drawCharacters(Graphics g) {
		ArrayList<Enemy> cList = world.getCList();
		for(int i = 0; i < cList.size(); i++) {
			cList.get(i).draw(g);
		}	
		ArrayList<Player> pList = world.getPList();
		for(int i = 0; i < pList.size(); i++) {
			pList.get(i).draw(g);
		}
		
	}
	
	public void drawHUD(Graphics g) {
		world.hud.draw(g);
	}
	
	/**
	 * tells the tiles to go draw themselves
	 * @param g the graphics object, so the tiles can draw themselves
	 */
	public void drawTiles(Graphics g) {
		for ( int i = 0 ; i < world.xDim ; i++ )
		{
			for ( int j = 0 ; j < world.yDim ; j++)
			{
				world.level[i][j].drawMe(g);
			}
		}
	}
	
	/**
	 * Shows game over lable
	 */
	public void showGameOver() {
		gameOverLabel.setText("GAME OVER");
		repaint();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.translate( 600 - world.player.getX(), 250 - world.player.getY() );
		drawTiles(g);
		drawCharacters(g);
		drawHUD(g);
	}
}
