import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int degrees = getDegrees(scanner);

        char[][] matrix = fillData(scanner);

        matrix = rotateMatrix(matrix, degrees);

        print(matrix);
    }

    private static void print(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
          for (int col = 0; col < matrix[row].length; col++) {
              System.out.print(matrix[row][col]);
          }
            System.out.println();
        }
    }

    private static char[][] rotateMatrix(char[][] matrix, int degrees) {
        char[][] rotatedMatrix;

        if (degrees == 90) {
            rotatedMatrix = new char[matrix[0].length][matrix.length];

            for (int row = 0; row < matrix[0].length; row++) {
                for (int col = 0; col < matrix.length; col++) {
                    rotatedMatrix[row][col] = matrix[matrix.length - 1 - col][row];
                }
            }
        } else if (degrees == 180) {
            rotatedMatrix = new char[matrix.length][matrix[0].length];

            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[0].length; col++) {
                    rotatedMatrix[row][col] = matrix[matrix.length - 1 - row][matrix[0].length - 1 - col];
                }
            }
        } else if (degrees == 270) {
            rotatedMatrix = new char[matrix[0].length][matrix.length];

            for (int row = 0; row < matrix[0].length; row++) {
                for (int col = 0; col < matrix.length; col++) {
                    rotatedMatrix[row][col] = matrix[col][matrix[0].length - 1 - row];
                }
            }
        } else {
            rotatedMatrix = matrix;
        }

        return rotatedMatrix;
    }

    private static char[][] fillData(Scanner scanner) {
        List<String> input = new ArrayList<>();
        int maxLength = 0;
        String line = scanner.nextLine();

        while (!line.equals("END")) {
            input.add(line);

            maxLength = Math.max(maxLength, line.length());

            line = scanner.nextLine();
        }

        char[][] matrix = new char[input.size()][maxLength];

        for (int row = 0; row < input.size(); row++) {
            Arrays.fill(matrix[row], ' ');
            System.arraycopy(input.get(row).toCharArray(), 0, matrix[row], 0, input.get(row).length());
        }

        return matrix;
    }

    private static int getDegrees(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine().replaceAll("\\D+", "")) % 360;
    }
}
