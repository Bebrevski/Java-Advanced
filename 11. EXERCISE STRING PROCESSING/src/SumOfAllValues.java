import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SumOfAllValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String keysStr = scanner.nextLine();
        String textStr = scanner.nextLine();

        String keyRegex = "^([A-Za-z_]+)\\d.*(?<=\\d)([A-Za-z_]+)$";
        Pattern keysPattern = Pattern.compile(keyRegex);
        Matcher match = keysPattern.matcher(keysStr);
        if (!match.find()) {
            System.out.println("<p>A key is missing</p>");
            return;
        }

        String startKey = match.group(1);
        String endKey = match.group(2);

        String regex = String.format("%s(\\d*(?:\\.\\d+)?)%s", startKey, endKey);
        Pattern pattern = Pattern.compile(regex);
        Matcher numbers = pattern.matcher(textStr);

        double sum = 0D;
        while (numbers.find()) {
            sum += Double.parseDouble(numbers.group(1));
        }

        if (sum == 0D) {
            System.out.println("<p>The total value is: <em>nothing</em></p>");
        } else {
            if (sum == (int) sum) {
                System.out.printf("<p>The total value is: <em>%d</em></p>", (int) sum);
            } else {
                System.out.printf("<p>The total value is: <em>%.2f</em></p>", sum);
            }
        }
    }
}
