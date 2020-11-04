/* ************************************************************************* *\
*                Programmierung 1 HS 2020 - Serie 5-1                         * 
\* ************************************************************************* */


/** A very stupid computer player */
public class ComputerPlayer implements IPlayer
{
	private Token token;

	/**
	 * Strategy is to chose a random column and select 
	 * the next valid column to the right (the chosen included)
	 */
	public int getNextColumn( Token[][] board )
	{
		java.util.Random generator = new java.util.Random();
		int randomCol = generator.nextInt( board.length );
		int col = randomCol - 1;


		/* i are columns and j are rows
		   Computer goes through all elements of the array and searches for already played tokes. But at this point
		   its still pretty bad, I m not sure about multiple conditions in if clauses (should check that)*/
		for (int i = 0; i < board.length -1; i++) {
			for (int j = 0; j < board[i].length -1; j++) {

				/* if there is a player2 token and the one above is free, this column is chosen. for this scenario
				   j should not be equal the last row, otherwise this would rise an out-of-bound exception*/
				if (j < board[i].length - 1){
					if (board[i][j] == Token.player2 && board[i][j+1] == Token.empty) {
					col = i + 1;}

				/* if there is a player2 token and the one on the left or right is empty then take this. However,
				   is only works for elements that are emtpy to right at the moment.*/
				} else if (i <= board.length - 2 || i > 0 ){
					if (board[i][j] == Token.player2 && board[i-1][j] == Token.empty || board[i+1][j] == token.empty) {
					col = i + 1;}

				// if none of the above is the case, just use a random column
				} else {
					break;
				}
			}
		}

		// added this to avoid full columns
		while ( isColFull( col, board ) ) {
			col = ( col + 1 ) % board.length;
		}
		return col;
	}



	/**
	 * @return true if the column col is already full and false otherwise. 
	 */
	private boolean isColFull( int col, Token[][] board )
	{
		int topRow = board[ col ].length - 1;
		return ( board[ col ][ topRow ] != Token.empty );
	}


	public void setToken( Token token )
	{
		this.token = token;
	}

	public Token getToken()
	{
		return this.token;
	}

	public String getPlayersName()
	{
		return "Random Player";
	}
}
