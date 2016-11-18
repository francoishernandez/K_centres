package Graphics;

import java.awt.Dimension;
import java.io.IOException;
import Main.*;
import javax.swing.JFrame;

public class Fenetre extends JFrame {

	public Fenetre() throws IOException{
		this.gui();
	}

	public void gui() throws IOException{

		this.setTitle("Instances");

		this.setVisible(true);
		this.setPreferredSize(new Dimension(Main.tailleFen,Main.tailleFen+22));

		this.setResizable(false);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.pack();

	}
}