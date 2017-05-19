package Level;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Displayer extends JPanel
{
	World w;
	public Displayer(int x, int y) 
	{
		this.setPreferredSize(new Dimension(x, y));
		this.setVisible(true);
	}
	
	public void setWorld( World world )
	{
		w = world;
	}
	
	public void paint( Graphics g )
	{
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		for ( int i = 0 ; i < w.yDim ; i++ )
		{
			for ( int j = 0 ; j < w.xDim ; j++)
			{
				w.level[i][j].drawMe(g);
			}
		}
	}
}
