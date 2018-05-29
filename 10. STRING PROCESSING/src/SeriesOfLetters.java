import java.util.Scanner;

public class SeriesOfLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] input = scanner.nextLine().toCharArray();

        StringBuilder sb = new StringBuilder();

        int state = 0;
        char prev = input[0];

        for (char curr : input) {
            switch (state) {
                case 0:
                    state = 1;
                    break;
                case 1:
                    sb.append(prev);
                    if (curr == prev) {
                        state = 2;
                    }
                    break;
                case 2:
                    if (curr != prev) {
                        state = 1;
                    }
                    break;
            }

            prev = curr;
        }

        if (state == 1) {
            sb.append(prev);
        }

        System.out.println(sb);
    }
}
