import java.util.Arrays;
import java.util.Scanner;

public class diagonalDifference {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int squareSize = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[squareSize][squareSize];

        initializeMatrix(matrix);

        int difference = getDiagonalDifference(matrix);

        System.out.println(difference);
    }

    private static int getDiagonalDifference(int[][] matrix) {

        int leftToRightSum = 0;
        for (int size = 0; size < matrix.length; size++) {
          leftToRightSum += matrix[size][size];
        }

        int rightToLeftSum = 0;
        for (int size = 0; size < matrix.length; size++) {
            rightToLeftSum += matrix[size][matrix.length - size - 1];
        }

        return Math.abs(leftToRightSum - rightToLeftSum);
    }

    private static void initializeMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {

            int[] inputLineNumbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = inputLineNumbers[col];
            }
        }
    }
}
