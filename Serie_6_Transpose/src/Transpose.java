import java.util.Arrays;
import java.lang.Math;


// Lionel Rohner (09-123-696)

// Unfortunately the demonstartion classes are quite ugly and I m sorry for that. I basically replaced the class name
// Matrix with Transpose everywhere. I  first made a class Transpose or Product and replaced the main method of my Matrix
// class, but I kept on getting an "java : cannot find symbol java" because of the matrixTranspose method, all other
// methods worked fine. I didn't find the error.


public class Transpose {


    private int rows;
    private int cols;
    int[][] array; // matrix

    public static void main(String[] args){
        System.out.println("\n" + "Transpose Demonstration" + "\n");

        Transpose matrix = new Transpose(3,3);

        int[] valuesmatrix = {1,2,3,4,5,6,7,8,9}; // works for different order matrices


        matrix.setMatrixValues(valuesmatrix); // make 0 matrix of specified order

        matrix.getMatrixValues(); // add elements of choice

        System.out.println("\nTransposing...\n");

        Transpose matrixTransposed = transposeMatrix(matrix);

        matrixTransposed.getMatrixValues();

    }

    // constructor (randomly generates matrix)
    public Transpose(int rows, int cols){

        this.rows = rows;
        this.cols = cols;

        array = new int[rows][cols];
        int cnt = 0;

        int matrixElements = 0;

        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols ; j++)
            {
                array[i][j] = matrixElements;
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

        int klimit = 0;

        int tempSum = 0;

        Transpose matrixMult = new Transpose(maxRow,maxCol);

        if (matrix1.getCols() > matrix2.getRows()){
            klimit = matrix2.getRows();
        } else {
            klimit = matrix1.getCols();
        }


        for(int i=0; i < matrix1.getRows();i++) {

            for (int j = 0; j < matrix2.getCols(); j++) {



                for (int k = 0; k < klimit; k++) {

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
    public void setMatrixValues(int[] values) {

        int cnt = 0;

        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols ; j++)
            {
                array[i][j] = values[cnt];
                cnt += 1;
            }
        }
    }




    // shows matrix as [[a11 a12 a13][a21 a22 a23][a31 a32 a33]]
    public String toString(){
        String result = Arrays.deepToString(array);
        return result;
    }


}


