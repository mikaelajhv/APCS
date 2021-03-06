import mjhv.shapes.Line;
import processing.core.PApplet;


public class DrawSurface extends PApplet{
	
	private Line blue1, blue2, l1, l2, l3, l4, l5, l6, l7, l8, l9, l10;
	
	public DrawSurface()
	{	
		l1 = new Line(1, 200, 499, 160);
		l2 = new Line(1, 205, 499, 165);
		l3 = new Line(1, 210, 499, 180);
		l4 = new Line(1, 215, 499, 195);
		l5 = new Line(1, 220, 499, 210); // middle line
		l6 = new Line(1, 225, 499, 225); 
		l7 = new Line(1, 230, 499, 240);
		l8 = new Line(1, 235, 499, 255);
		l9 = new Line(1, 240, 499, 270);
		l10 = new Line(1, 245, 499, 285); 
	
		blue1 = new Line(295, 190, 295, 255); //two blue stripes
		blue2 = new Line(255, 190, 255, 255);
		
		runSketch();
	}
	
	
	public void draw()
	{
		super.draw();
		background(255);
		
		l1.draw(this);
		
	}
	

}
