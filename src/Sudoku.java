import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Sudoku extends AIgame {

	public void main(String[] args) {
		
		String path = args[0];
		AiGame(path);

	}
	
@SuppressWarnings("resource")

public int[][] readPuzzle(String filePath) throws FileNotFoundException{
		
		int maxRows = 9;
		// setting a string array to hold each row in the file
		String [] rows = new String[maxRows]; 
		
		
		String path = filePath;
		File filereader = new File(path);//setting the file that will  be used
		Scanner reader = new Scanner(filereader);

		
		for (int i = 0; i< rows.length; i++) {
			String data = reader.nextLine();// reads the line of the file and saves it to a variable
			rows[i] = data;// stores lines from file in array 
		}
		
		char num = '0';
		int column = 0;
		
		for (int j = 0; j< rows.length; j++) {
			String currentRow = rows[j];// takes the string from the first array
			
			for (int i = 0; i < currentRow.length(); i++) {
				
				
				if (i%2 == 0) {// gets rid of the spaces in the 
					num = currentRow.charAt(i);//takes the specific characters out of the string
					int number = Character.getNumericValue(num);//changes the character to an int
					grid[j][column] = number;//saves the integer in the 2d array
					if(column < 9) {
						column++;
					}
					//this resets the column counter
					if (column == 9) {
						column = 0;
					}
				}
			}	
		}
		
		return grid;
	}

@Override
public void AiGame(String filepath) {
	
	
}

@Override
protected int[][] solve() {
	
	return grid;
}

@Override
public String toString() {
	
	return null;
}

}
