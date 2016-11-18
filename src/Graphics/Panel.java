package Graphics;
import javax.swing.*;
import java.awt.*;

import Main.*;

public class Panel extends JPanel {

	Graphics bufferGraphics;
	Image offscreen;
	Dimension dim;

	Instance inst;
	Solution sol;


	public Panel(Instance inst, Solution sol){
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
		bufferGraphics.fillRect(0,0,Main.tailleFen,Main.tailleFen+22);


		// DESSIN DES POINTS DE L'INSTANCE

		int n = inst.getN();
		int rpx = 4; //rayon des points dessinés, en px
		double ratio = Main.tailleFen / Main.resPx;

		for (int i = 0; i < n; i++){
			bufferGraphics.setColor(Color.RED);
			bufferGraphics.drawLine((int)((inst.getPoints().get(i).getX()*ratio)-rpx), (int)(inst.getPoints().get(i).getY()*ratio), (int)((inst.getPoints().get(i).getX()*ratio)+rpx), (int)(inst.getPoints().get(i).getY()*ratio));
			bufferGraphics.drawLine((int)(inst.getPoints().get(i).getX()*ratio), (int)((inst.getPoints().get(i).getY()*ratio)-rpx), (int)(inst.getPoints().get(i).getX()*ratio), (int)((inst.getPoints().get(i).getY()*ratio)+rpx));
			//Pour tracer des points plutôt que des croix :
			//bufferGraphics.fillOval((int)((inst.getPoints().get(i).getX()*ratio)-rpx),(int)((inst.getPoints().get(i).getY()*ratio)-rpx), 2*rpx, 2*rpx);
		}

		// DESSIN DES CENTRES

		int k = sol.getK();
		int r = sol.getRayon();
		
		//System.out.println(r);
		
		Color lightBlue = new Color(0,0,255,10);

		for (int i = 0; i < k; i++){
			bufferGraphics.setColor(Color.BLUE);
			bufferGraphics.fillOval((int)(sol.getCentres().get(i).getX()*ratio)-rpx,(int)(sol.getCentres().get(i).getY()*ratio)-rpx, 2*rpx, 2*rpx);
			bufferGraphics.setColor(lightBlue);
			bufferGraphics.fillOval((int)((sol.getCentres().get(i).getX())*ratio-ratio*r),(int)((sol.getCentres().get(i).getY())*ratio-ratio*r), (int)(r*2*ratio), (int)(r*2*ratio));
			bufferGraphics.setColor(Color.BLUE);
			bufferGraphics.drawOval((int)(((sol.getCentres().get(i).getX())*ratio)-(ratio*r)),(int)(((sol.getCentres().get(i).getY())*ratio)-(ratio*r)), (int)(r*2*ratio), (int)(r*2*ratio));
		}

		g.drawImage(offscreen,0,0,this);

		repaint();

	}




}
