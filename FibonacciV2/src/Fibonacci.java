/**
 * @(#)Fibonacci.java
 *
 *
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Fibonacci {

	//20th Fibonacci number is 6765
    public static long computeFibonacci(int x) {
    	if(x < 0)
    	{
    		throw new IllegalArgumentException("parameter must be positive: " + x);
    	}
    	if (x <= 1) {
    		return x;
    	} else {
    		long answer = computeFibonacci(x-2) + computeFibonacci(x-1);
    		return answer;
    	}

    }

	public static void main (String[] args) {
		/*
		try
		{
			Scanner kboard = new Scanner (System.in);
			System.out.print("Which fibonacci number would you like to find? --> ");
			int x = kboard.nextInt();
			int answer = computeFibonacci(x);
			System.out.println ("The " + x + " fibonacci number is " + answer + ".");
		}
		catch(InputMismatchException exception)
		{
			System.out.println("Must be an integer!");
		}
		catch(StackOverflowError exception)
		{
			System.out.println("Enter a smaller number!");
		}
		*/
		
		
		Scanner kboard = new Scanner (System.in);
		int x = 0;
		long answer = 0;
		boolean success = false;
		
		do{
		
			try {
				String str = kboard.nextLine();
				answer = computeFibonacci(x);
				x = Integer.parseInt(str);
				success = true;
			}
			catch(NumberFormatException e){
				System.out.println("The input isn't an integer.");
			}
			catch(IllegalArgumentException e){
				System.out.println("The input must be positive!");
			}
			catch(StackOverflowError e){
				System.out.println("Error: Number is too large!");
			}
			catch(InputMismatchException exception){
				System.out.println("Must be an integer!");
			}
				
		} 
		while(!success);
		
		System.out.println ("The " + x + " fibonacci number is " + answer + ".");
	}

}



