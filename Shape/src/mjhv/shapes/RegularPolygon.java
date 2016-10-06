package mjhv.shapes;
import mjhv.shapes.Circle;
import mjhv.shapes.Line;
import processing.core.PApplet;

/**
 * This class models a pentagon, a regular pentagon
 * 
 * @author mvalenciano825
 * @version 9/29/2016
 */
public class RegularPolygon extends Shape{
	
	//some fields to think about:
	 private int numSides; //number of sides
	 private double sideLength; //length of side
	 private double bigR, smallR; //radius of outside/inner circle
	 private Circle outsideCirc, insideCirc; //circumscribed/inscribe circles
	 private Line[] sides; //array of line objects for each side
	 
	public RegularPolygon()
	{
		super(0, 0);
	}
	
	public RegularPolygon(double x, double y, int numSides, double sideLength, double bigR, double smallR)
	{
		super(x, y);
		
		this.numSides = numSides;
		this.sideLength = sideLength;
		this.bigR = bigR;
		this.smallR = smallR;
		
	}
	
	/**
	 * This method calculates the vertex angle of the regular pentagon
	 * 
	 * @return double angle value in degrees of the pentagon's vertex
	 */
	public double calcVertexAngle()
	{
		return 108; //sum of angles in a regular pentagon = 540 degrees 
	}
	
	/**
	 * This method calculates the perimeter of the pentagon
	 * 
	 * @return double perimeter of the pentagon
	 */
	public double calcPerimeter()
	{
		double perimeter = numSides * sideLength;
		return perimeter;
	}
	
	/**
	 * This method calculates the pentagon's area
	 * 
	 * @return double value of the pentagon's area
	 */
	public double calcArea()
	{
		double area = (1/4) * 
							  (Math.sqrt(5 * (5 + 2*(Math.sqrt(5.0)) ) * 
							  (Math.pow(sideLength, 2)) ));
		return 0;
	}
	
	public void setBigR(double radius)
	{
		bigR = radius;
	}
	
	public void setSmallR(double radius)
	{
		smallR = radius;
	}
	
	public void draw(PApplet drawer)
	{
		super.draw(drawer);
		
		drawer.ellipse((float)x, (float)y, (float)bigR, (float)bigR);
		drawer.ellipse((float)x, (float)y, (float)smallR, (float)smallR);
		
	}
	

}
