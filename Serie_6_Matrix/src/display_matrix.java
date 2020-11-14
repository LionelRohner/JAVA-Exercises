import java.util.Random;
import java.util.Arrays;

public class display_matrix {

    public static void main(String[] args){
        Matrix A = new Matrix(4,4);

        A.getMatrixValues();

        System.out.println(A.toString());
    }
}

