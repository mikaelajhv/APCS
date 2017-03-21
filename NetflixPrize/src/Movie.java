import java.util.ArrayList;

public class Movie {
	
	// FIELDS
	private String title;
	private String genres;
	private int id, imdb, tmdb;
	private double rating;
	
	
	public Movie(int ID, String title, String genres)
	{
		this.title = title;
		this.genres = genres;
		id = ID;
	}
	
	// FOR LINKS
	public Movie(int ID, int imdb, int tmdb)
	{
		id = ID;
		this.imdb = imdb;
		this.tmdb = tmdb;
	}
	
	public Movie(int ID, int imdb)
	{
		id = ID;
		this.imdb = imdb;
	}
	public Movie(int ID)
	{
		id = ID;
	}
	
	// METHODS
	
	//returns movie's information in String form
	public String toString() 
	{
		String movie = "" + id + title + genres;
		return movie;
	}
	
	public String linkToString()
	{
		String link = "" + id + ", " + imdb + ", " + tmdb;
		return link;
	}
	
	public int getID()
	{
		return id;
	}
	
	public int getImdb()
	{
		return imdb;
	}
	
	public int getTmdb()
	{
		return tmdb;
	}
	
	private ArrayList<String> genreToList(String genres)
	{	
		int beginning = 0;
		ArrayList<String> g = new ArrayList<String>();
		int i = 0;
	
		for(i = 1; i < genres.length(); i++)
		{
			if(genres.charAt(i) == '|' || (i == genres.length()) )
			{
				g.add(genres.substring(beginning, i));
				//System.out.println(parts.size());
				beginning = i+1;
			}
		}
		g.add(genres.substring(beginning, genres.length()));
		
		return g;
		
		//return gList;
	}
	
	public ArrayList<String> getGenres()
	{
		ArrayList<String> list = genreToList(genres);
		
		return list;
	}
	

	/*
	//takes in a User's ID and checks to see if the movies are the same movie
	public boolean same(String ID)
	{
		
	}
	
	//takes in a rating (from 0.0 - 5.0 in increments of 0.5) 
	//and returns a new averaged Rating of the movie
	public Rating rate(double rating)
	{
		
	}
	*/

}
