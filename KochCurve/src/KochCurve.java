import processing.core.PApplet;


/**
  @(#)KochCurve.java


  @author
  @version
*/

public class KochCurve {
	// TO DO
	// fields = initial length
	//local variables = as it changes
	
	private float length;
	private int level, x, y;

    public KochCurve(int level, float length)
    {
    	// TO DO
    	this.level = level;
    	this.length = length;
    	x = 100;
    	y = 200;
    	/*
    	angle = 0;
    	x = 40;
    	y = 60;
    	
    	x2 = (int) (x + length);
    	y2 = (int) (y + length); */
    	
    }
    
    // public draw method passes in all initial values
    public void draw(PApplet marker)
    {
    	drawKochCurve(new MemoryDrawer(marker, x, y, 0), length, level);
    }


    private void drawKochCurve(MemoryDrawer marker, float length, int lev)
    {
    	// TO DO
    	level = lev;
    	this.length = length;
    	
    	/*
    	if level < 1 then
    	  Move forward length pixels --> draws a line at specified angle, w/ specified length starting at x, y
    	else
    	  Draw a k-1 level Koch curve with segments 1/3 the current length
    	  Turn left 60 degrees
    	  Draw a k-1 level Koch curve with segments 1/3 the current length
    	  Turn right 120 degrees
    	  Draw a k-1 level Koch curve with segments 1/3 the current length
    	  Turn left 60 degrees
    	  Draw a k-1 level Koch curve with segments 1/3 the current length
    	 	*/
    
    	if(lev == 0) //base case
    	{
    		marker.drawForward(length);
    	}
    
    	else
    	{	
    		drawKochCurve(marker, length/3, lev-1);
    		marker.turn(60.0);
    		//marker.setDirection(60.0);
    		drawKochCurve(marker, length/3, lev-1);
    		marker.turn(-120.0);

    		drawKochCurve(marker, length/3, lev-1);
    		marker.turn(60.0);
    		
    		drawKochCurve(marker, length/3, lev-1);
    	}
    }

}
