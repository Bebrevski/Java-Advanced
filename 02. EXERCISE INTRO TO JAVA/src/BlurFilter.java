import java.util.Arrays;
import java.util.Scanner;

public class BlurFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int blur = Integer.parseInt(scanner.nextLine());
        int[] pixelsSize = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int rows = pixelsSize[0];
        int cols = pixelsSize[1];

        long[][] matrix = new long[rows][cols];
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToLong(Long::parseLong).toArray();
        }

        int[] initialCoordinates = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        doWhatYouHaveToDo(matrix, blur, initialCoordinates);

        printMatrix(matrix);
    }

    private static void printMatrix(long[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void doWhatYouHaveToDo(long[][] matrix, int blur, int[] initialCoordinates) {
        int r = initialCoordinates[0];
        int c = initialCoordinates[1];

        for (int row = r - 1; row <= r + 1; row++) {
            for (int col = c - 1; col <= c + 1; col++) {
                try {
                    matrix[row][col] += blur;
                } catch (IndexOutOfBoundsException e) {
                }
            }
        }
    }
}
