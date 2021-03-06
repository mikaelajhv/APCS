package mjhv.shapes;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import processing.core.PApplet;

/**
 * This class represents a line segment 
 * 
 * @author mvalenciano825
 * @version 9/15/2016 
 */
public class Line extends Shape{
	
	private double xEnd, yEnd;

	/**
	 * This constructor creates a new instance of a Line object with
	 * x1 and y1 coordinates for one point of the line segment and 
	 * x2 and y2 coordinates for the endpoint of the line segment 
	 * 
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 */
	public Line(double x1, double y1, double x2, double y2)
	{
		super(x1, y1);
		
		xEnd = x2;
		yEnd = y2;
	}

	
	/**
	 * This method sets the endpoint of the line segment to the x and y
	 * coordinates passed in
	 * 
	 * @param x2
	 * @param y2
	 */
	public void setPoint(double x2, double y2)
	{
		xEnd = x2;
		yEnd = y2;
	}
	
	public Point2D.Double midpoint(Line l)
	{
		double mX = (x + this.xEnd)/2;
		double mY = (y + this.yEnd)/2;
		
		return new Point2D.Double(mX, mY);
	}
	
	/**
	 * This method draws a new instance of a Line object with
	 * xStart and yStart as one of the endpoints of the line segment 
	 * and xEnd and yEnd as the other endpoint of the line segment 
	 * 
	 * @param drawer PApplet to be used in order to draw the line segment 
	 */
	public void draw(PApplet drawer)
	{
		super.draw(drawer);
		
		drawer.line((float)x, (float)y, (float)xEnd, (float)yEnd);
	}
	
	/**
	 * This method checks to see if a line segment intersects with 
	 * another line object. Returns true if the line segments intersect
	 * and returns false if the line segments don't intersect
	 * 
	 * @param other Another line object 
	 * @return true if the line segments intersect, false if they don't intersect 
	 */
	public boolean intersects(Line other)
	{
		double x1 = x;
		double x2 = xEnd;
		double y1 = y;
		double y2 = yEnd;
		double x3 = other.x;
		double x4 = other.xEnd;
		double y3 = other.y;
		double y4 = other.yEnd;
		
		/*
		double pDenom = ((x1 - x2)*(y3 - y4)) - ((y1 - y2)*(x3 - x4));
		double pX = ((((x1*y2) - (y1*x2))*(x3*x4)) - ((x1-x2)*((x3*y4) - (y3*x4))))/ pDenom;
		double pY = ((((x1*y2) - (y1*x2))*(y3*y4)) - ((y1-y2)*((x3*y4) - (y3*x4))))/ pDenom;
		*/
		
		double pDenom = ((x1 - x2)*(y3 - y4)) - ((y1 - y2)*(x3 - x4));
		double pX = Math.abs((( Math.abs(((x1*y2) - (y1*x2)) * (x3-x4))) - Math.abs(((x1-x2) * ((x3*y4) - (y3*x4))) ) )/ pDenom);
		double pY = Math.abs((( Math.abs(((x1*y2) - (y1*x2)) * (y3-y4))) - Math.abs(((y1-y2) * ((x3*y4) - (y3*x4))) ) )/ pDenom);
		
		/*
		System.out.println("pX: " + pX);
		System.out.println("pY: " + pY);
		System.out.println("x1, x2: " + x1 + " " + x2);
		System.out.println("y1, y2: " + y1 + " " + y2);
		System.out.println("x3, x4: " + x3 + " " + x4);
		System.out.println("y3, y4: " + y3 + " " + y4);
		System.out.println("intersection distance to seg1 = " + s1DistancetoPoint);
		System.out.println("intersection distance to otherSeg = " + s2DistancetoPoint); */
	
		Point2D.Double intersect = intersectionPt(other);
		if (intersect == null )
		{
			return false;
		}
		
		/*
		double startx = Math.min(x1, x2);
		System.out.println("Math.min = " + startx + "");
		double start2x = Math.max(x3, x4);
		System.out.println("Math.max = " + start2x + "");
		double starty = Math.min(y1, y2);
		System.out.println("Math.min = " + starty + "");
		double start2y = Math.max(y3, y4);
		System.out.println("Math.max = " + start2y + ""); */
		
		
		//intersection conditions, Math.min/max makes it so orientation of x1/x2 y1/y2 doesn't matter
		//if( pX >= Math.min(x1 , x2) && pX <= Math.max(x1 , x2) && pX <= Math.max(x3, x4) && pX >= Math.min(x3, x4)  && 
		//	pY >= Math.min(y1, y2) && pY <= Math.max(y1,  y2) && pY >= Math.min(y3, y4) && pY <= Math.max(y3, y4) ) 
		//{
	
		Line2D thisLine = new Line2D.Double(x1, y1, x2, y2);
		Line2D otherLine = new Line2D.Double(x3, y3, x4, y4);
		if(thisLine.intersectsLine(otherLine) == true)
		{
			return true;
		}
		else
		{
			return false;
		}
		
		//}
		
		//else
		//{
		//	return false;
		//}
	
		
	}
	
	
	/**
	 * This method calculates the intersection point of 2 line segments
	 * and returns the x and y coordinates of the intersection point
	 * 
	 * @param other Another line object
	 * @return Point2D.Double x and y coordinates of the intersection point
	 */
	public Point2D.Double intersectionPt(Line other)
	{
		double pDenom = ((x - this.xEnd)*(other.y - other.yEnd)) - ((y - this.yEnd)* (other.x - other.xEnd));
		
		if(Double.compare(pDenom, 0.0) == 0)
		{
			return null;
		}
		
		double pX = ((((x*this.yEnd) - (y*this.xEnd))*(other.x - other.xEnd)) -
							((x - this.xEnd)*((other.x*other.yEnd) - (other.y*other.xEnd))))/ pDenom;
		
		double pY = ((((x*this.yEnd) - (y*this.xEnd))*(other.y - other.yEnd)) -
							((y - this.yEnd)*((other.x*other.yEnd) - (other.y*other.xEnd))))/ pDenom;
		
		return new Point2D.Double(pX, pY);
	}
	
}
