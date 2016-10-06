import java.util.ArrayList;

import mjhv.shapes.Circle;
import mjhv.shapes.Rectangle;
import processing.core.PApplet;

public class DrawSurface extends PApplet {
	
	private double center;
	private Rectangle square;
	private ArrayList<Circle> circles;
	
	public DrawSurface()
	{
		center = 250;
		
		//circles in order of outermost to innermost 
		circles = new ArrayList<Circle>();
		
		circles.add(new Circle(center, center, 450));
		circles.add(new Circle(center, center, 425));
		circles.add(new Circle(center, center, 400));
		circles.add(new Circle(center, center, 375));
		circles.add(new Circle(center, center, 350));
		circles.add(new Circle(center, center, 325));
		circles.add(new Circle(center, center, 300));
		circles.add(new Circle(center, center, 275));
		circles.add(new Circle(center, center, 250));
		circles.add(new Circle(center, center, 225));
		circles.add(new Circle(center, center, 200));
		circles.add(new Circle(center, center, 175));
		circles.add(new Circle(center, center, 150));
		circles.add(new Circle(center, center, 125));
		circles.add(new Circle(center, center, 100));
		circles.add(new Circle(center, center, 75));
		
		square = new Rectangle(87.5, 75, 325, 350);
		
		runSketch();
	}
	
	public void setup()
	{
		
	}
	
	public void draw()
	{
		background(255);
		
		float x = width/500f;
		float y = height/500f;
		scale(x, y);
		
		strokeWeight(7);
		//draws Circles
		for(int i = 0; i < circles.size(); i++)
		{
			Circle c = circles.get(i);
			stroke(0);
			c.draw(this);
		}
		stroke(120);
		noFill();
		square.draw(this);
		
	
	}
	
	

}
