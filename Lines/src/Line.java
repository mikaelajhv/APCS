import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class Line {
	
	private double xStart, xEnd, yStart, yEnd, temp;

	public Line(double x1, double y1, double x2, double y2)
	{
		xStart = x1;
		yStart = y1;
		xEnd = x2;
		yEnd = y2;
		temp = 0.0;

	}
	
	public void setPoint(double x2, double y2)
	{
		xEnd = x2;
		yEnd = y2;
	}
	
	public void draw(DrawingSurface drawer)
	{
		drawer.line((float)xStart, (float)yStart, (float)xEnd, (float)yEnd);
	}
	
	public boolean intersects(Line other)
	{
		double x1 = this.xStart;
		double x2 = this.xEnd;
		double y1 = this.yStart;
		double y2 = this.yEnd;
		double x3 = other.xStart;
		double x4 = other.xEnd;
		double y3 = other.yStart;
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
	
	
	
	public Point2D.Double intersectionPt(Line other)
	{
		double pDenom = ((this.xStart - this.xEnd)*(other.yStart - other.yEnd)) - ((this.yStart - this.yEnd)* (other.xStart - other.xEnd));
		
		if(Double.compare(pDenom, 0.0) == 0)
		{
			return null;
		}
		
		double pX = ((((this.xStart*this.yEnd) - (this.yStart*this.xEnd))*(other.xStart - other.xEnd)) -
							((this.xStart - this.xEnd)*((other.xStart*other.yEnd) - (other.yStart*other.xEnd))))/ pDenom;
		
		double pY = ((((this.xStart*this.yEnd) - (this.yStart*this.xEnd))*(other.yStart - other.yEnd)) -
							((this.yStart - this.yEnd)*((other.xStart*other.yEnd) - (other.yStart*other.xEnd))))/ pDenom;
		
		return new Point2D.Double(pX, pY);
	}
	
}
