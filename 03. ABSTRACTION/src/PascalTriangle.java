import java.math.BigInteger;
import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        BigInteger[][] triangle = new BigInteger[rows][];

        for (int row = 0; row < rows; row++) {
            int cols = row + 1;

            triangle[row] = new BigInteger[cols];
            triangle[row][0] = BigInteger.ONE;
            triangle[row][cols - 1] = BigInteger.ONE;

            if (row > 1) {
                for (int col = 1; col < cols - 1; col++) {
                    triangle[row][col] = triangle[row - 1][col - 1].add(triangle[row - 1][col]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int row = 0; row < triangle.length; row++) {
            for (int col = 0; col < triangle[row].length; col++) {
                if (col > 0) {
                    sb.append(" ");
                }

                sb.append(triangle[row][col]);
            }

            sb.append(System.lineSeparator());
        }

        System.out.println(sb.toString());
    }
}
