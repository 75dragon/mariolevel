package Level;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import characters.Characters;

public class Displayer extends JPanel
{
	World world;
	JLabel gameOverLabel = new JLabel();
	
	public Displayer(int x, int y) 
	{
		this.setPreferredSize(new Dimension(x, y));
		this.setVisible(true);
		setBackground(Color.BLACK);
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
		// should store characters in an ArrayList, then check
		// if health != 0 before drawing, otherwise if health == 0
		// don't draw
		
		ArrayList<Characters> cList = world.getCList();
		for(int i = 0; i < cList.size(); i++) {
			cList.get(i).draw(g);
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
