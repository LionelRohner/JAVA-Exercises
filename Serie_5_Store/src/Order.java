/* ************************************************************************* *\
*                Programmierung 1 HS 2020 - Serie 5-2                         *
\* ************************************************************************* */

// Lionel Rohner (09-123-696)

import javax.swing.plaf.synth.SynthMenuBarUI;
import java.util.ArrayList;
import java.util.Date;
import java.lang.reflect.Field;

public class Order {

    // Variablen definieren
    private int id;
    private String customerName;
    private String customerAddress;
    // neuer Array names "articles" wird definiert, welche IArticle Objekte abspeichert
    private ArrayList<IArticle> itemList = new ArrayList<IArticle>();

    // Ich weiss nicht wie man da einen Iterable benutzten soll? Wenn ich den Iterable benutze kann ich die add
    // Methode nicht mehr benutzten.
//    private Iterable<IArticle> itemList = new Iterable<IArticle>();

    // Konstrukor: Bei jeder Instanzierung wird die id um eins inkrementiert; keine obere Limite
    public Order (){
        id ++;
    }


    // Artikel zum "articles" Array hinzufügen
    public void add (IArticle a) {
        itemList.add(a);
    }


    public int getTotalPrice() {
        // Gesamt Summe auf 0 setzten
        int total = 0;

        // Es wird durch den "articles" Array iteriert
        for (IArticle a: itemList) {
            // Der Output von "getPrice" wird zum total hinzugefügt
            total += a.getPrice();
        }
        return total;}

    //setters
    public void setCustomerName(String customerName)
    {
        this.customerName = customerName;
    }

    public void setCustomerAddress(String customerAddress)
    {
        this.customerAddress = customerAddress;
    }

    // Getters
    public String getCustomerName()
    {
        return customerName;
    }

    public String getCustomerAddress()
    {
        return customerAddress;
    }

    public int getId()
    {
        return id;
    }

    // geht nicht
//    public Iterable<IArticle> getOrderedArticles() {
//        return new Iterable<IArticle>(itemList);
//    }

    public ArrayList<IArticle> getOrderedArticles()
    {
        return new ArrayList<IArticle>(itemList);
    }

}
