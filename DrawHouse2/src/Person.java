import processing.core.PVector;

/*2 things I like:
 * 	How the all the lines and triangles are drawn in relation to a standard xCoord, yCoord
 * Everything is documented through comments fully.
 * 
 * 2 Modifications:
 * make the fields private
 * Make a field for scaling
 * 
 * 
 */
public class Person {
	
	//add private fields of person that can change (location)
	
	float xCoord, yCoord; 
	
	
	public Person()
	{
		// Coordinate for object is center of body (where arms connect to body
		xCoord = 60;
		yCoord = 180;
	}
	
	
	public void draw(DrawSurface canvas)
	{
		
		//coordinates in relation to set coordinates in constructor
		canvas.line(xCoord, yCoord - 30, xCoord, yCoord); //body
		canvas.line(xCoord, yCoord, xCoord - 10, yCoord + 20); //left leg
		canvas.line(xCoord, yCoord, xCoord + 10, yCoord + 20); //right leg
		canvas.line(xCoord, yCoord - 20, xCoord - 20, yCoord - 10); //left arm
		canvas.line(xCoord, yCoord - 20, xCoord + 20, yCoord - 10); //right arm
		canvas.triangle(xCoord - 20, yCoord - 30, xCoord, yCoord - 50, xCoord + 20, yCoord - 30); //head
		
	
	}
	
	public void moveLeft()
	{
		xCoord -= 10; 
	}

	public void moveRight()
	{
		xCoord += 10;
	}
	
	
}
