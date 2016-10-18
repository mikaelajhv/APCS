
import java.util.Scanner;

public class Main{
	
	 public static void main(String[] args)
	  {
		 Scanner scan = new Scanner(System.in);	
		 
		 System.out.println("Enter marital status (1 = single, 2 = married): ");
		 int maritalStat = scan.nextInt();
		 
		 System.out.println("Enter taxable income: ");
		 double income = scan.nextDouble();
		 
		 Tax fed = new Tax(income, maritalStat);
		 double fedTax = fed.calcTax(income, maritalStat);
		 
		 System.out.println("Your federal tax is: $" + fedTax);
	  }

}
