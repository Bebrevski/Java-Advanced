import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NaturesProphet {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] size = reader.readLine().split(" ");
        int rows = Integer.parseInt(size[0]);
        int cols = Integer.parseInt(size[1]);

        int[][] matrix = new int[rows][cols];

        String input = reader.readLine();
        while (!"Bloom Bloom Plow".equals(input)) {
            int[] flowerCoordinates = Arrays.stream(input.split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            int row = flowerCoordinates[0];
            int col = flowerCoordinates[1];

            for (int c = 0; c < cols; c++) {
                matrix[row][c]++;
            }
            for (int r = 0; r < rows; r++) {
                if (r == row) continue;

                matrix[r][col]++;
            }

            input = reader.readLine();
        }

        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                sb.append(matrix[row][col]).append(" ");
            }
            sb.append(System.lineSeparator());
        }

        System.out.println(sb);
    }
}
