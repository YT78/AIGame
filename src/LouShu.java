import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;

public class LouShu extends AIgame {

	public void main(String[] args) throws FileNotFoundException {
		
		String path = args[0];
		AiGame(path);

	};
	
	static double arraySize;
	static int firstRow = 0;
	/**
	 * this sets the box that holds the numbers
	 * @return integer array
	 */
	
	public static int[][] setbox(){
		// sets the size of the array
		int [][] grid = new int[(int) arraySize][(int)arraySize];
		String input = "";
		
		for (int i = 0; i < input.length(); i++) {
			char output = input.charAt(i);
			
			// changes the character to a number
			int applied = Character.getNumericValue(output);
			
			for (int row = 0; row < arraySize; row++) {
				for(int column = 0; column < arraySize; column++) {
					if (column == (i - row*arraySize)) {
						grid[row][column] = applied;
					}
					
				}
			}
			
		}
		
		
		
		return grid;
	}
	
	/**
	 * this test the rows to see if they are equal to the first row
	 * @param array that includes all the numbers
	 * @return a boolean that checks the 
	 */
	public static boolean rowTest(int [][] array) {
		for (int row = 1; row < arraySize; row++) {
			int currentRow = 0;
			for (int column = 0; column < arraySize; column++) {
				currentRow += array[row][column];
			}
			if (currentRow != firstRow) {
				isValid = false;
			}
		}
		return isValid;
		
	}
	
	
	/**
	 * this adds up the column and checks it off of the first row sum
	 * @param array
	 * @return
	 */
	public static boolean columnTest(int [][] array) {
		for (int column = 0; column < arraySize; column++) {
			int currentColumn = 0;
			for (int row = 0; row < arraySize; row++) {
				currentColumn += array[row][column];
			}
			if (currentColumn != firstRow) {
				isValid = false;
			}
		}
		return isValid;
	}
	/**
	 * this checks the array from top left to bottom right.
	 * @param array
	 * @return test the boolean 
	 */
	
	public static boolean leftToRight(int [][] array) {
		int column = 0;
		int total = 0;
		for (int row = 0; row < arraySize; row++) {
			total += array[row][column];
			column++;
		}
		if (total != firstRow) {
			isValid = false;
		}
		return isValid;
		
	}
	
	/**
	 * this method checks the value of the diagonal
	 * from top right to bottom left
	 * @param array
	 * @return boolean if its true
	 */
	public static boolean rightToLeft(int [][] array) {
		double columnSize = arraySize-1.0;
		int total = 0;
		int column = (int) columnSize;
		for (int row = 0; row < arraySize; row++) {
			total += array[row][column];
			column--;
		}
		if (total != firstRow) {
			isValid = false;
		}
		return isValid;
	}

	@Override
	public void AiGame(String filepath) throws FileNotFoundException {
		
		ArrayList <Integer> filenums = new ArrayList();
		String path = filepath;
		File filereader = new File(path);//setting the file that will  be used
		Scanner reader = new Scanner(filereader);
		
		while (reader.hasNextInt()) {
			
			filenums.add(reader.nextInt());
		}
		
		arraySize = Math.sqrt(filenums.size());
		System.out.println(arraySize);
		
		
	}

	@Override
	protected int[][] solve() {
		
		
		return null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
