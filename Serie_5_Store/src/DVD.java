/* ************************************************************************* *\
*                Programmierung 1 HS 2020 - Serie 5-2                         *
\* ************************************************************************* */

// Lionel Rohner (09-123-696)

public class DVD implements IArticle
{
    private int id;
    private String title;
    private int year;
    private int price; // CHF

    /** constructor */
    public DVD( int id, String title, int year, int price )
    {
        this.id = id;
        this.title = title;
        this.year = year;
        this.price = price;
    }

    public String getDescription()
    {
        return id + " (DVD) " + title + ", by " +
                ", " + year + ", " + price + " CHF";
    }

    public int getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }
}