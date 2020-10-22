/* ************************************************************************* *\
*                Programmierung 1 HS 2020 - Serie 4                         *
\* ************************************************************************* */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;

public class GuessOrc {

	// Store the orc chieftain position.
	private int mineShaftId;

	// Amount of attempts we get to stop the orcs.
	// Use 'MAX_ATTEMPTS'' instead of coding a number
	// directly into your program.
	public final int MAX_ATTEMPTS = 6;
	
	// Number of mine shafts from which orcs can arrive.
	public final int MINE_SHAFTS = 12;

	// Magic numbers to tell us when something was not set.
	public final int NO_MOVE_MADE = -1;
	public final int NO_HINT = -1;

	// Could not parse the given input.
	public final int PARSING_FAILED = -1;

	// SET DEBUG MODE.
	public final boolean DEBUG = false;

	// That's what the orc horde looks like.
	public final String ORCS =  "  ┗(｀Дﾟ┗(｀ﾟДﾟ´)┛ﾟД´)┛  ";
	// If you use WINDOWS (or the above line just looks wrong) change it to this:
	// public final String ORCS =  "  - - - ORC--ARMY - - -  ";

	// Add a Guess object, that counts the number of guesses
	private int GuessInput;

	// Add a scanner object
	private Scanner scanr = new Scanner(System.in);

	// Add a random object
	private Random rand = new Random();

	//Do not modify or access!
	private int[] history = new int[ MAX_ATTEMPTS ];
	private int[] historyHelpers = new int[ MAX_ATTEMPTS ];

	private final String[] HINTS = new String[] {
			"to the left",
			"to the right",
			"under dirt",
			"under stone",
			"very far away"
	};

	// DO NOT CHANGE THIS METHOD!
	public static void main ( String[] args ) {
		GuessOrc game = new GuessOrc();
		game.resetHistory();
		game.start();
	}

	/**
	 * Implement your hint calculation here.
	 *
	 * @param guessedMineShaftId the guessed mine shaft.
	 * @return the id for a hint in HINT.
	 */
	public int calculateHint( int guessedMineShaftId ) {
		// Your code goes here
		ArrayList<Integer> Hints = new ArrayList<>(); //creates an empty list
		int HINT;

		// means that orcs are on the left
		if (guessedMineShaftId > mineShaftId)
			Hints.add(0);

		// means that orcs are on the right
		if (guessedMineShaftId < mineShaftId)
			Hints.add(1);

		// means that orcs are at least 5 fields away
		if (Math.abs(guessedMineShaftId - mineShaftId) > 5)
			Hints.add(4);

		int count = Hints.size(); // count possible combination of hints

		HINT = Hints.get(rand.nextInt(count)); // randomly choose from one of the possible hints
		return HINT;

	}

	private int getGuess(){
		String ErrorMessage="Invalid Input: Please enter a single letter from a-l: ";

		// construct an array with all the valid inputs
		String str = "abcdefghijkl";
		ArrayList<Character> chars = new ArrayList<Character>();
		for (char c : str.toCharArray()) {
			chars.add(c);
		}
		// variables that are used to store the input
		int InputInt;
		char InputChar;

		while(true) { // basically keeps on looping until a correct input is given
			String inpString=scanr.nextLine();
			if (inpString.length()<2) { // input has to be max one character
				InputChar = inpString.charAt(0);
				if (Character.isLetter(InputChar)) {
					InputChar = Character.toLowerCase(InputChar);
					if (chars.contains(InputChar)) {
						InputInt = getColumnAsInt(InputChar);
						break;
					}else{System.out.println(ErrorMessage);}
				} else{System.out.println(ErrorMessage);}
			} else{System.out.println(ErrorMessage);}
		}
		return InputInt;
	}

	/**
	 * Implement the game logic here.
	 */
	public void start() {
		// Your code goes here, printMap,calculateHint input call...
	System.out.println(generateOrcIntroScreen());
	String intro = "\n" + "Knight Kunibert is sitting in his castle and is besieged by orcs. Unfortunately the orcs invade the castle\n" +
			"through the mine shafts instead of attacking on an open field, which would be better for the knight.\n" +
			"Normally Kunibert would simply flood the mine shafts with water, but because his Kunigunde insists that he bathes \n" +
			"daily (one lives in the civilised Middle Ages and not in the stone age), its water supply is very limited\n" +
			"and it can only flush through individual tunnels. Fortunately Kunibert owns several very sensitive seismographs,\n" +
			"which put him in the show the approximate direction of the orcs and allow a rough definition of the terrain by which\n" +
			"they move straight.\n" + "\n";
	System.out.println(intro);
	System.out.println("Game starts now!\n");

	// randomly add the orcs to one of the twelve shafts
	mineShaftId = rand.nextInt(MINE_SHAFTS);

	System.out.println("You have 6 guesses to flush out the orcs! \n");
	System.out.println("This the map, choose between mineshafts a to l!");
	String map = 	"|a|b|c|d|e|f|g|h|i|j|k|l|\n" +
					"-------------------------\n" +
					"|▒|▒|▒|▒|▒|▒|▒|▒|▒|▒|▒|▒|\n" +
					"  ┗(｀Дﾟ┗(｀ﾟДﾟ´)┛ﾟД´)┛  \n" +
					"| |#| |#| |#| |#| |#| |#|\n" +
					"|#| |#| |#| |#| |#| |#| |\n" +
					"| |#| |#| |#| |#| |#| |#|\n" +
					"|#| |#| |#| |#| |#| |#| |\n" +
					"| |#| |#| |#| |#| |#| |#|\n" +
					"-------------------------\n" +
					"-------------------------";

	System.out.println(map);
	System.out.println("Please enter a your first guess:  ");

	// call guessing method
	GuessInput = getGuess();

	// initial value for guess
	int Guesses = 1;

	while (Guesses < MAX_ATTEMPTS){
		if (GuessInput == mineShaftId){ // winning condition, exit loop
			break;}
		else {
			printMap(GuessInput, calculateHint(GuessInput));

			// check how many guesses are left
			if (GuessInput < 6){
				System.out.println("You have " + (MAX_ATTEMPTS-Guesses) + " remaining guesses!");
			} else { // this doesnt work for some reason
				System.out.println("This is your last chance!");
			}

			System.out.println("What is your next guess? ");
			GuessInput = getGuess();
			Guesses ++;
		}

	}
	if (GuessInput == mineShaftId) {
		System.out.println("You repelled the Orcs! \n Congratulations, you won!");}
	else{
		printMap(GuessInput, calculateHint(GuessInput));
		System.out.println("Game Over... Your castle has been overrun!!!");}

	}



	// --- Helper methods ---

	/**
	 * DO NOT CHANGE THIS METHOD!
	 * Resets the game's history.
	 */
	private void resetHistory() {
		history = new int[ MAX_ATTEMPTS ];
		Arrays.fill( history, NO_MOVE_MADE );
		historyHelpers = new int[ MAX_ATTEMPTS ];
		Arrays.fill( historyHelpers, NO_HINT );
	}

	/**
	 * DO NOT CHANGE THIS METHOD!
	 *
	 * @return the number of moves already made.
	 */
	private int movesMade() {
		int currentMove = 0;
		while (currentMove < MAX_ATTEMPTS && history[currentMove] != NO_MOVE_MADE){
			currentMove++;
		}
		return currentMove;
	}

	/**
	 * prints the map.
	 * If you hand it something else than NO_MOVE_MADE and
	 * NO_HINT it will also update the history.
	 *
	 * @param column a chosen column to flush
	 * @param helpTextId a chosen helptextID (from HINTS) or
	 *
	 * DO NOT CHANGE THIS METHOD!
	 */
	private void printMap( int column, int helpTextId ) {
		// Update history
		// This would not write anything even if we did an update
		if( column != NO_MOVE_MADE ) {
			history[movesMade()] = column;
		}
		if( helpTextId != NO_HINT ) {
			historyHelpers[movesMade() - 1] = helpTextId;
		}

		boolean hasWon = column == mineShaftId;
		int currentMove = movesMade();

		System.out.println();
		if( movesMade() > 0 )
			System.out.println( "You flush mine shaft " + getMineShaftAsChar(column)  );
		if( column == mineShaftId ){ // Did we get the orcs?
			System.out.println();
			System.out.println( "You have stopped the orc chieftain!"  );
			System.out.println();
		} else {
				System.out.println();
				System.out.println();
		}
		// Build and print the header.
		String header = "|";
		for(int col = 0; col < MINE_SHAFTS; col++){
			header += String.valueOf( getMineShaftAsChar( col ) ) + "|";
		}
		System.out.println( header + "\n" + getLine() );

		// Build the map
		int row = MAX_ATTEMPTS;
		while( row > 0 ){
			printRow( column, MAX_ATTEMPTS - row, currentMove);
			row -= 1;
		}
		System.out.println( getLine() );


		if ( !hasWon && movesMade() > 0 && movesMade() < MAX_ATTEMPTS){
			System.out.println(
					"Your Seismometer tells you that the orcs are "
							+ HINTS[ helpTextId ] );
		} else if ( movesMade() == MAX_ATTEMPTS ){
			System.out.println( ORCS ); // They got you.
		}

		// Print history:
		System.out.println( getLine() );
		if( movesMade() > 1 ) {
			System.out.println("History: ");
		}
		for( int historyEntry = 0; historyEntry < MAX_ATTEMPTS; historyEntry++ ) {
			int hintId = historyHelpers[ historyEntry ];
			if( hintId < HINTS.length && hintId >= 0 ) {
				System.out.println( ( historyEntry + 1 ) + ".: " + HINTS[ hintId ] );
			}
		}
	}

	/**
	 * A line we can use to structure the map.
	 *
	 * @ return
	 */
	private String getLine() {
		// Add a line of (more or less) correct length.
		char[] line = new char[ 2*MINE_SHAFTS + 1 ];
		Arrays.fill( line, '-' );
		return new String( line );
	}

	/**
	 * Prints a row of the map.
	 *
	 * !!DO NOT CHANGE THIS METHOD UNLESS THE special characters don't work on your stystem!!
	 * (Document it if that's the case)
	 *
	 * @param column The column which the player chose.
	 * @param row The row we want to print.
	 * @param currentGuess The number of the current guess.
	 */
	private void printRow( int column, int row, int currentGuess) {
		if( row == currentGuess ){
			printOrcRow( row );
		}
		else {
			String output = "|";
			for (int col = 0; col < MINE_SHAFTS; col++) {
				// Did the player check this mine shaft?
				boolean checked = false;
				for (int i : history) {
					if (col == i) { //
						checked = true;
					}
				}
				// Is there stone ?
				boolean isThereStone = false;
				if ((col + row) % 2 == 0) {
					isThereStone = true;
				}
				String emptyField = isThereStone ? "#" : " "; // How we draw empty terrain
				String hitTerrain = isThereStone ? "▓" : "░"; // How we draw terrain we have flushed.

				if (row < currentGuess) { // Are we behind the orcs?
					output += (checked ? hitTerrain : "▒");
				} else {
					// Have we hit the chieftain? Celebrate with special character!
					if (column == mineShaftId && col == column && currentGuess == movesMade()) {
						hitTerrain = "■";
					}
					output += (checked ? hitTerrain : emptyField);
				}
				output += "|";
			}
			System.out.println( output );
		}
	}

	/**
	 * Print the row where the orcs are right now.
	 *
	 * !!DO NOT CHANGE THIS METHOD UNLESS THE special characters don't work on your stystem!!
	 *
	 * If DEBUG is set to true, print the exact location instead.
	 * @param row The row where the orcs are supposed to be right now.
	 */
	private void printOrcRow(int row) {
		if (!DEBUG) {
			System.out.println(ORCS);
		} else {
			String output = "|";
			for (int col = 0; col < MINE_SHAFTS; col++) {
				// Did the player check this mine shaft?
				boolean checked = false;
				for (int i : history) {
					if (col == i) { //
						checked = true;
					}
				}
				// Is there stone ?
				boolean isThereStone = false;
				if ((col + row) % 2 == 0) {
					isThereStone = true;
				}
				String emptyField = isThereStone ? "#" : " "; // How we draw empty terrain
				String hitTerrain = isThereStone ? "▓" : "░";

				// Is the chieftain there? Special character
				if (col == mineShaftId) {
					hitTerrain = "■";
				}
				output += hitTerrain;
				output += "|";
			}
			System.out.println(output);
		}
	}

	/**
	 * Determines column's number from its code
	 * here 'a' is 1st column and 'l' is 12th
	 * returns 0 on unrecognised codes
	 *
	 * !!DO NOT CHANGE THIS METHOD!!
	 */
	private int getColumnAsInt( char column ) {
		switch ( column ) {
			case 'a':
				return 0;
			case 'b':
				return 1;
			case 'c':
				return 2;
			case 'd':
				return 3;
			case 'e':
				return 4;
			case 'f':
				return 5;
			case 'g':
				return 6;
			case 'h':
				return 7;
			case 'i':
				return 8;
			case 'j':
				return 9;
			case 'k':
				return 10;
			case 'l':
				return 11;
			default:
				return PARSING_FAILED;
		}
	}

	/**
	 * Determines column's code from its integer
	 * here 'a' is int 0 and 'l' is 11
	 * returns 'z' on unrecognised integers
	 *
	 * !!DO NOT CHANGE THIS METHOD!!
	 */
	private char getMineShaftAsChar( int mineShaft ) {
		switch ( mineShaft ) {
			case 0:
				return 'a';
			case 1:
				return 'b';
			case 2:
				return 'c';
			case 3:
				return 'd';
			case 4:
				return 'e';
			case 5:
				return 'f';
			case 6:
				return 'g';
			case 7:
				return 'h';
			case 8:
				return 'i';
			case 9:
				return 'j';
			case 10:
				return 'k';
			case 11:
				return 'l';
			default:
				return 'z';
		}
	}

	/**
	 * Use this to print the intro screen.
	 *
	 * !!DO NOT CHANGE THIS METHOD UNLESS THE special characters don't work on your stystem!!
	 * (Document it if that's the case)
	 *
	 * @return a String made of orc
	 */
	private String generateOrcIntroScreen() {
		String orc = "                           __,='`````'=/__\n" +
				"                          '//  /-\\ /-\\ \\ `'         _,-,\n" +
				"                          //|     ,_)   (`\\      ,-'`_,-\\\n" +
				"                        ,-~~~\\   /||\\  /-,      \\==```` \\__\n" +
				"                       /        `----'     `\\     \\       \\/\n" +
				"                    ,-`                  ,   \\  ,.-\\       \\\n" +
				"                   /      ,               \\,-`\\`_,-`\\_,..--'\\\n" +
				"                  ,`    ,/,              ,>,   )     \\--`````\\\n" +
				"                  (      `\\`---'`  `-,-'`_,<   \\      \\_,.--'`\n" +
				"                   `.      `--. _,-'`_,-`  |    \\\n" +
				"                    [`-.___   <`_,-'`------(    /\n" +
				"                    (`` _,-\\   \\ --`````````|--`\n" +
				"                     >-`_,-`\\,-` ,          |\n" +
				"                   <`_,'     ,  /\\          /\n" +
				"                    `  \\/\\,-/ `/  \\/`\\_/V\\_/\n" +
				"                       (  ._. )    ( .__. )    **************\n" +
				"                       |      |    |      |    Stop The Orcs!\n" +
				"                        \\,---_|    |_---./     **************\n" +
				"                        ooOO(_)    (_)OOoo" +
				"\nXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
		return orc;
	}
}
