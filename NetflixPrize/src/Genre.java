import java.util.ArrayList;

public class Genre {
	
	// FIELDS
	/*
	public static final int ACTION = 1;
	public static final int ADVENTURE = 2;
	public static final int ANIMATION = 3;
	*/
	private ArrayList<String> genres;
	
	public Genre(ArrayList<String> genres)
	{
		this.genres = genres;
	}
	
	
	// METHODS
	
	//returns genre(s) in string format
	public String toString()
	{
		return genres.toString();
	}
	
	//adds a genre to the movie's listed genres
	public void addGenre()
	{
		
	}
	

}