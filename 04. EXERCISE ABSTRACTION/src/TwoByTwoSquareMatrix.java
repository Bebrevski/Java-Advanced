import java.util.Arrays;
import java.util.Scanner;

public class TwoByTwoSquareMatrix {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int rows = input[0];
        int cols = input[1];

        String[][] matrix = new String[rows][cols];

        initializeMatrix(matrix);

        int count = findTheCountOfTwoByTwoEqualCharacters(matrix);

        System.out.println(count);
    }

    private static int findTheCountOfTwoByTwoEqualCharacters(String[][] matrix) {

        int count = 0;

        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                String firstLetter = matrix[row][col];
                String secondLetter = matrix[row][col + 1];
                String thirdLetter = matrix[row + 1][col];
                String forthLetter = matrix[row + 1][col + 1];

                if (firstLetter.equals(secondLetter) &&
                        secondLetter.equals(thirdLetter) &&
                        thirdLetter.equals(forthLetter)) {
                    count++;
                }
            }
        }

        return count;
    }

    private static void initializeMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {

            String[] inputLine = scanner.nextLine().split("\\s+");

            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = inputLine[col];
            }
        }
    }
}
