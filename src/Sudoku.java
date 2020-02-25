import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Sudoku extends AIgame {

	static double arraySize = 0;
	static int[][] originalGrid;
	public static void main(String[] args) {
	
	}
	
	public Sudoku (String filepath) throws FileNotFoundException{
		AiGame(filepath);
		solve();
		toString();
	}
	

@Override
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
			originalGrid[i][j] = grid[i][j];// setting the reset grid
			count++;
		}
		
	}
	
}

/**
 * Checks the column if it is valid
 * 
 * @param col
 * @return coulumncheck
 */

public boolean isColumnValid() {
	boolean columnCheck = false;
	int space = 0;
	int columnTotal = 0;
	
	
	// these nested for loops check to see that 
	// each value 1-9 only comes once
	for (int col = 0; col < grid.length; col++) {
		int [] dictionary = {1,2,3,4,5,6,7,8,9};
		
		for(int row = 0; row < grid.length; row++) {
			space = grid[row][col];
			
			for(int i = 0; i < dictionary.length; i++) {
				if (dictionary[i] == space) {
					dictionary[i] = 0;
				}
			}
		}
		// test to see if the column only used the 9 numbers
		for(int j = 0; j < dictionary.length; j++) {
			columnTotal += dictionary[j];
		}
	}
		
		if(columnTotal == 0) {
			columnCheck = true;
		}else {
			columnCheck = false;
		}
	
	return columnCheck;
	
}
/** 
 * checks if the rows are valid for the for sudoku]
 * @param row
 * @return boolean rowcheck for validity
 */
public boolean isRowValid() {
	boolean rowCheck = false;
	int space = 0;
	int rowTotal = 0;
	
	
	// these nested for loops check to see that 
	// each value 1-9 only comes once
	
		for (int row = 0; row < grid.length; row++) {
			int [] dictionary = {1,2,3,4,5,6,7,8,9};
			for(int column = 0; column < grid.length; column++) {
				space = grid[row][column];
				for(int i = 0; i < dictionary.length; i++) {
					if (dictionary[i] == space) {
						dictionary[i] = 0;
					}
				}
				for(int j = 0; j < dictionary.length; j++) {
					rowTotal += dictionary[j];
				}
		}
		
		// checks if the total for the rows are 0
		if(rowTotal == 0) {
			rowCheck = true;
		}else {
			rowCheck = false;
		}
	}
	return rowCheck;
	
}

public static boolean isSubgridValid() {
	return true;
}


@Override
protected int[][] solve() {
	ArrayList <Integer> dictionary = new ArrayList <Integer>();
	Random rand = new Random();
	int randomnum;
	int gridcount = 1;
	while(isValid == false) {
		for (int i = 0; i < arraySize; i++) {
			dictionary.add(i+1);
		}
		
		
		
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				
				if (grid[i][j] == 0) {
					
					for (int row = 0; row < grid.length; row++) {
						for (int l = 0; l < dictionary.size(); l++) {
							if (grid[row][j] == dictionary.get(l)) {
								dictionary.remove(l);
							}
						}
						
					}
					
					for (int col = 0; col < grid.length; col++) {
						for (int l = 0; l < dictionary.size(); l++) {
							if (grid[i][col] == dictionary.get(l)) {
								dictionary.remove(l);
							}
						}
						
					}
					
					if (dictionary.size() > 0) {
						randomnum = rand.nextInt(dictionary.size());
						grid[i][j] = dictionary.get(randomnum);
						
					}else
						break;
					
				}
			}
			}
		if(isRowValid() == true && isColumnValid() == true && isSubgridValid() == true) {
			isValid = true;
		}
		if (isValid == false) {
			System.out.println(gridcount);
			for(int i = 0; i< grid.length; i++) {
				for (int j =0; j < grid.length; j++) {

					grid[i][j] = originalGrid[i][j];
				}
			}
		}
		gridcount++;
	}
	
	
	return grid;
}

@Override
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
	
	return fullarray;
}

}
