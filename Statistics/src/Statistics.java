import java.util.ArrayList;
import java.util.Arrays;

public class Statistics {

	private int[] data;
	public int filled;
	
	public Statistics(int max)
	{
		data = new int[max];
	}
	
	public void read(String name)
	{
		ArrayReader a = new ArrayReader(name);
		filled = a.fillArray(data);
	}
	
	public void printSolutions()
	{
		System.out.println("average: " + avg(data));
		System.out.println("standard deviation: " + sDev(data));
		System.out.println("mode: " + mode(data));
		
		System.out.println();

		System.out.println("---Compact---");
		filled = compact(data);
		System.out.println("average: " + avg(data));
		System.out.println("standard deviation: " + sDev(data));
		System.out.println("mode: " + mode(data));
	}
	
	public void printData() //prints data in the array
	{
		System.out.println(Arrays.toString(data));
	}
	
	public double avg(int[] data)
	{
		double sum = 0;
		double avg = 0;
		
		for(double e: data)
		{
			sum = sum + e;
		}
		avg = sum/filled;
		//double roundedAvg = Math.round(avg);
		//return roundedAvg;
		
		return avg;
	}
	
	public double sDev(int[] data)
	{
		double average = avg(data);
		double sumDiff = 0;
		
		for(int i = 0; i < filled; i++)
		{
			double e = Math.pow((Math.abs(average - data[i])), 2);
			sumDiff += e;
		}
		double stDev = Math.sqrt(sumDiff/filled-1);
		//double roundedSDev = Math.round(stDev);
		//return roundedSDev;
		
		return stDev;
	}
	
	public String mode(int[] data)
	{
		ArrayList<String> modes = new ArrayList<String>(); //Don't use ArrayLists
		int modeCount = 0; //frequencies of the mode
		
		for(int i = 0; i < filled; i++) //goes through array
		{
			int currentCount = 0; //frequencies for current mode that's being checked
			for(int j = 0; j < filled; j++)
			{
				if(data[i] == data[j]) //compares/checks the equivalence of the 2 values
				{
					currentCount++;
				}
			}
						
			if(currentCount > modeCount) //if frequencies of current mode > old mode
			{
				modes.clear(); //clears all previous modes in list
				modes.add("" + data[i]); //adds next frequent value
				modeCount = currentCount; 
			}
			else if(modeCount == currentCount) //if more than 1 mode in array is present
			{
				if(modes.contains(data[i] + "") == false) //doesn't add again if already in list
				{
					modes.add("" + data[i]); 
				}
			}
		}
		
		return modes.toString();
		
	}
	
	
	// Precondition: data is non-null int array, size is the number of legitimate 
	// elements in data
	// Postcondition: Moves all non-zero integers to the front of the array data, leaving the 
	// order of integers otherwise unchanged. Returns the new number of legitimate data 
	// elements.
	public int compact(int[] data)
	{	
		
		System.out.println("filled (beginning) = " + filled);
		for(int i = 0; i < filled - 2; i++)
		{
			if(data[i] == 0)
			{
				for(int j = i; j < filled - 1; j++)
				{
					data[j] = data[j + 1];
				}
				data[filled - 1] = 0;
				filled--;
			}
		}
		
		if(data[filled - 1] == 0) //check to see if last value = 0
		{
			System.out.println("hello");
			return filled--;
		}
		
		System.out.println("filled = " + filled);
		return filled;
		
	} 
	
	/*
	public int compact2(int remove)
	{
		int found = 0;
		
		for(int i = 0; i < filled; i++)
		{
			if(i == 0)
			{
				for(int j = i; j < )
			}
		}
	}
	*/
	
	
	
}
