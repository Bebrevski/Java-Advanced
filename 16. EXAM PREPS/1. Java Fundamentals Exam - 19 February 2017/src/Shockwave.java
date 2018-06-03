import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Shockwave {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] size = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int rows = size[0];
        int cols = size[1];

        int[][] matrix = new int[rows][cols];

        String input = reader.readLine();
        while (!"Here We Go".equals(input)) {
            int[] coordinates = Arrays.stream(input.split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            int startRow = coordinates[0];
            int startCol = coordinates[1];
            int endRow = coordinates[2];
            int endCol = coordinates[3];

            for (int row = startRow; row <= endRow; row++) {
                for (int col = startCol; col <= endCol; col++) {
                    matrix[row][col]++;
                }
            }

            input = reader.readLine();
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
