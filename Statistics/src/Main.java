
public class Main {
	
	public static void main(String[] args)
	{
		/*
		Statistics s = new Statistics(10000); //10,000 is the max num
		s.read("numbers.txt");
		System.out.println("NUM STATS");
		s.printSolutions();
		*/
		System.out.println();
		
		Statistics s2 = new Statistics(10000);
		s2.read("numbers2.txt");
		//System.out.println("filled: " + s2.filled);
		//s2.printData();
		System.out.println("NUM 2 STATS");
		s2.printSolutions();
		s2.printData();
		//System.out.println("filled: " + s2.filled);
		
		System.out.println();
		
		Statistics s3 = new Statistics(10000);
		s3.read("numbers3.txt");
		//s3.printData();
		System.out.println("NUM 3 STATS");
		s3.printSolutions();
		s3.printData();

		
		System.out.println();
		/*
		Statistics s4 = new Statistics(10000);
		s4.read("numbers4.txt");
		System.out.println("NUM 4 STATS");
		
		s4.printSolutions(); 
		
		*/
		}

}
