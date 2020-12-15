import java.util.Random;
import java.util.Arrays;
import java.lang.Math;

import static java.lang.Integer.max;

// Linel ROhner (09-123-696)

// The matrix class allows to generate random matrices with values between 0 and 9 (can be changed on line 66)
// The class has two main methods transposeMatrix and matrixMultiplication.


public class Matrix {


    private int rows;
    private int cols;
    int[][] array; // matrix

    public static void main(String[] args){
        Matrix matrix = new Matrix(2,4);

        matrix.getMatrixValues();

        System.out.println("\n" + "Transposing..." + "\n");

        Matrix transposeMatrix = transposeMatrix(matrix);

        transposeMatrix.getMatrixValues();

        System.out.println("\n" + "Matrix Multiplication (same order, rectangular matrices)" + "\n");

        Matrix matrixA = new Matrix(3,4);
        Matrix matrixB = new Matrix(3,4);

        matrixA.getMatrixValues();

        System.out.println("\n");

        matrixB.getMatrixValues();

        System.out.println("\n");

        Matrix matrixC = matrixMultiplication(matrixA, matrixB);

        matrixC.getMatrixValues();

        System.out.println("\n" + "Matrix Multiplication (different order matrices)" + "\n");

        Matrix matrixA2 = new Matrix(4,3);
        Matrix matrixB2 = new Matrix(3,4);

        matrixA2.getMatrixValues();

        System.out.println("\n");

        matrixB2.getMatrixValues();

        System.out.println("\n");

        Matrix matrixC2 = matrixMultiplication(matrixA2, matrixB2);

        matrixC2.getMatrixValues();

        System.out.println("\n" + "Matrix Multiplication (square matrices)" + "\n");

        Matrix matrixA3 = new Matrix(3,3);
        Matrix matrixB3 = new Matrix(3,3);

        matrixA3.getMatrixValues();

        System.out.println("\n");

        matrixB3.getMatrixValues();

        System.out.println("\n");

        Matrix matrixC3 = matrixMultiplication(matrixA3, matrixB3);

        matrixC3.getMatrixValues();

        System.out.println("\n" + "To String Method" + "\n");

        System.out.println(matrixC3.toString());
    }

    // constructor (randomly generates matrix)
    public Matrix(int rows, int cols){

        this.rows = rows;
        this.cols = cols;

        array = new int[rows][cols];

        Random r = new Random();


//        r.setSeed(1); // for replication

        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols ; j++)
            {
                array[i][j] = r.nextInt(10);
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


    public static Matrix transposeMatrix(Matrix matrix) {
        Matrix matrixTransposed = new Matrix(matrix.getCols(), matrix.getRows());

        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getCols(); j++) {
                matrixTransposed.set(j, i, matrix.get(i, j));
            }
        }
        return matrixTransposed;
    }


    public static Matrix matrixMultiplication(Matrix matrix1, Matrix matrix2) {
        int maxRow = Math.max(matrix1.getRows(), matrix2.getRows());
        int maxCol = Math.max(matrix1.getCols(), matrix2.getCols());

        int klimit = -1;
        int tempSum = 0;
        Matrix matrixMult = new Matrix(maxRow,maxCol);


        if (matrix1.getCols() > matrix2.getRows()){
            klimit = matrix2.getRows();
        } else {
            klimit = matrix1.getCols();
        }


        //multiplying and printing multiplication of 2 matrices
        for(int i = 0; i < matrix1.getRows(); i++) {

            for (int j = 0; j < matrix2.getCols(); j++) {

                matrixMult.set(i,j,0);

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


    // shows matrix as [[a11 a12 a13][a21 a22 a23][a31 a32 a33]]
    public String toString(){
        String result = Arrays.deepToString(array);
        return result;
    }


}


