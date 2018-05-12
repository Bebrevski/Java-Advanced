import java.util.Scanner;

public class fillMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(",\\s+");
        int matrixSize = Integer.parseInt(input[0]);
        String pattern = input[1];

        int[][] matrix = new int[matrixSize][matrixSize];

        if (pattern.equals("A")) {
            fillMatrixWithAPattern(matrix);
        } else {
            fillMatrixWithBPattern(matrix);
        }

        printMatrix(matrix);
    }

    private static void fillMatrixWithBPattern(int[][] matrix) {
        int fill = 1;

        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = fill++;
            }

            if (++col < matrix.length) {
                for (int row = matrix.length - 1; row >= 0; row--) {
                    matrix[row][col] = fill++;
                }
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrixWithAPattern(int[][] matrix) {
        int fill = 1;

        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix[col].length; row++) {
                matrix[row][col] = fill;
                fill++;
            }
        }
    }
}
