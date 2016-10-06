package mjhv.sphereTesters;

import processing.core.PApplet;
import mjhv.shapes.Sphere;


public class DrawSurface extends PApplet {

	private Sphere ball, ball2;
	
	public DrawSurface() {
		ball = new Sphere(80, 100, 60, 50);
		ball2 = new Sphere(30);
		
		runSketch();
	}
	

	public void setup() {
		
	}
	
	public void settings()
	{
		size(300, 300, P3D);
	}

	public void draw() { 
		background(255);
		fill(255);
		textAlign(CENTER);
		
		noStroke();
		lights();
		translate(58, 48, 0);
		
		
		if (ball != null) {
			stroke(255,0,0);
			fill(255);
			ball.draw(this);
			
			textAlign(CENTER);
			textSize(12);
			// Print out other info about the sphere
		}
		
	}
	
	
	public void mousePressed() {
		if(mouseButton == LEFT) {
			//ball.move((double)mouseX, (double)mouseY);
			//ball.draw(this);
		}
		
		if(mouseButton == RIGHT)
		{
			System.out.println(ball.isPointInSphere((double)mouseX, (double)mouseY));
		}
		
		if(keyCode == UP)
		{
			ball.grow(5);
			ball.draw(this);
		}
		if (keyCode == DOWN)
		{
			ball.grow(-5);
			ball.draw(this);
		}
		
	}
	
	
}

