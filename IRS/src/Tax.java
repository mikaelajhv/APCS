/* number of relational operators
 * a)  4
 * b)  9
 * c)  4
 * d)  5
 */


public class Tax {
	
	private double income;
	private int maritalStat;
	
	public Tax(double income, int maritalStat)
	{
		this.income = income;
		this.maritalStat = maritalStat;
	}

	public double calcTax(double money, int maritalStat)
	{
		income = money;
		this.maritalStat = maritalStat;
		double fed = 0;
		
		if(maritalStat == 1)
		{
			if(income > 0 && income < 27050)
			{
				fed = income * 0.015;
			}
			
			if(income > 27050 && income < 65550)
			{
				fed = 4057.50 + (0.275 * (income - 27050));
			}
			
			if(income > 65550 && income < 136750)
			{
				fed = 14645.00 + (0.305 * (income - 65550));
			}
			
			if(income > 136750 && income < 297350)
			{
				fed = 36361.00 + (0.355 * (income - 136750));
			}
			
			if(income > 297350)
			{
				fed = 93374.00 + (0.391 * (income - 297350));
			}
		}
		
		// taxable income if married 
		if(maritalStat == 2)
		{
			if (income > 0 && income < 45200)
			{
				fed = income * 0.15;
			}
			
			if(income > 45200 && income < 109250)
			{
				fed = 6780.00 + (0.275 * (income - 45200));
			}
			
			if(income > 109250 && income < 166500)
			{
				fed = 24393.75 + (30.5 * (income - 109250));
			}
			
			if(income > 166500 && income < 297350)
			{
				fed = 41855.00 + (0.355 * (income - 166500));
			}
			
			if(income > 297350)
			{
				fed = 88306.00 + (0.391 * (income - 297350));
			}
		}
		
		return fed;
	
		
	}

}
