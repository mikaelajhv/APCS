import java.util.Scanner;

public class CheckMail {
	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in); 
		
		System.out.println("Enter dimension 1 of the package: ");
		int num = scan.nextInt();
		
		System.out.println("Enter dimension 2 of the package: ");
		int num2 = scan.nextInt();
		
		System.out.println("Enter dimension 3 of the package: ");
		int num3 = scan.nextInt();
		
		System.out.println("Enter package's weight: ");
		int num4 = scan.nextInt();
		
		Package mail = new Package(num, num2, num3, num4);
		int out = mail.calcStat(num, num2, num3, num4);
		
		String status = "";
		if(out == 0)
		{
			status = "acceptable";
		}
		
		if(out == 1)
		{
			status = "too heavy";
		}
		
		if(out == 2)
		{
			status = "too large";
		}
		
		if(out == 3)
		{
			status = "too large and too heavy";
		}
		
		System.out.println("The package is " + status);
		
	}

}
