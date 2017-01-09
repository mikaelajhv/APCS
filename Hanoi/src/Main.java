import java.util.Scanner;

public class Main {
	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
				
		System.out.println("How many disks would you like to solve for? : ");
		int d = scan.nextInt();
		HanoiPuzzle tower = new HanoiPuzzle(d);
		tower.printHanoiSolution(d);
	}

}
