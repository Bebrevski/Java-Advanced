import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TerroristsWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String regex = "\\|.*?\\|";

        Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String match = matcher.group(0);

            int lastDigit = getLastDigit(match);

            int startIndex = Math.max(0, text.indexOf(match) - lastDigit);
            int stopIndex = Math.min(text.indexOf(match) + match.length() + lastDigit, text.length());

            String toReplace = text.substring(startIndex, stopIndex);

            String dots = addDots(toReplace);
            text = text.replace(toReplace, dots);
        }

        System.out.println(text);
    }

    private static int getLastDigit(String match) {
        int sum = 0;
        for (int i = 1; i < match.length() - 1; i++) {
            sum += match.charAt(i);
        }
        return sum % 10;
    }

    private static String addDots(String toReplace) {
        String dots = "";
        for (int i = 0; i < toReplace.length(); i++) {
            dots += ".";
        }
        return dots;
    }
}
