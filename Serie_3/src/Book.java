/* ************************************************************************* *\
*                Programmierung 1 HS 2020 - Serie 3-1                         * 
\* ************************************************************************* */

import java.util.Date;
import java.util.Scanner;
import java.text.*;

public class Book
{
	private int id;
	private String title;
	private String author;
	private Date dateOfPublication;

	public static final String DATE_FORMAT = "dd.MM.yyyy";

	//--- constructors ---

	// TODO: Insert your code here!
	Book book1, book2;


	/** Returns the age of the book in days since publication */
	public int age()
	{
		// TODO: Insert your code here!

		return 0; //this is to avoid compiler errors, replace it!
	}

	/** Returns a String representation of the book */
	public String toString()
	{
		// TODO: Insert your code here!
		return ""; //this is to avoid compiler errors, replace it!
	}

	/** Reads all book data from user input */
	public void input() 
	{
		Scanner scn = new Scanner( System.in );
		System.out.print( "Please enter id: " );

		// TODO: Insert your code here!

	}

	//--- Get-/Set-methods ---

	// TODO: Insert your code here!

	//--- helper methods -- DO NOT CHANGE ------------------------------------
	/** Converts the Date object d into a String object */
	public static String dateToString( Date d )
	{
		SimpleDateFormat fmt = new SimpleDateFormat( DATE_FORMAT );
		return fmt.format( d );
	}

	/** Converts the String object s into a Date object */
	public static Date stringToDate( String s ) 
	{
		Date r = null;
		try {
			SimpleDateFormat fmt = new SimpleDateFormat( DATE_FORMAT );
			r = fmt.parse( s );
		} catch ( ParseException e ){
			System.err.println( e );
			System.exit(1);
		}
		return r;
	}
}
