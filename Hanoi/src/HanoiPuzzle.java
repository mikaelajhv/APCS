/*
 * Iterations for :
 * 1: 1
 * 2: 3
 * 3: 7
 * 4: 15
 * 5: 31
 * 6: 63
 * 7: 127
 * 8: 255
 * 9: 511
 * 10: 1023
 * 
 * equation: 2^n - 1
 */

public class HanoiPuzzle {
	
	private int disks;
	private int iterations;
	
	public HanoiPuzzle(int d)
	{
		disks = d;
	}
	
	public void printHanoiSolution(int num)
	{
		solveHanoi(num, "peg 1", "peg 2", "peg 3");
		System.out.println("iterations: " + iterations);
	}
	
	private void solveHanoi(int num, String start, String other, String end)
	{
		disks = num;
		
		iterations++;
		if(num == 1)
		{
			System.out.println("Move top disk from " + start + " to " + end);
		}
		else
		{
			solveHanoi(num - 1, start, end, other);
			System.out.println("Move top disk from " + start + " to " + end);
			solveHanoi(num - 1, other, start, end);
		}
		
	}

}
