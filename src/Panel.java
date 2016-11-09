
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
	}

	public void init(){
		dim = getSize();
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

		bufferGraphics.setColor(Color.WHITE);
		bufferGraphics.fillRect(0,0,400,422);

		// DESSIN DES POINTS DE L'INSTANCE

		int n = inst.getN();

		for (int i = 0; i < n; i++){
			bufferGraphics.setColor(Color.RED);
			bufferGraphics.fillOval((inst.getPoints().get(i).getX()*4)-1,(inst.getPoints().get(i).getY()*4)-1, 2, 2);
		}

		// DESSIN DES CENTRES

		int k = sol.getK();

		int r = sol.getRayon();

		for (int i = 0; i < k; i++){
			bufferGraphics.setColor(Color.BLUE);
			bufferGraphics.drawOval((sol.getCentres().get(i).getX()*4)-1,(sol.getCentres().get(i).getY()*4)-1, 2, 2);
			bufferGraphics.drawOval((sol.getCentres().get(i).getX()-r/2)*4,(sol.getCentres().get(i).getY()-r/2)*4, r, r);

		}

		repaint();

	}




}
