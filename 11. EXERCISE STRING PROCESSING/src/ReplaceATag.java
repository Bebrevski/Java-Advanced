import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceATag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();

        String line = scanner.nextLine();

        while (!"END".equals(line)) {
            sb.append(line).append(System.lineSeparator());

            line = scanner.nextLine();
        }

        String regex = "(<a)(\\s*[^>]*\\s*)(>)(\\s*.*)(</a>)";
        Pattern pattern = Pattern.compile(regex, Pattern.DOTALL); //multiple lines match

        String input = sb.toString();
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String replacement = matcher.group(0)
                    .replace("<a", "[URL")
                    .replace("</a>", "[/URL]")
                    .replace(">", "]");
            input = input.replace(matcher.group(0), replacement);
        }

        System.out.println(input);
    }
}
