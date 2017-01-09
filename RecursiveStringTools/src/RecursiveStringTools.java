import java.util.Scanner;


public class RecursiveStringTools {
	
	// Example
	public int lengthLoop(String in) {
		
		int i = 0;
		
		while(!in.equals("")) 
		{
			in = in.substring(1);
			i++;
		}
		
		return i;
		
	}
	
	public int lengthRec(String in) 
	{
		return lengthRec(in, 0);
	}
	
	private int lengthRec(String in, int i)
	{
		if(in.equals("")) // Base Case
		{
			return i;
		}
		
		else //Recursive Case
		{
			in = in.substring(1);
			i++;
			
			return lengthRec(in, i);
		}
	}


	// Example
	public void printEveryOtherLoop(String in) {
		for (int i = 0; i < in.length(); i += 2)
		{
			System.out.print(in.charAt(i));
		}
	}
	
	public void printEveryOtherRec(String in) {
		printEveryOtherRec(in, 0);
	}
	
	private void printEveryOtherRec(String in, int i) {
		if(i >= in.length()) // Base Case
		{
			// you can get rid of base case because method doesn't do anything
			// when you hit the end of a string
		}
		
		else
		{
			System.out.print(in.charAt(i));
			i += 2;
			
			printEveryOtherRec(in, i);
		}
	}
	
	
	// Example
	public boolean equalsLoop(String in1, String in2) {
		if(in1.length() != in2.length())
		{
			return false;
		}
		
		for (int i = 0; i < in2.length(); i++)
		{
			char c1 = in1.charAt(i);
			char c2 = in2.charAt(i);
			if (c1 != c2)
				return false;
		}
		
		return true;
	}
	
	public boolean equalsRec(String in1, String in2) {
		if(in1.length() != in2.length())
		{
			return false;
		}
		
		return equalsRec(in1, in2, 0);
	}
	
	private boolean equalsRec(String in1, String in2, int i) {
		
		if(i >= in2.length()) //First Base Case
		{
			return true;
		}
		
		else if(in1.charAt(i) != in2.charAt(i)) // Second Base Case 
		{
			return false;
		}
		
		else
		{
			i++;
			return equalsRec(in1, in2, i);
		}
			
		
	}
	
	
	// Exercise #1
	public boolean matches(String in1, String in2) {
		in1.
		
		
		return false;
	}
	
	

	// Exercise #2
	public boolean isPalindrome(String in) {
		return true;
	}
	
	

	// Exercise #3
	public void printPermutations(String in) {

	}
	
	
	
	public String piglatinate(String in) {
		return "";
	}
	
	
	
	public static void main(String[] args) {
		Scanner kboard = new Scanner(System.in);
		System.out.println("Please enter a string!");
		String s = kboard.nextLine();
	
		RecursiveStringTools runner = new RecursiveStringTools();
		String out = runner.length(s) + "";
		System.out.print("\n\nThe result is --> " + out + "\n\n");
	}
}
