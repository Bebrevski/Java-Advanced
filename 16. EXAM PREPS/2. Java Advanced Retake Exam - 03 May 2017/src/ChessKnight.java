import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ChessKnight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] chessboard = new String[8][8];

        for (int row = 0; row < chessboard.length; row++) {
            chessboard[row] = scanner.nextLine().split("\\|");
        }

        int[] initialPosition = Arrays.stream(scanner.nextLine().split(""))
                .mapToInt(Integer::parseInt).toArray();
        int invalidMoves = 0;
        int boardOutMoves = 0;
        if ((initialPosition[0] < 0 || initialPosition[0] > 7) ||
                (initialPosition[1] < 0 || initialPosition[1] > 7)) {
            System.out.println("Pieces take:");
            System.out.println("Invalid moves: 0");
            System.out.println("Board out moves: 1");
            return;
        }

        List<String> pieces = new ArrayList<>();
        int[] startPosition = initialPosition;
        String input = scanner.nextLine();
        while (!"END".equals(input)) {
            String[] tokens = input.split(" -> ");
            int[] endPosition = Arrays.stream(tokens[1].split("")).mapToInt(Integer::parseInt).toArray();

            boolean legalMove =
(startPosition[0] - 2 == endPosition[0] && (startPosition[1] - 1 == endPosition[1] || startPosition[1] + 1 == endPosition[1])) ||
(startPosition[0] + 2 == endPosition[0] && (startPosition[1] - 1 == endPosition[1] || startPosition[1] + 1 == endPosition[1])) ||
(startPosition[1] + 2 == endPosition[1] && (startPosition[0] - 1 == endPosition[0] || startPosition[0] + 1 == endPosition[0])) ||
(startPosition[1] - 2 == endPosition[1] && (startPosition[0] - 1 == endPosition[0] || startPosition[0] + 1 == endPosition[0]));

            if (!legalMove) {
                invalidMoves++;
                input = scanner.nextLine();
                continue;
            }

            if ((endPosition[0] < 0 || endPosition[0] > 7) ||
                    (endPosition[1] < 0 || endPosition[1] > 7)) {
                boardOutMoves++;
                input = scanner.nextLine();
                continue;
            }

            startPosition[0] = endPosition[0];
            startPosition[1] = endPosition[1];

            String found = chessboard[startPosition[0]][startPosition[1]];
            if (!found.equals(" ")) {
                pieces.add(found);
            }

            input = scanner.nextLine();
        }

        System.out.printf("Pieces take: %s%n", pieces.size() == 0 ? "" : String.join(", ", pieces));
        System.out.printf("Invalid moves: %d%n", invalidMoves);
        System.out.printf("Board out moves: %d%n", boardOutMoves);
    }
}
