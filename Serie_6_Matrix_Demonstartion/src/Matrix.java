import java.util.Arrays;
import java.lang.Math;

public class Matrix {


    private int rows;
    private int cols;
    int[][] array; // matrix

    public static void main(String[] args){
        Transpose matrix = new Transpose(3,3);

        matrix.getMatrixValues();

        System.out.println("\n" + "Transposing..." + "\n");

        Transpose transposeMatrix = transposeMatrix(matrix);

        transposeMatrix.getMatrixValues();


    }

    // constructor (randomly generates matrix)
    public Transpose(int rows, int cols){

        this.rows = rows;
        this.cols = cols;

        array = new int[rows][cols];
        int cnt = 0;

        int[] matrixElements = {1,2,3,4,5,6,7,8,9};

        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols ; j++)
            {
                array[i][j] = matrixElements[cnt];
                cnt += 1;
            }
        }
    }

    // print matrix
    public void getMatrixValues(){
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                System.out.print(array[i][j]+"\t");
            }

            System.out.print("\n");
        }
    }

    // print transposed matrix
    public void getTransposedValues(){
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                System.out.print(array[j][i]+"\t");
            }

            System.out.print("\n");
        }
    }


    public static Transpose transposeMatrix(Transpose matrix) {
        Transpose matrixTransposed = new Transpose(matrix.getCols(), matrix.getRows());

        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getCols(); j++) {
                matrixTransposed.set(j, i, matrix.get(i, j));
            }
        }
        return matrixTransposed;
    }


    public static Transpose matrixMultiplication(Transpose matrix1, Transpose matrix2) {
        int maxRow = Math.max(matrix1.getRows(), matrix2.getRows());
        int maxCol = Math.max(matrix1.getCols(), matrix2.getCols());

        int tempSum = 0;
        Transpose matrixMult = new Transpose(maxRow,maxCol);

        //multiplying and printing multiplication of 2 matrices
        for(int i=0;i<maxRow;i++) {

            for (int j = 0; j < maxCol; j++) {

                matrixMult.set(i,j,0);

                for (int k = 0; k < 3; k++) {

                    tempSum += matrix1.get(i,k) * matrix2.get(k,j);

                }
                matrixMult.set(i,j, tempSum);
                tempSum = 0;
            }

        }

        return matrixMult;
    }


    // getters and setters
    public int getRows(){
        return rows;
    }

    public int getCols(){
        return cols;
    }

    public int get(int i, int j) {
        return array[i][j];
    }
    public void set(int i, int j, int value) {
        array[i][j] = value;
    }


    // shows matrix as [[a11 a12 a13][a21 a22 a23][a31 a32 a33]]
    public String toString(){
        String result = Arrays.deepToString(array);
        return result;
    }


}


