
import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {

	Graphics bufferGraphics;
	Image offscreen;
	Dimension dim;

	Instance inst;
	Solution sol;


	Panel(Instance inst, Solution sol){
		this.inst = inst;
		this.sol = sol;
	}

	public void init(){
		dim = getSize();
		//System.out.println(dim.width + ", " + dim.height);
		offscreen = createImage(dim.width, dim.height);
		bufferGraphics = offscreen.getGraphics();
	}

	@Override
	public void update(Graphics g){
		paintComponent(g);
	}

	// DESSIN DES ELEMENTS

	@Override
	public void paintComponent(Graphics g){
		init();

		//System.out.println("test");

		bufferGraphics.setColor(Color.WHITE);
		bufferGraphics.fillRect(0,0,400,422);


		// DESSIN DES POINTS DE L'INSTANCE

		int n = inst.getN();

		for (int i = 0; i < n; i++){
			bufferGraphics.setColor(Color.RED);
			bufferGraphics.fillOval((inst.getPoints().get(i).getX()*4)-5,(inst.getPoints().get(i).getY()*4)-5, 10, 10);
		}

		// DESSIN DES CENTRES

		int k = sol.getK();

		int r = sol.getRayon();

		for (int i = 0; i < k; i++){
			bufferGraphics.setColor(Color.BLUE);
			bufferGraphics.fillOval((sol.getCentres().get(i).getX()*4)-5,(sol.getCentres().get(i).getY()*4)-5, 10, 10);
			bufferGraphics.drawOval((sol.getCentres().get(i).getX())*4-2*r,(sol.getCentres().get(i).getY())*4-2*r, r*4, r*4);

		}

		g.drawImage(offscreen,0,0,this);

		repaint();

	}




}
