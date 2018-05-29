import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractTags {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern pattern = Pattern.compile("<.*?>");
        String input = scanner.nextLine();

        while (!"END".equals(input)) {
            Matcher match = pattern.matcher(input);

            while(match.find()) {
                System.out.println(match.group());
            }

            input = scanner.nextLine();
        }
    }
}
