package level;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Frame extends JFrame
{
	public Frame()
	{
		this.setVisible(true);
		//this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setTitle("MMMARIO");
		setLocation(200,200);
		setResizable(false);
	}
}
