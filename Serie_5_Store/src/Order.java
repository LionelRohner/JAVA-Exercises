import javax.swing.plaf.synth.SynthMenuBarUI;
import java.util.ArrayList;
import java.util.Date;
import java.lang.reflect.Field;

public class Order {

    // Variablen definieren
    static int id;
    private String customerName;
    private String customerAddress;
    private ArrayList<IArticle> item = new ArrayList<IArticle>();

    // Konstrukor: Bei jeder Instanzierung wird die id um eins inkrementiert
    public Order (){
        id ++;
    }


    // Artikel hinzufügen
    public void add (IArticle a) {
        item.add(a);
    }


    public int getTotalPrice() {
        int totalPrice = 0;
        for (IArticle a: item) {
            totalPrice += a.getPrice();
        }
        return totalPrice;}

    //setters
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    // Getters
    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public int getId(){
        return id;
    }

    public ArrayList<IArticle> getOrderedArticles() {
        return new ArrayList<IArticle>(item);
    }

}
