
public class GameBoard {

	private SpaceNode board[][];
	private final int BOARD_SIZE = 8;

	public GameBoard(){
		board = new SpaceNode[BOARD_SIZE][BOARD_SIZE];

		// For every space create a new node and set it to false
		for(int row = 0; row < BOARD_SIZE; row++){
			for(int col = 0; col < BOARD_SIZE; col++){

				board[row][col] = new SpaceNode();
				board[row][col].setSpace(false);
			}
		}
	}



	public void addQueen(int row, int col) {

		board[row][col].setSpace(true);
	}



	public void printBoard(){

		for(int row = 0; row < BOARD_SIZE; row++){
			for(int col = 0; col < BOARD_SIZE; col++){

				// Move on to the next column
				System.out.print(board[row][col] + "  "); 
			}
			System.out.println(); //Start a new row
		}
		System.out.println(); 
	}



	public boolean findSolution(int col){

		//If all queens are placed return true
		if(col >= BOARD_SIZE){
			return true;
		}


		//Try all rows in the current column.
		for (int r = 0; r < BOARD_SIZE; r++){

			// If there is a queen that can be placed in the
			// current space, put a queen there 
			if(validSolution(r, col)){
				board[r][col].setSpace(true);

				// If the next column can also have a queen, recurse
				if(findSolution(col + 1)){
					return true;
				}


				// If we still don't have a solution then take the 
				// queen off the board and move on to next row
				else {
					board[r][col].setSpace(false);
				}
			}
		}

		// All rows have been done,  so if we get here it
		//is time to start backtracking
		return false;
	}





	private boolean validSolution(int rowQ, int colQ){

		// Print error & return if the space is not on the board
		if(rowQ < 0 || colQ < 0 ||
				rowQ > 7 || colQ > 7){
			System.out.println("Error: There is no space at row "
					+ rowQ + ", col " + colQ);
		}

		//TESTING ROWS
		for(int r = 0; r < BOARD_SIZE; r++){

			//If the row is the same, skip it
			if (r == rowQ){
				continue;
			}

			// If there is a Q in the row, it's not a solution
			if(board[r][colQ].getSpace() == true){
				return false;
			}
		}


		//TESTING COLUMNS
		for(int c = 0; c < BOARD_SIZE; c++){

			//If column is the same, skip it
			if (c == colQ){
				continue;
			}

			// If there is a Q in the column, it's not a solution
			if(board[rowQ][c].getSpace() == true){
				return false;
			}
		}


		//TESTING DIAGONALS
		for(int r = 0; r < BOARD_SIZE; r++){
			for(int c = 0; c < BOARD_SIZE; c++){

				//if the space is the same, skip it
				if(r == rowQ && c == colQ){
					continue;
				}

				// If there is a Q at that space
				if(board[r][c].getSpace() == true){

					double deltaRow = r - rowQ;
					double deltaCol = c - colQ;					

					// Think... slope formula for a chess board
					if(Math.abs((deltaCol/deltaRow)) == 1.0){
						return false;
					} 
				}
			}
		}

		// If everything else checks out, it must be
		// possible for a Q to be placed
		return true;
	}


}
