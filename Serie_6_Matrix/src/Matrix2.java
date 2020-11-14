import java.util.Arrays;
import java.util.Scanner;

public class Matrix2 {

//State Variables: Private state varibles were created so that they could not be accidently accessed. Each iteration of the Matrix Class with have it's own m,numberOfRows and numberOfColumns.

    private double[][] m;
    private int numberOfRows;
    private int numberOfColumns;

    public static void main (String[] args){
        Matrix2 A = new Matrix2(4,4);

        A.getMatrixValues();

        System.out.println(A.toString());
    }

//Constructors: Two constructors were created. The first, takes two ints as parameters for the shape of the matrix and initializes the elements to 0. The second has no parameters, but instead asks the user to supply the shape and element values via scanner.

    public Matrix2(int rows, int columns) {
        numberOfRows = rows;
        numberOfColumns = columns;
        m = new double[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                m[i][j] = 0;
            }
        }
    }

    public String toString(){
        String result = Arrays.deepToString(m);
        return result;
    }

//    public String toString()
//    {
//        String es = new String();
//
//        for(int i = 0; i < numberOfRows; i++)
//        {
//            for(int j = 0; j < numberOfColumns; j++)
//            {
//                es += "[";
//                es += m[i][j];
//                es += "]";
//            }
//            es += '\n';
//        }
//        System.out.println();
//        System.out.println("Your matrix: ");
//        return es;
//    }
    public void getMatrixValues(){
        for(int i=0;i<numberOfRows;i++)
        {
            for(int j=0;j<numberOfColumns;j++)
            {
                System.out.print(m[i][j]+"\t");
            }

            System.out.print("\n");
        }
}

}

