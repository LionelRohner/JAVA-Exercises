import java.util.Random;
import java.util.Arrays;

public class Matrix {


    private int n; // rows
    private int m; // cols
    private int[][] A; // matrix

    public static void main(String[] args){
        Matrix A = new Matrix(4,4);

        A.getMatrixValues();

        System.out.println("\n");

        transposeMatrix(A);

        A.getTransposedValues();
    }

    // constructor (randomly generates matrix)
    public Matrix(int rows, int cols){

        n = rows;
        m = cols;

        A = new int[rows][cols];

        Random r = new Random();
//        r.setSeed(1);

        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols ; j++)
            {
                A[i][j] = r.nextInt(20);
            }
        }
    }

    // print matrix
    public void getMatrixValues(){
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                System.out.print(A[i][j]+"\t");
            }

            System.out.print("\n");
        }
    }

    // print transposed matrix
    public void getTransposedValues(){
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                System.out.print(A[j][i]+"\t");
            }

            System.out.print("\n");
        }
    }

    // print transposed matrix

//    public static double[][] transposeMatrix(double [][] m){
//        double[][] temp = new double[m[0].length][m.length];
//        for (int i = 0; i < m.length; i++)
//            for (int j = 0; j < m[0].length; j++)
//                temp[j][i] = m[i][j];
//        return temp;
//    }
//
    public static Matrix transposeMatrix(Matrix A){

        int[][] AT = new int[A.get_n()][A.get_m()];

        for(int i = 0; i < A.get_n(); i++)
        {
            for(int j = 0; j < A.get_m(); j++)
            {
                AT[j][i] = A[i][j];
            }
        }

    return AT;
    }


    public int get_n(){
        return n;
    }

    public int get_m(){
        return m;
    }
//    public int dimMatrix(Matrix A){
//        int[][] dimension;
//
//
//    }



    // shows matrix as [[a11 a12 a13][a21 a22 a23][a31 a32 a33]]
    public String toString(){
        String result = Arrays.deepToString(A);
        return result;
    }


}


