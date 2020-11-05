import javax.swing.plaf.synth.SynthMenuBarUI;

public class Increment {

    public static void main ( String [] args ) {
            Num n1 = new Num (1);
            int n2 = 10;
            modify (n1);
            modify (n2);

            System.out.println("n1 " + n1);
            System.out.println("n2 " + n2);


    }
    public static void modify (Num num ){ num.setValue (100); }
    public static void modify (int n)
    {
        this.n =100;

    }


}

