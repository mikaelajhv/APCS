import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/*

	Represents a Game Of Life grid.

	Coded by: Mikaela Valenciano
	Modified on: January 31, 2017

*/

public class Life {

	private static final int rows = 20;
	private static final int cols = 20;
	private boolean[][] board;


	// Constructs an empty grid
	public Life() {

	}

	// Constructs the grid defined in the file specified
	public Life(String filename) {
		board = readData(filename);
	}

	
	// Runs a single turn of the Game Of Life
	public void step() {
	/* for each cell in board:
	 * 	count # of alive neighbors this cell has, be careful not to:
	 * 		-go off edge of board (index out o bounds exception)
	 * 		-count cell itself
	 * 
	 * set cell to alive if alive and should stay alive
	 * set cell to alive if dead and should be alive
	 */
		//count diagonal neighbors too...
		for(int i = 0; i < board.length; i++)
		{
			for(int j = 0; j < board.length; j++)
			{
				if(board[i])
			}
		}
	
	}

	// Runs n turns of the Game Of Life
	public void step(int n) {
		for(int i = 0; i < board.length; i++)
		{
			for(int j = 0; j < board.length; j++)
			{
				if(board[i][j-1] == true)
				{
					
				}
			}
		}
		
	}

	// Formats this Life grid as a String to be printed (one call to this method returns the whole multi-line grid)
	public String toString() {
		
		String out = "";
		for(int i = 0; i < board[0].length; i++)
		{
			for(int j = 0; j < board.length; j++)
			{
				if(board[j][i])
				{
					out+= "*";
				}
				else
				{
					out+=" ";
				}
			}
			out += "\n";
		}
		
		return out;
	}

	public boolean[][] readData (String filename) {
		File dataFile = new File(filename);

		if (dataFile.exists()) {
			boolean[][] gameData = new boolean[cols][rows];

			int count = 0;

			FileReader reader = null;
			try {
					reader = new FileReader(dataFile);
					Scanner in = new Scanner(reader);


					while (in.hasNext() && count < rows) {
						String line = in.nextLine();
						for(int i = 0; i < line.length(); i++)
							if (line.charAt(i)=='*')
								gameData[i][count] = true;

						count++;
					}

			} catch (IOException ex) {
				System.out.println("File cannot be read.");
				return null;
			} catch (NumberFormatException ex) {
				System.out.println("File is in the wrong format.");
				return null;
			} finally {
				try {
					reader.close();
				} catch (IOException ex) {
					System.out.println("File cannot be closed.");
					return null;
				}
			}
			return gameData;
		} else {
			throw new IllegalArgumentException("Data file " + filename + " does not exist.");
		}
    }

}