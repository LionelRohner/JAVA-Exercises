/* ************************************************************************* *\
*                Programmierung 1 HS 2020 - Serie 3-1                         * 
\* ************************************************************************* */

// Lionel Rohner

import java.util.Date;
import java.util.Scanner;
import java.text.*;
import java.util.Scanner;

public class Book
{
	private int id;
	private String title;
	private String author;
	private Date dateOfPublication;

	public static final String DATE_FORMAT = "dd.MM.yyyy";

	//--- constructors ---

	// TODO: Insert your code here!

	// Konstruktor mit direkter Eingabe
	public Book (int id, String title, String author,  Date dateOfPublication)
	{
		this.id = id;
		this.title = title;
		this.author = author;
		this.dateOfPublication = dateOfPublication;
	}

	// Konstruktor für leere Book Objekte
	public Book(){

	}

	/** Returns the age of the book in days since publication */
	public int age()
	{
		// TODO: Insert your code here!
		Date now = new Date();

		// Ein Tag sind 8.64e+7 Millisekunden
		double CONVERSION = 8.64e+7f;

		// get.time() gibt die Anzahl Millisekunden seit 01.01.1970. Wenn dateOfPublication for 1970 liegt ist die Zahl
		// negativ. Difference wäre in diesem Fall die Anzahl Millisekunden von jetzt bis 1970 minus minus (also plus)
		// die Spanne von 1970 bis zum Zeitpunkt,der vor 1970 liegt.
		double difference = (now.getTime() - dateOfPublication.getTime())/CONVERSION; //
		return (int) difference;
	}

	/** Returns a String representation of the book */
	public String toString()
	{
		// TODO: Insert your code here!

		return  id + ", " + title + ", " + author + ", " + dateToString(dateOfPublication);
	}

	/** Reads all book data from user input */
	public void input() 
	{
		// TODO: Insert your code here!
		Scanner scanner = new Scanner(System.in);
		System.out.print("Geben Sie eine ID ein: ");
		id = Integer.parseInt(scanner.nextLine());

		System.out.print("Bitte geben Sie das Veröffentlichungsdatum an (z.B. 01.01.2020) : ");
		dateOfPublication = stringToDate(scanner.nextLine());

		System.out.print("Bitte geben Sie den Titel an: ");
		title = scanner.nextLine();

		System.out.print("Bitte geben Sie den Namen des Authors ein: ");
		author = scanner.nextLine();

	}

	//--- Get-/Set-methods ---

	// TODO: Insert your code here!
	// Setter um ID zu ändern. Muss void sein, da der Setter nichts returned.
	public void setID(int id)
	{
		this.id = id;
	}

	public String getID()
	{
		return ("Title: " + title);
	}

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
