package Array1d;

import java.util.Scanner;

public class FindTheFlippedCell_soln {
    public static final Scanner input = new Scanner(System.in);
    public static int[] sumH(int[][] matrix) {
        int[] hSums = new int[matrix.length];
        for (int row = 0; row < matrix.length; row++) {
            int hSum = 0;
            for (int col = 0; col < matrix[row].length; col++) {
                hSum += matrix[row][col];
            }
            hSums[row] = hSum;
        }
        return hSums;
    }

    public static int[] sumV(int[][] matrix) {
        int[] vSums = new int[matrix[0].length];
        for (int col = 0; col < matrix[0].length; col++) {
            int vSum = 0;
            for (int row = 0; row < matrix.length; row++) {
                vSum += matrix[row][col];
            }
            vSums[col] = vSum;
        }
        return vSums;
    }

    public static int[][] initMatrix() {
        int[][] matrix = new int[6][6];
        System.out.println("Enter a 6−by−6 matrix row by row:");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                matrix[i][j] = input.nextInt();
            }
        }
        return matrix;
    }

    public static int[] findFlippedCell(int[] hSum, int[] vSum) {
        for (int i = 0; i < hSum.length; i++) {
            for (int j = 0; j < vSum.length; j++) {
                if (hSum[i] == vSum[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    public static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.printf("%d ", matrix[row][col]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%d ", array[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] matrix = initMatrix();
        printMatrix(matrix);

        int[] hSum = sumH(matrix);
        int[] vSum = sumV(matrix);

        int[] coords = findFlippedCell(hSum, vSum);
        System.out.printf("The flipped cell is at: (%d,%d)", coords[0], coords[1]);

    }
}
