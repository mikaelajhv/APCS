import java.util.ArrayList;

public class Rating {
	
	// FIELDS
	private int user;
	private int movie;
	private double rating;
	private long timeStamp;
	
	public Rating(int user, int movie, double rating, long time)
	{
		this.user = user;
		this.movie = movie;
		this.rating = rating;
		timeStamp = time;
	}

	
	// METHODS
	
	//returns the Rating as a String
	public String toString()
	{
		String stars = "" + user + ", " + movie + ", " + rating + ", " + timeStamp;
		return stars;
	}
	
	//takes in the time stamp, user, and movie and 
	//returns the rating made
	
	public int getUserID()
	{
		return user;
	}
	
	public int getMovieID()
	{
		return movie;
	}
	
	public double getRating()
	{
		return rating;
	}
	
	
	

}
