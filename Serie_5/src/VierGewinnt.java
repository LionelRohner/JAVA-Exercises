/* ************************************************************************* *\
*                Programmierung 1 HS 2020 - Serie 5-1                         * 
\* ************************************************************************* */

import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;


public class VierGewinnt
{

	public static final int COLS = 7;
	public static final int ROWS = 6;

	private Token[][] board = new Token[ COLS ][ ROWS ]; // 7 columns with 6 fields each
	private IPlayer[] players = new IPlayer[ 2 ]; // two players

	/** initialize board and players and start the game */
	public void play()
	{
		// initialize the board
		for ( Token[] column : this.board ) {
			Arrays.fill( column, Token.empty );
		}

		/* initialize players */
		players[ 0 ] = new HumanPlayer();
		System.out.print( "Play against a human opponent? (y / n) " );
		String opponent = new Scanner( System.in ).nextLine().toLowerCase();
		while ( ( 1 != opponent.length() ) || ( -1 == ( "yn".indexOf ( opponent ) ) ) ) {
			System.out.print( "Can't understand your answer. Play against a human opponent? (y / n) " );
			opponent = new Scanner( System.in ).nextLine().toLowerCase();
		}
		if ( opponent.equals( "y" ) ) {
			players[ 1 ] = new HumanPlayer();
		} else {
			players[ 1 ] = new ComputerPlayer();
		}
		players[ 0 ].setToken( Token.player1 );
		players[ 1 ].setToken( Token.player2 );

		/* play... */
		boolean solved = false;
		int currentPlayer = ( new java.util.Random() ).nextInt( 2 );  //choose randomly who begins
		System.out.println( "current player: " + currentPlayer );
		int insertCol, insertRow; // starting from 0
		while ( !solved && !this.isBoardFull() ) {
			// get player's next "move"
			// note that we pass only a copy of the board as an argument,
			// otherwise the player would be able to manipulate the board and cheat!
			insertCol = players[ currentPlayer ].getNextColumn( getCopyOfBoard() );
			// insert the token and get the row where it landed
			insertRow = this.insertToken( insertCol, players[ currentPlayer ].getToken() );
			// check if the game is over
			solved = this.checkVierGewinnt( insertCol, insertRow );
			//switch to other player
			if ( !solved )
				currentPlayer = ( currentPlayer + 1 ) % 2;
		}
		System.out.println( displayBoard( this.board ) );
		if ( solved )
			System.out.println( "Player " + players[ currentPlayer ].getToken() + " wins!" );
		else
			System.out.println( "Draw! Game over." );
	}


	/**
	 * Inserts the token at the specified column (if possible)
	 * @param column the column to insert the token
	 * @param token the players token
	 * @return the row where the token landed 
	 */
	private int insertToken( int column, Token tok )
	{
		//TODO: Your code goes here

		// set row to a value that does not fit in the 2D array
		int row_test = -1;

		// loop through all rows and check whether its empty or not
		for (int i = 0; i <= 5; i ++){

			// if its empty add token to the coordinates and return row number
			if(this.board[column][i] == Token.empty){
				this.board[column][i] = tok;
				row_test = i;
				break;
			}
		}

		return row_test; //TODO: Replace this line
	}


	/**
	 * Checks if every position is occupied 
	 * @returns true, iff the board is full.
	 */
	private boolean isBoardFull()
	{
		//TODO: Your code goes here

		boolean check = false;

		// loop through the 2D array and check if there is an empty token
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {

				// if there is an empty token, check remains false and the game continues
				if (board[i][j] == Token.empty) {
					check = false;

				// if the board is full, check is true and the game stops
				} else {
					check =  true;
				}
			}
		}
		return check;
	}


	/**
	 * Checks for at least four equal tokens in a row in
	 * either direction, starting from the given position. 
	 */
	private boolean checkVierGewinnt( int col, int row )
	{
		//TODO: Your code goes here

		// make a switch for game decision

		Boolean checkWinGame = false;
		if (this.horizontalWin(col, row) == true){
			checkWinGame = true;
		}


		return checkWinGame; //TODO: Replace this line!
	}

	// Add some helper methods for "checkVierGewinnt"
	private Boolean horizontalWin(int col, int row){

		Boolean checkWin = false;

		Token playerTest = board[col][row];



		// set a counter to 0; used to count neighboring Tokens of the same type
		int cnt = 0;

		// go from left to right through all columns of the row that has been last played
		for (int i = 0; i < board.length; i++){

			// if Token player1 add one to counter
			if (board[i][row].equals(playerTest)){
				cnt ++;

				// if its empty or player 2 reset counter
			} else {
				cnt = 0;
			}

			// winning condition
			if (cnt == 4){
				checkWin = true;
				break;
			}
		}




//		if (board[col][row] == Token.player1){
//
//			// set a counter to 0; used to count neighboring Tokens of the same type
//			int cnt = 0;
//
//			// go from left to right through all columns of the row that has been last played
//			for (int i = 0; i < board.length; i++){
//
//				// if Token player1 add one to counter
//				if (board[i][row].equals(Token.player1)){
//					cnt ++;
//
//				// if its empty or player 2 reset counter
//				} else {
//					cnt = 0;
//				}
//
//				// winning condition
//				if (cnt == 4){
//					checkWin = true;
//					break;
//				}
//			}
//		} else {
//
//
//
//		}

		return checkWin;
	}



	/** Returns a (deep) copy of the board array */
	private Token[][] getCopyOfBoard()
	{
		Token[][] copiedBoard = new Token[ COLS ][ ROWS ];
		for ( int i = 0; i < copiedBoard.length; i++ ) {
			for ( int j = 0; j < copiedBoard[ i ].length; j++ ) {
				copiedBoard[ i ][ j ] = this.board[ i ][ j ];
			}
		}
		return copiedBoard;
	}


	/** returns a graphical representation of the board */
	public static String displayBoard( Token[][] myBoard )
	{
		String rowDelimiter = "+";
		String rowNumbering = " ";
		for ( int col = 0; col < myBoard.length; col++ ) {
			rowDelimiter += "---+";
			rowNumbering += " " + ( col + 1 ) + "  ";
		}
		rowDelimiter += "\n";

		String rowStr;
		String presentation = rowDelimiter;
		for ( int row = myBoard[ 0 ].length - 1; row >= 0; row-- ) {
			rowStr = "| ";
			for ( int col = 0; col < myBoard.length; col++ ) {
				rowStr += myBoard[ col ][ row ].toString() + " | ";
			}
			presentation += rowStr + "\n" + rowDelimiter;
		}
		presentation += rowNumbering;
		return presentation;
	}



	/** main method, starts the program */
	public static void main( String args[] )
	{
		VierGewinnt game = new VierGewinnt();
		game.play();
	}
}
