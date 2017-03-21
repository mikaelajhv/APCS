import java.util.ArrayList;

public class Tester {

	public static void main(String[] args) {
		
		FileIO reader = new FileIO();
		String movieFilePath = "ml-latest-small" + FileIO.fileSeparator + "movies.csv";
		String linkFilePath = "ml-latest-small" + FileIO.fileSeparator + "links.csv";
		String ratingFilePath = "ml-latest-small" + FileIO.fileSeparator + "ratings.csv";
		String tagFilePath = "ml-latest-small" + FileIO.fileSeparator + "tags.csv";
		
		//delete everything in tester (after copying into NetFlixPredictor constructor)
		
		NetFlixPredictor np = new NetFlixPredictor(movieFilePath, ratingFilePath, tagFilePath, linkFilePath);
		//System.out.println(np.getRating(15, 193)); //1.0
		System.out.println(np.getRating(4, 2174)); //5.0
		
		/*
		// TESTING MOVIES
		String movieFilePath = "ml-latest-small" + FileIO.fileSeparator + "movies.csv";
		ArrayList<String> movieStringData = reader.readFile(movieFilePath);
		ArrayList<Movie> movieData = new ArrayList<Movie>();
		
		for(int i = 1; i < movieStringData.size(); i++)
		{
			Movie m = NetflixTranslator.stringToMovie(movieStringData.get(i));
			movieData.add(m);
		}
		//System.out.println(movieData);
		
		
		// TESTING LINKS
		String linkFilePath = "ml-latest-small" + FileIO.fileSeparator + "links.csv";
		ArrayList<String> linkStringData = reader.readFile(linkFilePath);
		ArrayList<Movie> linkData = new ArrayList<Movie>();
		
		for(int i = 1; i < linkStringData.size(); i++) 
		{
			Movie link = NetflixTranslator.stringToLink(linkStringData.get(i));
			linkData.add(link);
		}
		
		// TESTING RATINGS
		String ratingFilePath = "ml-latest-small" + FileIO.fileSeparator + "ratings.csv";
		ArrayList<String> ratingStringData = reader.readFile(ratingFilePath);
		ArrayList<Rating> ratingData = new ArrayList<Rating>();
		
		for(int i = 1; i < ratingStringData.size(); i++)
		{
			Rating r = NetflixTranslator.stringToRating(ratingStringData.get(i));
			ratingData.add(r);
		}
		//System.out.println(ratingData);
		
		// TESTING TAGS
		String tagFilePath = "ml-latest-small" + FileIO.fileSeparator + "tags.csv";
		ArrayList<String> tagStringData = reader.readFile(tagFilePath);
		ArrayList<Tag> tagData = new ArrayList<Tag>();
		
		for (int i = 1; i < tagData.size(); i++)
		{
			Tag t = NetflixTranslator.stringToTag(tagStringData.get(i));
			tagData.add(t);
		}
		
		

		*/
	}

}
