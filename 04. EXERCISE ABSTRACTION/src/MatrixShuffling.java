import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int[] matrixSize = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int rows = matrixSize[0];
        int cols = matrixSize[1];

        String[][] matrix = new String[rows][cols];

        fillMatrixWithData(matrix);

        String commands = scanner.nextLine();

        while (!commands.equals("END")) {

            if (isValid(commands, rows, cols)) {

                swapElements(matrix, commands);

                printMatrix(matrix);

            } else {
                System.out.println("Invalid input!");
            }

            commands = scanner.nextLine();
        }
    }

    private static boolean isValid(String command, int rows, int cols) {

        String[] tokens = command.split("\\s++");

        if (tokens.length != 5 || !"swap".equals(tokens[0])) {
            return false;
        }

        try {
            int row1 = Integer.parseInt(tokens[1]);
            int col1 = Integer.parseInt(tokens[2]);
            int row2 = Integer.parseInt(tokens[3]);
            int col2 = Integer.parseInt(tokens[4]);

            return row1 >= 0 && row1 < rows
                    && col1 >= 0 && col1 < cols
                    && row2 >= 0 && row2 < rows
                    && col2 >= 0 && col2 < cols;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static void swapElements(String[][] matrix, String command) {

        String[] tokens = command.split("\\s++");

        int row1 = Integer.parseInt(tokens[1]);
        int col1 = Integer.parseInt(tokens[2]);
        int row2 = Integer.parseInt(tokens[3]);
        int col2 = Integer.parseInt(tokens[4]);

        String temp = matrix[row1][col1];
        matrix[row1][col1] = matrix[row2][col2];
        matrix[row2][col2] = temp;
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrixWithData(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
    }
}
