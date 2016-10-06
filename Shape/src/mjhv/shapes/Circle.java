package mjhv.shapes;

import processing.core.PApplet;

/**
 * This class represents a circle 
 * 
 * @author mvalenciano825
 * @version 9/15/2016
 */

public class Circle extends Shape{
	
	private double diam;
	
	
	/**
	 * This constructor creates a new instance of a Circle object
	 * with x and y as the coordinates of the center of the circle
	 * and with a diameter. 
	 * 
	 * @param x x-coordinate of the center
	 * @param y y-coordinate of the center
	 * @param diameter diameter of the circle
	 */
	public Circle(double x, double y, double diameter)
	{
		super(x, y);
		diam = diameter;
	}

	
	/**
	 * This method calculates and returns the perimeter of the circle
	 * 
	 * @return circle's perimeter
	 */
	public double calcPerimeter()
	{
		double perimeter = 2 * Math.PI * (diam);
		
		return perimeter;
	}
	
	/**
	 * This method calculates and returns the cirle's area
	 * 
	 * @return circle's area
	 */
	public double calcArea()
	{
		double area = Math.PI * (diam/2);
		
		return area;
	}
	
	/**
	 * This method determines if a specified point is within the circle 
	 * and returns false if the point is outside of the circle
	 * 
	 * @param x x-coordinate of specified point
	 * @param y y-coordinate of specified point
	 * @return true if point (x,y) is inside the circle and false if (x,y) is outside the circle
	 */
	public boolean isPointInside(double x, double y)
	{
		//equation for finding distance of point to center 
		double distance = Math.sqrt(Math.pow((x - super.x), 2) + Math.pow((y - super.y), 2));
		
		if(distance < (diam/2) || distance == (diam/2))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * This method draws a new instance of a Circle object 
	 * 
	 * @param marker PApplet used to draw the circle
	 * @pre marker must not be null and appropriate settings should have been selected 
	 */
	public void draw(PApplet marker)
	{
		marker.ellipse((float)super.x, (float)super.y, (float)diam, (float)diam);
	}
	
}
