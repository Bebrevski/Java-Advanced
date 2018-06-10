import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(reader.readLine());
        String[][] matrix = new String[size][size];

        String[] directions = reader.readLine().split(", ");

        Integer startRow = null;
        Integer startCol = null;
        Integer food = 0;
        for (int rows = 0; rows < matrix.length; rows++) {
            matrix[rows] = reader.readLine().split(" ");

            for (int cols = 0; cols < matrix[rows].length; cols++) {
                if (matrix[rows][cols].equals("s")) {
                    startRow = rows;
                    startCol = cols;
                } else if (matrix[rows][cols].equals("f")) {
                    food++;
                }
            }
        }

        matrix[startRow][startCol] = "*";

        int snakeLenght = 1;
        for (int command = 0; command < directions.length; command++) {
            String currentDirection = directions[command];

            if (currentDirection.equals("right")) {
                if (startCol + 1 > size - 1) {
                    startCol = 0;
                } else {
                    startCol++;
                }
            }

            if (currentDirection.equals("left")) {
                if (startCol - 1 < 0) {
                    startCol = size - 1;
                } else {
                    startCol--;
                }
            }

            if (currentDirection.equals("down")) {
                if (startRow + 1 > size - 1) {
                    startRow = 0;
                } else {
                    startRow++;
                }
            }

            if (currentDirection.equals("up")) {
                if (startRow - 1 < 0) {
                    startRow = size - 1;
                } else {
                    startRow--;
                }
            }

            String symbolAtPosition = matrix[startRow][startCol];

            if (symbolAtPosition.equals("e")) {
                System.out.println("You lose! Killed by an enemy!");
                return;
            } else if (symbolAtPosition.equals("f")) {
                snakeLenght++;
                matrix[startRow][startCol] = "*";
                if(food == snakeLenght - 1) {
                    System.out.printf("You win! Final snake length is %d", snakeLenght);
                    return;
                }
            }
        }

        int countLeftFood = 0;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (matrix[row][col].equals("f")) {
                    countLeftFood++;
                }
            }
        }
        if (countLeftFood > 0) {
            System.out.printf("You lose! There is still %d food to be eaten.", countLeftFood);
            return;
        }

        System.out.printf("You win! Final snake length is %d", snakeLenght);
    }
}
