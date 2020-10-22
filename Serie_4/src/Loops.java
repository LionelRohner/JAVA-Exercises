public class Loops {

    // Lionel Rohner (09-123-696)

    public static void main ( String[] args ){

        // Aufgabe 4-2-1

        System.out.println("\n while-loop \n");
        int i=1;
        while (i <10){
            i++;
            System.out.println(i);
        }
        System.out.println("\n for-loop \n");
        for (int j=2; j < 11; j++){
            System.out.println(j);
        }

        System.out.println("\n do-loop \n");
        int k=2;
        do{
            System.out.println(k);
            k++;
        }while(k<=10);



    }

}
