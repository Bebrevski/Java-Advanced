import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String[] input = scanner.nextLine().split(",\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        int[][] matrix = new int[rows][cols];

        initializeMatrix(matrix);

        int sum = sumAllMatrixElements(matrix);

        printResult(rows, cols, sum);
    }

    private static void printResult(int rows, int cols, int sum) {
        System.out.printf("%d%n%d%n%d", rows, cols, sum);
    }

    private static int sumAllMatrixElements(int[][] matrix) {
        int sum = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                sum += matrix[row][col];
            }
        }

        return sum;
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
