import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;

public class ZBug extends Bug{
	
	 private int steps;
	 private int sideLength;
	 private int zSide; //represents which line of the letter Z bug is moving along
	 
	 public ZBug(int length)
	 {
		 zSide = 0; //0 = line 1, 1 = line 2, 2 = line 3
		 steps = 0;
		 sideLength = length;
		 setDirection(Location.EAST);
	 }
	 
	 public void act()
	 {
		 if(steps < sideLength && canMove() && zSide == 0)
		 {
			 move();
			 steps++;
	     }
		 else if(steps == sideLength && zSide == 0)
		 {
			 setDirection(Location.SOUTHWEST);
			 move();
			 steps = 0;
			 zSide++;
			 steps++;
		 }
		 else if(steps < sideLength && canMove() && zSide == 1)
		 {
			 move();
			 steps++;
		 }
		 else if(steps == sideLength && zSide == 1)
		 {
			 setDirection(Location.EAST);
			 move();
			 steps = 0;
			 zSide++;
			 steps++;
		 }
		 else if(steps < sideLength && canMove() && zSide == 2)
		 {
			 move();
			 steps++;
		 }
		 else if(!canMove())
		 {
			 turn();
			 move();
		 }
		 
		 /*
		 else if(canMove() && steps < sideLength * 2)
		 {
			 
		 } */
		 
		 
		 
		 /*
	        if (steps < sideLength && canMove())
	        {
	            move();
	            steps++;
	        }
	        else
	        {
	            turn();
	            turn();
	            sideLength++;
	            steps = 0;
	        } */
		 
		 
		 
		 
	 }

}