public class Increment {

    public static void main ( String [] args ) {
            Num n1 = new Num (1);
            int n2 = 10;
            modify (n1 );
            modify (n2 );
    }
    public static void modify (Num num ){ num . setValue (100); }
    public static void modify (int n) { n =100; }
}

