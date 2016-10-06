import processing.core.PApplet;


public class DrawSurface extends PApplet{
	
	private House house;
	private Person person;
	
	
	//scale factor that changes in drawing surface 
	
	
	//constructor
	public DrawSurface()
	{
		house = new House();
		person = new Person();
		
		runSketch();
	}
	
	// The statements in the setup() function 
		// execute once when the program begins
	public void setup() {
		
	}
	
	public void draw() { 
		
		background(255); 
		
		house.draw(this);
		
		float x = width/400f;
		float y = height/300f;
		scale(x, y); //scales drawing 
		
		person.draw(this); 
	}
	
	public void mousePressed()
	{
		house.xCoord = mouseX;
		house.yCoord = mouseY;
		redraw();
	}
	
	public void keyPressed()
	{
		if (key == CODED) 
		{
			//moves person left and right and keeps person inside the window
			if (keyCode == LEFT && person.xCoord > 30)
			{
				person.moveLeft();
			}
			else if (keyCode == RIGHT && person.xCoord < 380)
			{
				person.moveRight();
			}
			
			
			//scales house up/down arrows
			if (keyCode == UP) 
			{
				/*
				translate(house.xCoord, house.yCoord);
				house.scaleFactor += 0.10;
				scale(house.scaleFactor);
				house.draw(this); */
				
				house.scaleFactor += 0.2f;
				house.draw(this);
			}
			
			
			else if (keyCode == DOWN)
			{
				/*
				translate(house.xCoord, house.yCoord);
				house.scaleFactor -= 0.10;
				scale(house.scaleFactor);
				house.draw(this); */
				
				house.scaleFactor -= 0.2f;
				house.draw(this);
			}
			
			
		}
	} 
	


}