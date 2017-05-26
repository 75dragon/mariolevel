package Level;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Displayer extends JPanel
{
	World w;
	JLabel gameOverLabel = new JLabel();
	
	public Displayer(int x, int y) 
	{
		this.setPreferredSize(new Dimension(x, y));
		this.setVisible(true);
		setBackground(Color.WHITE);
	}
	
	public void setWorld( World world )
	{
		w = world;
	}
	
	public void drawCharacters(Graphics g) {
		w.player.drawPlayer(g);
		w.goomba.drawGoomba(g);
	}
	
	public void showGameOver() {
		gameOverLabel.setText("asdfasdf");
		gameOverLabel.setForeground(Color.RED);
		gameOverLabel.setFont( new Font("", Font.BOLD, 50) );
		add(gameOverLabel);
		repaint();
	}
	
	
//	public void paint( Graphics g )
//	{
//		g.setColor(Color.WHITE);
//		g.fillRect(0, 0, this.getWidth(), this.getHeight());
//		for ( int i = 0 ; i < w.yDim ; i++ )
//		{
//			for ( int j = 0 ; j < w.xDim ; j++)
//			{
//				w.level[i][j].drawMe(g);
//			}
//		}
//	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawCharacters(g);
	}
	
}
