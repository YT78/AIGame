import java.io.FileNotFoundException;

public abstract class AIgame {
 
	protected int grid[][];

 protected static boolean isValid = false;
 
 public static  void main(String[] args) throws FileNotFoundException {
	 
	 String filepath = args[0];
	 new LouShu(filepath);
 } 
 public abstract void AiGame(String filepath) throws FileNotFoundException;
 
 protected abstract int[][] solve();
 
 public abstract String toString();


}

