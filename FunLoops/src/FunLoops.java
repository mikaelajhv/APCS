import java.util.Arrays;
import java.util.Scanner;


/*
 n						Time(ms)					Iterations
 
1															1	
2															29
3															
4
5
6
7
8
9
10

Fibonacci (Recursive)
 n						Time(ms)					Iterations
 
 5
 10
 15
 20
 25
 30
 35
 40
 45
 
 Fibonacci (Looping)
 n						Time(ms)					Iterations
 
 5
 10
 15
 20
 25
 30
 35
 40
 45






Why is the looping version (fibonacci methods)  faster?:
	When the recursive method runs once, it technically runs another 2 times,
	and then more times within those method calls. This is what makes the 
	recursive method run so much slower in comparison to the looping fibonacci
	method

 */

public class FunLoops {

	private static long iterations = 0;
	
	public FunLoops(int a, int b)
	{

	}
	
	
	public long factorial(long n)
	{
		
		if(n == 0) // base case
		{
			return 1;
		}
		
		else // recursive case 
		{
			long prev = factorial(n - 1);
			return n * prev;
		}
		
	}
	
	public static int findLCM(int a, int b)
	{
		//iterations = 0;
		int larger;
		int smaller;
		
		if(a > b)
		{
			larger = a;
			smaller = b;
		}
		else
		{
			larger = b;
			smaller = a;
		}
		
		int i;
		for(i = larger; i %smaller == 0; i += larger)
		{
			iterations++;
		}
		return i;
		
	}
	
	public static long[] findMagSq(int n)
	{
		iterations = 0;
		long[] answers = new long[n];
		int numFound = 0;
		long count = 1;
		
		while(n > numFound)
		{
			long sum = 0;
			long x = 0;
			
			if(Math.pow((int)Math.sqrt(count), 2) == count) //tests if perfect square (make more efficient)
			{
				while(sum < count) 
				{
					x++;
					sum += x;
					iterations++;
				}
				
				if(sum == count) //tests if triangular num
				{
					answers[numFound] = count;
					numFound++;
				}
				
			}
			count++;
		}
		return answers;
	}
	
	//fibonacci recursion 
	public static int fibonacci(int n)
	{
		iterations++; // method is the loop, add 1 to iterations at the very beginning
		
		if(n <= 1) //base case
		{
			return n;
		}
		else // recursive case
		{
			return n = fibonacci(n-1) + fibonacci(n-2);
		}
	}
	
	
	public static long fibonacciLoop(long n)
	{
		iterations = 0;
		
		long prev = 1, prev2 = 0, fib = 1;
		
		while(n >= 0)
		{
			iterations++;
			
			fib = prev - prev2;
			
			prev2 = prev;
			prev = fib;
			
			n--;
		}
		return fib;
	}
	
	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		/*
		 * test cases for findLCM
		System.out.println("15, 18 LCM = " + findLCM(15, 18) + ", iterations: " + iterations);
		System.out.println("40, 12 LCM = " + findLCM(40, 12) + ", iterations: " + iterations);
		System.out.println("2, 7 LCM = " + findLCM(2, 7) + ", iterations: " + iterations);
		System.out.println("100, 5 LCM = " + findLCM(100, 5) + ", iterations: " + iterations);
		System.out.println("2, 18 LCM = " + findLCM(15, 18) + ", iterations: " + iterations);
		*/
		
		//System.out.println("\n\n\n");
		
		
		//System.out.println("1: " + Arrays.toString(findMagSq(1)) + ", iterations: " + iterations);
		//System.out.println("10: " + Arrays.toString(findMagSq(10)) + "\n iterations: " + iterations);
		/*
		System.out.println("3: " + Arrays.toString(findMagSq(3)) + "\n iterations: " + iterations);
		System.out.println("4: " + Arrays.toString(findMagSq(4)) + "\n iterations: " + iterations);
		System.out.println("5: " + Arrays.toString(findMagSq(5)) + "\n iterations: " + iterations);
		System.out.println("6: " + Arrays.toString(findMagSq(6)) + "\n iterations: " + iterations);
		System.out.println("7: " + Arrays.toString(findMagSq(7)) + "\n iterations: " + iterations);
		System.out.println("8: " + Arrays.toString(findMagSq(8)) + "\n iterations: " + iterations);
		System.out.println("9: " + Arrays.toString(findMagSq(9)) + "\n iterations: " + iterations); 
		*/
		
		/*
		for(int i = 1; i <= 10; i++)
		{
			long start = System.currentTimeMillis(); //gives back time in milliseconds returns a long
			System.out.println( Arrays.toString(findMagSq(6)) + "\n iterations: " + iterations);
			long end = System.currentTimeMillis();
			System.out.println("Run Time: " + (end - start));
		} */
		
		//long startTime = System.nanoTime(): --> gets nano seconds
		
		//System.out.println("\n\n\n");
		
		
		for(int i = 5; i <= 45; i+=5)
		{
			iterations = 0;
			long start = System.currentTimeMillis(); 
			System.out.println(fibonacciLoop(i) + ", iterations: " + iterations);
			long end = System.currentTimeMillis();
			System.out.println("Runtime = " + (end - start));
		}
		
		
		
	}

}
