import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int rotationDegree = getRotationDegree(scanner);

        char[][] data = readData(scanner);

        data = rotate(data, rotationDegree);

        for (char[] row : data) {
            System.out.println(row);
        }
    }

    private static char[][] rotate(char[][] data, int degree) {

        char[][] rotatedData;

        if (degree == 90) {
            rotatedData = new char[data[0].length][data.length];

            for (int row = 0; row < data[0].length; row++) {
                for (int col = 0; col < data.length; col++) {
                    rotatedData[row][col] = data[data.length - 1 - col][row];
                }
            }
        } else if (degree == 180) {
            rotatedData = new char[data.length][data[0].length];

            for (int row = 0; row < data.length; row++) {
                for (int col = 0; col < data[0].length; col++) {
                    rotatedData[row][col] = data[data.length - 1 - row][data[0].length - 1 - col];
                }
            }
        } else if (degree == 270) {
            rotatedData = new char[data[0].length][data.length];

            for (int row = 0; row < data[0].length; row++) {
                for (int col = 0; col < data.length; col++) {
                    rotatedData[row][col] = data[col][data[0].length - 1 - row];
                }
            }
        } else {
            rotatedData = data;
        }

        return rotatedData;
    }

    private static char[][] readData(Scanner scanner) {

        List<String> words = new ArrayList<>();
        int maxLength = 0;
        String line = scanner.nextLine();

        while (!"END".equals(line)) {
            words.add(line);

            maxLength = Math.max(maxLength, line.length());

            line = scanner.nextLine();
        }

        char[][] data = new char[words.size()][maxLength];

        for (int row = 0; row < words.size(); row++) {
            Arrays.fill(data[row], ' ');
            System.arraycopy(words.get(row).toCharArray(), 0, data[row], 0, words.get(row).length());
        }

        return data;
    }

    private static int getRotationDegree(Scanner scanner) {

        return Integer.parseInt(scanner.nextLine().replaceAll("\\D+", "")) % 360;
    }
}
