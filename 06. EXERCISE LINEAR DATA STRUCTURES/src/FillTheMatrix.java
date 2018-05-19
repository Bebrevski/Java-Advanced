import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(",\\s+");
        int matrixSize = Integer.parseInt(input[0]);
        String pattern = input[1];

        int[][] matrix = new int[matrixSize][matrixSize];

        if (pattern.equals("A")) {
            fillTheMatrixWithAPattern(matrix);
        } else {
            fillTheMatrixWithBPattern(matrix);
        }

        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void fillTheMatrixWithBPattern(int[][] matrix) {
        int number = 1;
        for (int row = 0; row < matrix.length; row++) {
            if (row % 2 == 0) {
                for (int col = 0; col < matrix[row].length; col++) {
                    matrix[col][row] = number++;
                }
            } else {
                for (int col = matrix[row].length - 1; col >= 0 ; col--) {
                    matrix[col][row] = number++;
                }
            }
        }
    }

    private static void fillTheMatrixWithAPattern(int[][] matrix) {
        int number = 1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[col][row] = number++;
            }
        }
    }
}
