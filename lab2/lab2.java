//C5 = 3 C = A ⊕ B ( C = (!A)*B + A*(!B) )
//C7 = 6 float
//C11 = 2 сумма максимальных с каждого столбца

import java.util.Random;
import java.util.Scanner;

public class lab2 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Number of columns and rows: ");
        int rowsColumns = in.nextInt();

        Random r = new Random();

        float[][] firstMatrix = new float[rowsColumns][rowsColumns];
        float[][] secondMatrix = new float[rowsColumns][rowsColumns];

        System.out.println("Matrix A: ");
        matrixRandom(rowsColumns, r, firstMatrix);
        System.out.println("Matrix B: ");
        matrixRandom(rowsColumns, r, secondMatrix);

        float[][] InvertedA = firstMatrix;
        float[][] InvertedB = secondMatrix;

        matrixInversion(InvertedA, rowsColumns);
        matrixInversion(InvertedB, rowsColumns);

        matrixMultiplication(firstMatrix, InvertedB, rowsColumns);
        matrixMultiplication(secondMatrix, InvertedA, rowsColumns);

        matrixSum(firstMatrix, secondMatrix, rowsColumns);

        System.out.println("Matrix C = A ⊕ B: ");

        for(float[] row : firstMatrix) {
            for (float column : row) {
                System.out.print(column + "\t");
            }
            System.out.println();
        }

        float[] result = new float[rowsColumns];

        for (int i = 0; i < rowsColumns; i++) {
            float max = firstMatrix[0][i];
            for (int j = 0; j < rowsColumns; j++) {
                if(firstMatrix[j][i] > max) max = firstMatrix[j][i];
            }
            result[i] = max;
        }

        System.out.println("Biggest number in each column: ");

        float summ = 0;

        for (int i = 0; i < rowsColumns; i++) {
            System.out.println(result[i]);
            summ += result[i];
        }

        System.out.println("Sum of biggest numbers: " + summ);

    }

    private static void matrixRandom(int rowsColumns, Random r, float[][] Matrix) {
        for(int i=0; i < rowsColumns; i++) {
            for (int j = 0; j < rowsColumns; j++) {
                Matrix[i][j] = (r.nextFloat() * 40 - 20);
                System.out.print(Matrix[i][j] + "\t");
            }
            System.out.print("\n");
        }
    }

    private static void matrixInversion(float[][] A, int N) {

        float temp;

        float [][] E = new float [N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                E[i][j] = 0;

                if (i == j)
                    E[i][j] = 1;
            }
        }

        for (int k = 0; k < N; k++) {

            temp = A[k][k];

            for (int j = 0; j < N; j++) {
                A[k][j] /= temp;
                E[k][j] /= temp;
            }

            for (int i = k + 1; i < N; i++) {
                temp = A[i][k];

                for (int j = 0; j < N; j++) {
                    A[i][j] -= A[k][j] * temp;
                    E[i][j] -= E[k][j] * temp;
                }
            }
        }

        for (int k = N - 1; k > 0; k--) {
            for (int i = k - 1; i >= 0; i--) {
                temp = A[i][k];

                for (int j = 0; j < N; j++) {
                    A[i][j] -= A[k][j] * temp;
                    E[i][j] -= E[k][j] * temp;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.arraycopy(E[i], 0, A[i], 0, N);
        }

    }

    private static void matrixMultiplication(float[][] A, float[][] B, int rowsColumns) {
        for (int i = 0; i < rowsColumns; i++) {
            for (int j = 0; j < rowsColumns; j++) {
                for (int k = 0; k < rowsColumns; k++) {
                    A[i][j] += A[i][k] * B[k][j];
                }
            }
        }
    }

    private static void matrixSum(float[][] A, float[][] B, int rowsColumns) {
        for(int i = 0; i < rowsColumns; i++) {
            for (int j = 0; j < rowsColumns; j++) {
                A[i][j] = A[i][j] + B[i][j];
            }
        }
    }

}
