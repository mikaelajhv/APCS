
public class Tag {

	private String words;
	private int ID, movie;
	private long time;
	
	
	public Tag(int id, int movie, String message, long timeStamp)
	{
		ID = id;
		this.movie = movie;
		words = message;
		time = timeStamp;
	}
	
	public String toString()
	{
		return "" + ID + movie + words + time;
	}
	
	//returns the tag
	public String getTag()
	{
		return "hello";
	}
}
