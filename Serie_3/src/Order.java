import javax.swing.plaf.synth.SynthMenuBarUI;
import java.util.Date;
import java.lang.reflect.Field;

public class Order {

    // Variablen definieren
    private int id = 1;
    private final int MAX = 5;
    private String customerName;
    private String customerAddress;
    private Book b1, b2, b3, b4, b5;

    // Konstrukor: Bei jeder Instanzierung wird die id um eins inkrementiert
    public Order (){
        if (id < MAX) {
            id++;
        } else {
            System.out.println("Es können nur 5 Bücher pro Bestellung definiert werden!");
        }
    }

    // Instanzeirungsmethode
    public void addBook(Book name) {
        if (b1 == null) {
            b1=name;
        } else if (b2 == null) {
            b2=name;
        } else if (b3 == null) {
            b3=name;
        } else if (b4 == null) {
            b4=name;
        } else if (b5 == null) {
            b5 = name;
        }
    }

    // Die toString Methode muss bei jedem Buch überprüfen, ob es existiert. Wenn man die toString() einzeln aufruft,
    // dann gibt es einen Fehler, da in der ersten Bestellung Buch 5 nicht enthalten ist.
    public String toString() {
        String concBooks = "";
        if (b1 != null) {concBooks += b1.toString();
            if (b2 != null) {concBooks +="\n"+ b2.toString();
                if (b3 != null) {concBooks += "\n"+b3.toString();
                    if (b4 != null) {concBooks += "\n"+b4.toString();
                        if (b5 != null) {concBooks += "\n"+b5.toString();
                        }
                    }
                }
            }
        }
        return ("Order id: " + id + ", Customer: " + customerName + ", " + customerAddress + "\n" + concBooks);

    }




    // Setters
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerAddress(String customerAddress) {
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

    public Book getBook1()
    {
        return b1;
    }

    public Book getBook2()
    {
        return b2;
    }

    public Book getBook3()
    {
        return b3;
    }

    public Book getBook4()
    {
        return b4;
    }

    public Book getBook5()
    {
        return b5;
    }
}
