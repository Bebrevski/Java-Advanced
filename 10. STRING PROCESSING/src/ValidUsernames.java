import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String pattern = "^[\\w-]{3,16}$";
        List<String> output = new ArrayList<>();

        while (!"END".equals(input)) {
            output.add(input.matches(pattern) ? "valid" : "invalid");
            input = scanner.nextLine();
        }

        if (output.contains("valid")) {
            System.out.println(String.join("\n", output));
        }
    }
}
