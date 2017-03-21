import java.io.BufferedReader;
import java.io.BufferedWriter;
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
		ArrayList<String> out = new ArrayList<String>();
		
		FileReader reader;
		BufferedReader breader = null;
		
		Scanner in = null;
		
		try {
			reader = new FileReader(filename);
			breader = new BufferedReader(reader);
			
			in = new Scanner(breader); 
			
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
			in.close(); // close: closes what its attached to (close top most chain)
		}
		
		return null;
	}
	
	public void writeFile(ArrayList<String> data, String file)
	{
		FileWriter writer = null;
		BufferedWriter bwriter = null;
		
		try {
			writer = new FileWriter(file);
			bwriter = new BufferedWriter(writer);
			
			for(String line : data)
			{
				bwriter.write(line + lineSeparator);
			}
			
		} 
		catch (IOException e) {
			e.printStackTrace();
		}	
		finally {
			try {
				if(bwriter != null)
					bwriter.close();
			}
			catch (IOException e) {
				e.printStackTrace();
			}	
		}
	}
	

	
	
	
	
	
	
	
	
}
