import java.io.FileNotFoundException;

public abstract class AIgame {
 
	protected int grid[][];

 protected static boolean isValid = false;
 
 public void main(String[] args) throws FileNotFoundException{
	 
 };
 
 public abstract void AiGame(String filepath) throws FileNotFoundException;
 
 protected abstract int[][] solve();
 
 public abstract String toString();


}

