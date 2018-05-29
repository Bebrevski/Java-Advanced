import java.util.Formatter;
import java.util.Scanner;

public class UnicodeCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Formatter format = new Formatter();
        for (int i = 0; i < input.length(); i++) {
            format.format("\\u%04x", (int)input.charAt(i));
        }

        System.out.println(format);
    }
}
