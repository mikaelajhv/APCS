import java.util.ArrayList;

public class TesterBugs {

	public static void main(String[] args) {
		FileIO reader = new FileIO();
		
		// Testing movies
		String movieFilePath = "ml-latest-small" + FileIO.fileSeparator + "movies.csv";
		
		ArrayList<String> movieStringData = reader.readFile(movieFilePath);
		
		ArrayList<Movie> movieData = new ArrayList<Movie>();
		for (int i = 1; i < movieStringData.size(); i++) {
			Movie m = NetflixTranslatorBugs.stringToMovie(movieStringData.get(i));
			movieData.add(m);
		}

		System.out.println(movieData);

	}

}
