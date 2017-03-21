import java.util.ArrayList;

public class User {
	
	// FIELDS
	private int id;
	private ArrayList<Rating> rating;
	private String tag;
	
	public User(int ID, ArrayList<Rating> stars, String tag)
	{
		id = ID;
		rating = stars;
		this.tag = tag;
	}
	
	public User(int ID, String tag)
	{
		id = ID;
		this.tag = tag;
	}
	
	
	// METHODS
	
	//returns User info in string format
	public String toString()
	{
		return "" + id + rating + tag;
	}
	
	public boolean hasRating()
	{
		if(rating.size() != 0)
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}
	
	/*
	//checks to see if 2 Users are the same
	public boolean sameUser(int ID)
	{
		
	}
	*/
}
