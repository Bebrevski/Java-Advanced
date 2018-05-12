import java.util.Arrays;
import java.util.Scanner;

public class MaximumSum {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int[] matrixSize = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int rows = matrixSize[0];
        int cols = matrixSize[1];

        int[][] matrix = new int[rows][cols];

        fillMatrixWithData(matrix);

        int[][] outputMatrix = new int[3][3];
        int maxSum = getMaxSumOfElements(matrix, outputMatrix);

        printResult(outputMatrix, maxSum);
    }

    private static void printResult(int[][] outputMatrix, int maxSum) {

        System.out.printf("Sum = %d%n", maxSum);

        for (int row = 0; row < outputMatrix.length; row++) {
            for (int col = 0; col < outputMatrix[row].length; col++) {
                System.out.print(outputMatrix[row][col] + " ");
            }

            System.out.println();
        }
    }

    private static int getMaxSumOfElements(int[][] matrix, int[][] outputMatrix) {
        int maxSum = 0;

        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {
                int currentSum = getCurrentSumOfElements(row, col, matrix);

                if (currentSum > maxSum) {
                    maxSum = currentSum;

                    fillSecondaryMatrix(matrix, outputMatrix, row, col);
                }
            }
        }

        return  maxSum;
    }

    private static void fillSecondaryMatrix(int[][]matrix, int[][] outputMatrix, int row, int col) {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                outputMatrix[r][c] = matrix[row + r][col + c];
            }
        }
    }

    private static int getCurrentSumOfElements(int row, int col, int[][] matrix) {
        int sum = 0;
        for (int r = row; r < row + 3; r++) {
          for (int c = col; c < col + 3; c++) {
            sum += matrix[r][c];
          }
        }

        return sum;
    }

    private static void fillMatrixWithData(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {

            int[] inputLine = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = inputLine[col];
            }
        }
    }
}
