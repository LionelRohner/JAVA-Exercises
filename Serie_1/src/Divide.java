import java.util.Scanner;

public class Divide {

    // Lionel Rohner (09-123-696)

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Formel : a^2/b");
        System.out.println("Eingabe für Variable  a: ");

        int a = input.nextInt();
        float a2 = a; // Für die Floatdivision wird die Variable a kopiert und als float in der Varaible a2 gespeichert

        System.out.println("Eingabe für Variable b: ");

        int b = input.nextInt();
        float b2 = b; // Gleiche Idee wie in der Zeile 14

        int rslt = a*a/b;
        int rslt_rmndr = a*a%b;
        float rslt_flt = a2*a2/b2;

        System.out.println("Das Resultat der Integerdivision ist : "+ rslt + " (Rest = " + rslt_rmndr + ")");
        System.out.println("Das Resultat der Floatdivision ist : " + rslt_flt);
    }
}
