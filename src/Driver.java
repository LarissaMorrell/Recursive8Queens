import java.util.Scanner;

/**
 * @author Larissa Perkins
 * BU MET 342
 * Due April 9, 2015
 * Project 2: Recursive 8 Queens
 */

public class Driver {

	public static void main(String[] args) {
		
		Driver prgm = new Driver();
		prgm.run();

	}
	
	private void run() {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Welcome to the 8 Queens Solver");
		GameBoard game = new GameBoard();
		
		// Add the queen to the first space on the board
		game.addQueen(0, 0);
		
		game.printBoard();
		
		//Start with the first row and first column (Zero index)
		if (game.findSolution(0)){
			
			System.out.println("\nThere is a solution.");
			game.printBoard();
			
		} else {
			System.out.println("\nThere is no solution "
					+ "for this space.");
		}
		
	}
	

}
