import java.util.Scanner;

public class collectCoins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] board = new char[4][];

        for (int row = 0; row < 4; row++) {
            board[row] = scanner.nextLine().toCharArray();
        }

        char[] commands = scanner.nextLine().toCharArray();

        int coinsCollected = 0;
        int wallHits = 0;

        int currentRow = 0;
        int currentCol = 0;

        for (char command : commands) {
            switch (command) {
                case '>':
                    if (currentCol < board[currentRow].length - 1) {
                        currentCol++;
                    } else {
                        wallHits++;
                    }
                    break;
                case '<':
                    if (currentCol > 0) {
                        currentCol--;
                    } else {
                        wallHits++;
                    }
                    break;
                case 'V':
                    if (currentRow + 1 < 4 && currentCol < board[currentRow + 1].length) {
                        currentRow++;
                    } else {
                        wallHits++;
                    }
                    break;
                case '^':
                    if (currentRow - 1 >= 0 && currentCol < board[currentRow - 1].length) {
                        currentRow--;
                    } else {
                        wallHits++;
                    }
                    break;
            }

            if (board[currentRow][currentCol] == '$') {
                coinsCollected++;
                board[currentRow][currentCol] = '\0';
            }
        }

        System.out.printf("Coins = %d%n", coinsCollected);
        System.out.printf("Walls = %d%n", wallHits);
    }
}
