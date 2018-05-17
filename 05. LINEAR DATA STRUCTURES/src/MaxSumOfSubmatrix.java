import java.util.Arrays;
import java.util.Scanner;

public class MaxSumOfSubmatrix {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String[] input = scanner.nextLine().split(",\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        int[][] matrix = new int[rows][cols];

        initializeMatrix(matrix);

        int outputData[] = findMaximumSumAndIndexes(matrix);

        printResult(outputData, matrix);
    }

    private static void printResult(int[] output, int[][] matrix) {

        int startRowIndex = output[0];
        int startColIndex = output[1];

        System.out.printf("%d %d%n", matrix[startRowIndex][startColIndex], matrix[startRowIndex][startColIndex + 1]);
        System.out.printf("%d %d%n", matrix[startRowIndex + 1][startColIndex], matrix[startRowIndex + 1][startColIndex + 1]);
        System.out.printf("%d", output[2]);
    }

    private static int[] findMaximumSumAndIndexes(int[][] matrix) {

        int maxSum = 0;
        int startRowIndex = 0;
        int startColIndex = 0;

        int[] data = new int[3];

        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int currentSum = matrix[row][col] + matrix[row][col + 1] +
                        matrix[row + 1][col] + matrix[row + 1][col + 1];

                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    startRowIndex = row;
                    startColIndex = col;
                }
            }
        }

        data[0] = startRowIndex;
        data[1] = startColIndex;
        data[2] = maxSum;

        return  data;
    }

    private static void initializeMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {

            int[] inputLine = Arrays.stream(scanner.nextLine().split(",\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = inputLine[col];
            }
        }
    }
}
