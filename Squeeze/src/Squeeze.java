import java.util.ArrayList;

//compression algorithm and main method
public class Squeeze {

	public static void main(String[] args) {
		
		// READ IN FILE
		String filePath = "data" + FileIO.fileSeparator + "squeeze.txt";
		
		FileIO file = new FileIO();
		ArrayList<String> data = file.readFile(filePath);
		
		// COMPRESS DATA
		
		int spaces = 0;
		ArrayList<String> data2 = new ArrayList<String>();
		
		int index = 0;
		while(data.get(index).equals(" "))
		{
			spaces++;
			index++;
		}
		data.add(index + spaces, "");
	
		
		
		
		
		// write out new file
		String filePath2 = "data" + FileIO.fileSeparator + "squeeze2.txt";
		
		file.writeFile(data2, filePath2);
		
		
	}

}
