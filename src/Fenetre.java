
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Fenetre extends JFrame {

	public Fenetre() throws IOException{
		this.gui();
	}

	public void gui() throws IOException{

		this.setTitle("Instances");

		this.setVisible(true);
		this.setPreferredSize(new Dimension(400,422));

		this.setResizable(false);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.pack();

	}
}