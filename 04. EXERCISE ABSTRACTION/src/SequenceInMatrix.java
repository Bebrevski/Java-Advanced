import sun.invoke.empty.Empty;

import java.util.Arrays;
import java.util.Scanner;

public class SequenceInMatrix {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int[] matrixSize = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int rows = matrixSize[0];
        int cols = matrixSize[1];

        String[][] matrix = new String[rows][cols];

        fillMatrixWithData(matrix);

        String element = "";
        int maxLength = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int currSeqLength = 0;
                String currentElement = matrix[row][col];

                int currRow = row;

                while (currRow < rows && currentElement.equals(matrix[currRow++][col])) {
                    currSeqLength++;
                }

                if (currSeqLength >= maxLength) {
                    maxLength = currSeqLength;
                    element = currentElement;
                }

                currSeqLength = 0;
                currRow = row;
                int currCol = col;

                while (currRow < rows && currCol < cols && currentElement.equals(matrix[currRow++][currCol++])) {
                    currSeqLength++;
                }

                if (currSeqLength > maxLength) {
                    maxLength = currSeqLength;
                    element = currentElement;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int e = 0; e < maxLength; e++) {
            if (e > 0) {
                sb.append(", ");
            }

            sb.append(element);
        }

        System.out.println(sb);
    }

    private static void fillMatrixWithData(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
    }
}
