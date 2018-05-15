import java.util.Scanner;

public class hitTheTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer number = scanner.nextInt();

        for (int i = 1; i <= 20; i++) {
            for (int j = 1; j <= 20; j++) {
                if (i + j == number) {
                    System.out.printf("%d + %d = %d%n", i, j, i + j);
                }
            }
        }

        for (int i = 1; i <= 20; i++) {
            for (int j = 1; j <= 20; j++) {
                if (i - j == number) {
                    System.out.printf("%d - %d = %d%n", i, j, i - j);
                }
            }
        }
    }
}
