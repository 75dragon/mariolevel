package level;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import characters.Character;
import characters.Enemy;
import characters.Player;

public class Displayer extends JPanel
{
	World world;
	JLabel gameOverLabel = new JLabel();
	
	public Displayer(int x, int y) 
	{
		this.setPreferredSize(new Dimension(x, y));
		this.setVisible(true);
		setBackground(Color.GRAY);
		initializeGameOverLabel();
	}
	
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
	
	public void drawTiles(Graphics g) {
		for ( int i = 0 ; i < world.xDim ; i++ )
		{
			for ( int j = 0 ; j < world.yDim ; j++)
			{
				world.level[i][j].drawMe(g);
			}
		}
	}
	
	public void showGameOver() {
		gameOverLabel.setText("GAME OVER");
		repaint();
	}
	
	
//	public void paint( Graphics g )
//	{
//		g.setColor(Color.WHITE);
//		g.fillRect(0, 0, this.getWidth(), this.getHeight());
//		for ( int i = 0 ; i < world.yDim ; i++ )
//		{
//			for ( int j = 0 ; j < world.xDim ; j++)
//			{
//				world.level[i][j].drawMe(g);
//			}
//		}
//	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.translate( 600 - world.player.getX(), 250 - world.player.getY() );
		drawTiles(g);
		drawCharacters(g);
		
	}
}
