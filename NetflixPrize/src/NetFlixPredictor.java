import java.util.ArrayList;


public class NetFlixPredictor {


	// Add fields to represent your database.
	private ArrayList<Movie> movieData;
	private ArrayList<User> userData;
	
	private ArrayList<Tag> tagData;
	private ArrayList<Rating> ratingData;
	private ArrayList<Movie> linkData;
	

	/**
	 * 
	 * Use the file names to read all data into some local structures. 
	 * 
	 * @param movieFilePath The full path to the movies database.
	 * @param ratingFilePath The full path to the ratings database.
	 * @param tagFilePath The full path to the tags database.
	 * @param linkFilePath The full path to the links database.
	 */
	
	//copy all code in tester and paste in this constructor
	public NetFlixPredictor(String movieFilePath, String ratingFilePath, String tagFilePath, String linkFilePath) {
		//delete all hardcoded paths (use arguments in constructor)
		//initialize fields 
		
		FileIO reader = new FileIO();
		
		// TESTING MOVIES
		//movieFilePath = "ml-latest-small" + FileIO.fileSeparator + "movies.csv";
		ArrayList<String> movieStringData = reader.readFile(movieFilePath);
		movieData = new ArrayList<Movie>();
		
		for(int i = 1; i < movieStringData.size(); i++)
		{
			Movie m = NetflixTranslator.stringToMovie(movieStringData.get(i));
			movieData.add(m);
		}
		//System.out.println(movieData);
		
		
		// TESTING LINKS
		//linkFilePath = "ml-latest-small" + FileIO.fileSeparator + "links.csv";
		ArrayList<String> linkStringData = reader.readFile(linkFilePath);
		linkData = new ArrayList<Movie>();
		
		for(int i = 1; i < linkStringData.size(); i++) 
		{
			Movie link = NetflixTranslator.stringToLink(linkStringData.get(i));
			linkData.add(link);
		}
		//System.out.println(linkData);
		
		
		
		
		// TESTING RATINGS
		//ratingFilePath = "ml-latest-small" + FileIO.fileSeparator + "ratings.csv";
		ArrayList<String> ratingStringData = reader.readFile(ratingFilePath);
		ratingData = new ArrayList<Rating>();
		
		for(int i = 1; i < ratingStringData.size(); i++)
		{
			Rating r = NetflixTranslator.stringToRating(ratingStringData.get(i));
			ratingData.add(r);
		}
		//System.out.println(ratingData);
		
		
		
		// TESTING TAGS
		//tagFilePath = "ml-latest-small" + FileIO.fileSeparator + "tags.csv";
		ArrayList<String> tagStringData = reader.readFile(tagFilePath);
		tagData = new ArrayList<Tag>();
		
		for (int i = 1; i < tagData.size(); i++)
		{
			Tag t = NetflixTranslator.stringToTag(tagStringData.get(i));
			tagData.add(t);
		}
		//System.out.println(tagData);
		
		
		
		// TESTING USERS
		userData = new ArrayList<User>();
		
		//for(int i = 1; i < )

	}
		
	/**
	 * If userNumber has rated movieNumber, return the rating. Otherwise, return -1.
	 * 
	 * @param userNumber The ID of the user.
	 * @param movieNumber The ID of the movie.
	 * @return The rating that userNumber gave movieNumber, or -1 if the user does not exist in the database, the movie does not exist, or the movie has not been rated by this user.
	 */
	public double getRating(long userID, long movieID) {
	
		Rating r;
		double stars = 0;
		
		for(int i = 0; i < ratingData.size(); i++)
		{
			r = ratingData.get(i);
			
			if(r.getUserID() == userID && r.getMovieID() == movieID)
			{
				stars = r.getRating();
				break;
			}
			else
			{
				stars = -1;
			}
		}
		
		return stars;
	}
	
	public double calcAvgRating(long movieID)
	{
		Rating r;
		double ratingSum = 0;
		int num = 0;
		
		for(int i = 0; i < ratingData.size(); i++)
		{
			r = ratingData.get(i);
			if(r.getMovieID() == movieID)
			{
				num++;
				ratingSum += r.getRating();
			}
		}
		
		double avg = ratingSum/num;
		
		return avg;
	}
	
	/**
	 * If userNumber has rated movieNumber, return the rating. Otherwise, use other available data to guess what this user would rate the movie.
	 * 
	 * @param userNumber The ID of the user.
	 * @param movieNumber The ID of the movie.
	 * @return The rating that userNumber gave movieNumber, or the best guess if the movie has not been rated by this user.
	 * @pre A user with id userID and a movie with id movieID exist in the database.
	 */
	public double guessRating(long userID, long movieID) {
		
		double rating = 0; 
		Rating r;
		Movie m;
		int current = 0; // current similar movies between 2 users
		long userMost = 0; // ID of user w/ most similar movies
		int max = 0; // userMost's # of similar movies
		
		if(ratingData.contains(userID) && ratingData.contains(movieID))
		{
		
			for(int i = 0; i < ratingData.size(); i++)
			{
				r = ratingData.get(i);
				double stars = getRating(userID, movieID);
				long currentID = r.getUserID(); //current user
				
				if(r.getUserID() == currentID)
				{
					if(r.getUserID() != userID && r.getMovieID() == movieID) //compare to other users
					{
						currentID = r.getUserID();
	
						if(r.getRating() <= stars+0.5 && r.getRating() >= stars-0.5)
						{
							current++;
							if(current > max)
							{
								max = current;
								userMost = currentID;
							}
						}
						//rating = getRating(r.getUserID(), movieID);
						
					}
				}
				else if(r.getUserID() != currentID)
				{
					currentID = r.getUserID();
					current = 0;
				}
			}
			
			
			if(max < 10) // if not similar enough, run similarity test for genres
			{
				ArrayList<String> list = new ArrayList<String>();
				
				for(int i = 0; i < movieData.size(); i++)
				{
					m = movieData.get(i);
					list = m.getGenres();
					
					if(movieID == m.getID())
					{
						for(int j = 0; j < list.size(); i++)
						{
							if(list.get(i).equals())
						}
					}
				}
			}
			
			else
			{
				rating = calcAvgRating(movieID);
			}
		}
		
		else
		{
			rating = -1;
		}
		

		return rating;
	}
	
	
	
	
}
