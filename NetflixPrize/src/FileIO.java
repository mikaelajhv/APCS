import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {

	public static final String fileSeparator = System.getProperty("file.separator");
	public static final String lineSeparator = System.getProperty("line.separator");
	
	public FileIO()
	{
		
	}
	
	
	public ArrayList<String> readFile(String filename)
	{
		FileReader reader;
		ArrayList<String> out = new ArrayList<String>();
		Scanner in = null;
		
		try {
			reader = new FileReader(filename);
			in = new Scanner(reader);
			
			while(in.hasNextLine())
			{
				String input = in.nextLine();
				out.add(input);
			}
			
			return out;
		} 
		catch (IOException e) {
			e.printStackTrace();
		}	
		finally {
			if(in != null)
			in.close();
		}
		
		return null;
	}
	
	public void writeFile(ArrayList<String> data, String file)
	{
		FileWriter writer = null;
		
		try {
			writer = new FileWriter(file);
			
			for(String line : data)
			{
				writer.write(line + lineSeparator);
			}
			
		} 
		catch (IOException e) {
			e.printStackTrace();
		}	
		finally {
			try {
				if(writer != null)
					writer.close();
			}
			catch (IOException e) {
				e.printStackTrace();
			}	
		}
	}
	

	
	
	
	
	
	
	
	
}
