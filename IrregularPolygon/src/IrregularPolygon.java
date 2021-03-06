import java.awt.geom.*;  // for Point2D.Double
import java.util.ArrayList;      // for ArrayList
import processing.core.PApplet;	// for Processing

public class IrregularPolygon {
   private ArrayList <Point2D.Double> myPolygon;
    
   // constructors
   public IrregularPolygon() 
   {   
	   myPolygon = new ArrayList<Point2D.Double>();
   }
   
   // public methods
   public void add(Point2D.Double aPoint) 
   {
	   myPolygon.add(aPoint);
   }
   
  

   public void draw(PApplet marker) 
   {
	   if(myPolygon.size() > 2)
	   {
		   for(int i = 0; i < myPolygon.size()-1; i++)
		   {
			   marker.line((float)myPolygon.get(i).x, (float)myPolygon.get(i).y, 
					   (float)myPolygon.get(i+1).x, (float)myPolygon.get(i+1).y);
		   } 
		 marker.line((float)myPolygon.get(0).x, (float)myPolygon.get(0).y, 
		   (float)myPolygon.get(myPolygon.size()-1).x, (float)myPolygon.get(myPolygon.size()-1).y);
	   }
	   
	   
   }

   public double perimeter() 
   {
	   double perimeter = 0;
	   if(myPolygon.size() > 2)
	   {
		   for(int i = 0; i < myPolygon.size()-1; i++)
		   {
			   perimeter += myPolygon.get(i).distance(myPolygon.get(i+1));
		   }
		   perimeter += myPolygon.get(0).distance(myPolygon.get(myPolygon.size()-1));
	   }
	   return perimeter;
   }

   public double area() 
   {
	   double sums = 0;
	   double diff = 0;
	   
	   if(myPolygon.size() > 2)
	   {
		   for(int i = 0; i < myPolygon.size()-1; i++)
		   {
			   //area += ((myPolygon.get(i).x * myPolygon.get(i+1).y) - (myPolygon.get(i).y * myPolygon.get(i+1).x));
			   sums += (myPolygon.get(i).x * myPolygon.get(i+1).y);
			   diff -= (myPolygon.get(i).y * myPolygon.get(i+1).x);
		   }
		   sums += myPolygon.get(myPolygon.size()-1).x * myPolygon.get(0).y;
		   diff -= myPolygon.get(myPolygon.size()-1).y * myPolygon.get(0).x;
	   }
	 
	   double area = Math.abs((sums + diff)/2);
	   return area;
   }
   
   public void moveLeft()
   {
	   for(int i = 0; i < myPolygon.size(); i++)
	   {
		   myPolygon.get(i).x -= 10;
	   }
   }
   
   public void moveRight()
   {
	   for(int i = 0; i < myPolygon.size(); i++)
	   {
		   myPolygon.get(i).x += 10;
	   }
   }
   
   public void moveUp()
   {
	   for(int i = 0; i < myPolygon.size(); i++)
	   {
		   myPolygon.get(i).y -= 10;
	   }
   }
   
   public void moveDown()
   {
	   for(int i = 0; i < myPolygon.size(); i++)
	   {
		   myPolygon.get(i).y += 10;
	   }
   }
   
   public void move()
   {
	   
   }
   
   
}
