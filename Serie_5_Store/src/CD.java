/* ************************************************************************* *\
*                Programmierung 1 HS 2020 - Serie 5-2                         *
\* ************************************************************************* */

// Lionel Rohner (09-123-696)

public class CD implements IArticle
{
    private int id;
    private String title;
    private String interpret;
    private int year;
    private int price; // CHF

    /** constructor */
    public CD( int id, String title, String author, int year, int price )
    {
        this.id = id;
        this.title = title;
        this.interpret = interpret;
        this.year = year;
        this.price = price;
    }

    public String getDescription()
    {
        return id + " (CD) " + title + ", by " + interpret +
                ", " + year + ", " + price + " CHF";
    }

    public int getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }
}