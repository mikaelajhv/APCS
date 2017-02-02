import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class ResizableArray<E> {
	
	// FIELDS
	private E[] data;
	private int size; //length = # of variable, size = pieces of valid data
	private static final int INITIAL_LENGTH = 20;
	
	//CONSTRUCTORS
	public ResizableArray(int length)
	{
		//data = (E)new int[length];
		data = (E[])new Object[length];
		size = 0;
	}
	
	public ResizableArray()
	{
		this(INITIAL_LENGTH);
	}
	
	// METHODS
	
	private void resize()
	{
		data = Arrays.copyOf((E[])data, size * 2);
		//data = (E[])new Object[data.length + 50];
	}
	
	//1ST WAVE METHODS (most important)
	public void add(E value)
	{	
		if(size == data.length)
		{
			resize();
		}
		
		data[size] = value;
		size++;
		
	}
	
	public void insert(int index, E x) //think opposite of remove, insert
	{
		if(index > size)
		{
			throw new IllegalArgumentException("Bad index: " + index);
		}
		
		while(size == data.length)
		{
			resize();
		}
		
		size += 1;
		for(int i = size-1; i > index; i--)
		{
			data[i] = data[i - 1];
		}
		
		data[index] = x;
	}

	public String toString()
	{
		String dataList = "";
		
		for(int i = 0; i < size; i++)
		{
			String value = "" + data[i] + " ";
			dataList+= value;
		}
			
		return dataList;
	}
	
	public E remove(int index) //returns what is removed at the index of i
	{
		E out = data[index];
		
		if(index > size)
		{
			throw new IllegalArgumentException("Bad index: " + index);
		}
		
		for(int i = index; i < size - 1; i++)
		{
			data[i] = data[i + 1];
		}
		size--;

		return out;
	}

	public int size() //returns size of array
	{
		return size;
	}


	//2ND WAVE METHODS (2nd most important)
	public int get(int i)
	{
		return (int)data[i];
	}

	public void set(int i, E x) //changes spot in array
	{
		data[i] = x;
	}
	
	
	public void sort() //look up comparable class (Java API)
	{
		//Arrays.sort(data, 0, size);
		
		/*
		for(int i = 0; i < size; i++)
		{
		 	Comparable<E> x = (Comparable)data[i];
		 	Comparable<E> y = (Comparable)data[i+1];
		 	
		 	if(x.compareTo(y) > 0) //x > y
		 	{
		 		
		 	}
		 	
		 	else if(x.compareTo(y) < 0) //x smaller than y
		 	{
		 		
		 	}
		 	
		 	else //x = y
		 	{
		 	
		 	}
		}	
		*/
	}
	
	public int indexOf(E value)
	{	
		int index = 0;
		for(int i = 0; i < size; i++)
		{
			if(data[i] == value)
			{
				index = i;
			}
		}
		return index;
	}

	/*
	public E[] toArray()
	{
		for
	}
*/
	public boolean equals(ResizableArray<E> other)
	{
		String dataString = data.toString();
		String otherString = other.toString();
		
		if(dataString.equals(otherString))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	/*
	//3rd wave
	public void remove(int from, int to) //removes everyting in between 2 spots

	public void removeAll(int x)

	public int countValue(int x)
	
	public void shiftRight() // and shift left
	
	public ResizableArray subArray(int from, int to)

	*/
	
	
	

}