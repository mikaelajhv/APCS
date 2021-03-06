
public class Package {
	
	private int dim1, dim2, dim3, weight;
	private boolean isTooHeavy = false, isTooLarge = false;
	public static final int ACCEPTABLE = 0, TOO_HEAVY = 1, TOO_LARGE = 2, TOO_LARGE_TOO_HEAVY = 3;
	
	public Package(int dim1, int dim2, int dim3, int weight)
	{
		this.dim1 = dim1;
		this.dim2 = dim2;
		this.dim3 = dim3;
		this.weight = weight;
	}
	
	public int calcStat(int dim1, int dim2, int dim3, int weight)
	{
		this.dim1 = dim1;
		this.dim2 = dim2;
		this.dim3 = dim3;
		this.weight = weight;
		int size = 0;
		
		if (weight > 70)
		{
			isTooHeavy = true;
		}
		
		if (dim1 >= dim2 && dim1 >= dim3)
		{
			size = dim1 + (2*(dim2 + dim3));
		}
		else if (dim2 >= dim1 && dim2 >= dim3)
		{
			size = dim2 + (2*(dim1 + dim3));
		}
		else
		{
			size = dim3 + (2*(dim1 + dim2));
		}
		
		if (size > 100)
		{
			isTooLarge = true;
		}
			
		if (isTooHeavy == true && isTooLarge == true)
		{
			return TOO_LARGE_TOO_HEAVY;
		}
		
		else
		{
			System.out.println("isTooHeavy = " + isTooHeavy);
			if (isTooHeavy == true)
			{
				return TOO_HEAVY;
			}
			else
			{
				if (isTooLarge == true)
				{
					return TOO_LARGE;
				}
				else
				{
					return ACCEPTABLE;
				}
			}
		}
		
	}

}
