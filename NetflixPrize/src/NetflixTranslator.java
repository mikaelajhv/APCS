import java.util.ArrayList;
import java.util.Arrays;

public class NetflixTranslator {
	
	//Look through the line, extract each piece of data
			//convert data to appropriate types
			//pass into the constructor
			
			
	//extracts each piece of data in the line by commas
	
	public static ArrayList<String> getPieces(String line)
	{
		int beginning = 0;
		ArrayList<String> parts = new ArrayList<String>();
		int i = 0;
	
		for(i = 1; i < line.length(); i++)
		{
			if(line.charAt(i) == ',' || (i == line.length()) )
			{
				parts.add(line.substring(beginning, i));
				//System.out.println(parts.size());
				beginning = i+1;
			}
		}
		parts.add(line.substring(beginning, line.length()));
		
		return parts;
	}
	
	public static Movie stringToMovie(String line)
	{	
		ArrayList<String> parts = getPieces(line);
		//System.out.println(parts);
		int id = Integer.parseInt(parts.get(0));
		String title = parts.get(1);
		String genres = parts.get(2);
		Movie m = new Movie(id, title, genres);
		
		return m;
	}
	
	public static Movie stringToLink(String line)
	{
		// SOME MOVIES MIGHT NOT HAVE IMDB OR TMDB LINKS
		ArrayList<String> parts = getPieces(line);
	
		//System.out.println(parts + " if");
		
		int id = Integer.parseInt(parts.get(0));
		int imdb = Integer.parseInt(parts.get(1));
		Movie link = new Movie(id, imdb);
		
		if(parts.get(2).length() != 0)
		{
			int tmdb = Integer.parseInt(parts.get(2));
			link = new Movie(id, imdb, tmdb);
		}

		//System.out.println("*" + parts.get(2) + "* else" + " size: " + parts.size());
		return link;
	}
	
	public static Rating stringToRating(String line)
	{
		ArrayList<String> parts = getPieces(line);
		int user = Integer.parseInt(parts.get(0));
		int movie = Integer.parseInt(parts.get(1));
		double rating = Double.parseDouble(parts.get(2));
		long time = Integer.parseInt(parts.get(3));
		Rating r = new Rating(user, movie, rating, time);
		
		return r;
	}
	
	public static Tag stringToTag(String line)
	{
		ArrayList<String> parts = getPieces(line);
		int user = Integer.parseInt(parts.get(0));
		int movie = Integer.parseInt(parts.get(1));
		String message = parts.get(2);
		long time = Integer.parseInt(parts.get(3));
		Tag t = new Tag(user, movie, message, time);
		
		return t;
	}
	

}
