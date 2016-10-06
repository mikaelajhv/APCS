
//import processing.awt.PSurfaceAWT;
//import processing.core.PApplet;
//import javax.swing.JFrame;
/* Suggestions for further flexibility:
 * -More than 1 class
 * 		Shape Classes (rectangle, triangle, etc.)
 * 		Window
 * 		-----
 * 		House (add additional things besides the house)
 * 		Main Method
 * 		Processing/DrawingSurface, a canvas (extends PApplet)
 *  
 * -Commenting for documentation
 * -Separate into multiple methods for drawing, smaller tasks (private?)
 * -use variables(properties) instead of hard-coded values
 */
 
public class House {
	
	//add private fields of house that can change 
	
	float xCoord, yCoord, hWidth, hHeight, scaleFactor;
	Line doorL, doorR;
	
	//translate method adds value to all things that come after -->changes location of origin
	public House()
	{
		//coordinates of object are center of the house
		//width/height of object = width/height of base of house
		xCoord = 200;
		yCoord = 150;
		hWidth = 200;
		hHeight = 100;
		
		scaleFactor = 1;
		
		doorL = new Line(xCoord - 15, yCoord + 10, xCoord - 15, yCoord + 50);
		doorR = new Line(xCoord + 15, yCoord + 10, xCoord + 15, yCoord + 50);
		
	}
	
	//draw method takes in processing PApplet DrawSurface
	public void draw(DrawSurface canvas) { 
		
		canvas.rect((xCoord - 100) * scaleFactor, (yCoord - 50) * scaleFactor, hWidth * scaleFactor, hHeight * scaleFactor); // base of house
		canvas.triangle((xCoord - 100) * scaleFactor, (yCoord - 50) * scaleFactor, (xCoord + 100) * scaleFactor, (yCoord - 50) * scaleFactor, xCoord * scaleFactor, (yCoord - 80) * scaleFactor); // roof
		canvas.rect((xCoord - 15) * scaleFactor, (yCoord + 10) * scaleFactor, (hWidth - 170) * scaleFactor, (hHeight - 60) * scaleFactor); // door
		canvas.rect((xCoord - 80) * scaleFactor, (yCoord - 30) * scaleFactor, (hWidth - 170) * scaleFactor, (hHeight - 70) * scaleFactor); // window
		canvas.rect((xCoord + 50) * scaleFactor, (yCoord - 30) * scaleFactor, (hWidth - 170) * scaleFactor, (hHeight - 70) * scaleFactor); // window
	}
	
	
}

