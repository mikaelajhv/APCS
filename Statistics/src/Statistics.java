import java.util.ArrayList;
import java.util.Arrays;

public class Statistics {

	private int[] data;
	private int filled;
	
	public Statistics(int max, String name)
	{
		data = new int[max];
		ArrayReader a = new ArrayReader(name);
		filled = a.fillArray(data); 
	}
	
	/*
	public void read(String name)
	{
		ArrayReader a = new ArrayReader(name);
		a.fillArray(data);
	}
	*/
	
	public double avg(int[] data)
	{
		double sum = 0;
		double avg = 0;
		
		for(double e: data)
		{
			sum = sum + e;
		}
		avg = sum/filled;
		double roundedAvg = (double)Math.round(avg * 1000d) / 1000d;
		
		return roundedAvg;
	}
	
	public double sDev(int[] data)
	{
		double average = avg(data);
		double sumDiff = 0;
		
		for(int i = 0; i <= filled - 1; i++)
		{
			double e = Math.pow((Math.abs(average - data[i])), 2);
			sumDiff += e;
		}
		double stDev = Math.sqrt(sumDiff/999);
		double roundedSDev = (double)Math.round(stDev * 100d) / 100d;
		
		return roundedSDev;
	}
	
	public String mode(int[] data)
	{
		ArrayList<String> modes = new ArrayList<String>(); 
		int modeCount = 0; //frequencies of the mode
		
		for(int i = 0; i <= filled - 1; i++) //goes through array
		{
			int currentCount = 0; //frequencies for current mode that's being checked
			for(int j = 0; j <= filled - 1; j++)
			{
				if(data[i] == data[j]) //compares/checks the equivalence of the 2 values
				{
					currentCount++;
				}
			}
						
			if(currentCount > modeCount) //if frequencies of current mode surpass old mode
			{
				modes.clear(); //clears all previous modes in list
				modes.add("" + data[i]); //adds the next frequent value
				modeCount = currentCount; 
			}
			else if(modeCount == currentCount) //checks for if more than 1 mode in array is present
			{
				if(modes.contains(data[i] + "") == false) //checks if value is already in ArrayList, doesn't add again if it is
				{
					modes.add("" + data[i]); 
				}
			}
		}
		
		return modes.toString();
		
	}
	
	public void printSolutions()
	{
		System.out.println("average: " + avg(data));
		System.out.println("standard deviation: " + sDev(data));
		System.out.println("mode: " + mode(data));
	}
	
}
