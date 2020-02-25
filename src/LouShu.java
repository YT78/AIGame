import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;
import java.util.Random;

public class LouShu extends AIgame {

	public static void main(String[] args) {
		
	};
	
	static int originalGrid[][];
	static double arraySize;
	static int firstRow = 0;
	
	/**
	 * this sets the box that holds the numbers
	 * @return integer array
	 * @throws FileNotFoundException 
	 */
	public LouShu (String filePath) throws FileNotFoundException {
		AiGame(filePath);
		solve();
		toString();
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
			if (currentRow == firstRow) {
				isValid = true;
			}else
				isValid = false;
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
			if (currentColumn == firstRow) {
				isValid = true;
			}else
				isValid = false;
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
		if (total == firstRow) {
			isValid = true;
		}else
			isValid = false;
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
		if (total == firstRow) {
			isValid = true;
		}else 
			isValid = false;
		
		return isValid;
	}

	public void AiGame(String filepath) throws FileNotFoundException {
		
		ArrayList <Integer> filenums = new ArrayList<Integer>();
		String path = filepath;
		File filereader = new File(path);//setting the file that will  be used
		Scanner reader = new Scanner(filereader);
		
		//reads in the integers and saves them to an array list
		while (reader.hasNextInt()) {
			
			filenums.add(reader.nextInt());
		}
		
		reader.close();
		// finds the size the array needs to be
		arraySize = Math.sqrt(filenums.size());
		
		grid = new int[(int) arraySize][(int) arraySize];
		originalGrid = new int[(int) arraySize][(int) arraySize];
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				grid[i][j] = filenums.get(count);
				originalGrid[i][j] = grid[i][j];
				count++;
			}
			
		}
		
	}

	@Override
	protected int[][] solve() {
		Random rand = new Random();
		int randomnum;
		while(isValid == false) {
		ArrayList <Integer> dictionary = new ArrayList <Integer>();
		
		//setting the dictionary
		for (int i = 0; i < (arraySize*arraySize); i++) {
			dictionary.add(i+1);
		}
		
		//pulls all the already used numbers out of the list
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				
				for (int l = 0; l < dictionary.size(); l++) {
					if (dictionary.get(l) == grid[i][j])
						dictionary.remove(l);
				}
				
			}
			
		}
		//chooses a number from the dictionary at random and places
		//it in the array
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				
				if (grid[i][j] == 0) {
					randomnum = rand.nextInt(dictionary.size());
					grid[i][j] = dictionary.get(randomnum);
					dictionary.remove(randomnum);
				}
			}
			}
		firstRow = 0;
			for (int j = 0; j < grid.length; j++) {
				firstRow += grid[1][j];
			}
		
		if (rowTest(grid) == true && columnTest(grid) == true 
				&& leftToRight(grid) == true && rightToLeft(grid) == true) {
			isValid = true;
		}
		if (isValid == false) {
			for(int i = 0; i< grid.length; i++) {
				for (int j =0; j < grid.length; j++) {
					grid[i][j] = originalGrid[i][j];
				}
			}
		}
		}
		
			
		return grid;
	}

	@Override
	/**
	 * Changes the array into a printable string
	 * 
	 */
	public String toString() {
		String currentnum;
		String fullarray = "";
		
		for (int i = 0; i < grid.length; i++) {
			fullarray = fullarray + "\n";
			for (int j = 0; j < grid.length; j++) {
				currentnum = Integer.toString(grid[i][j]);
				fullarray = fullarray + currentnum;
				fullarray = fullarray + " ";
			}
		}
		System.out.printf(fullarray);
		
		return null;
	}

}
