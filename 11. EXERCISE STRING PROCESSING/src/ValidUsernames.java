import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String regex = "(?<=^|[\\\\ /()])([A-Za-z]\\w{2,24})(?=$|[\\\\ /()])";

        Matcher matcher = Pattern.compile(regex).matcher(input);

        List<String> userNames = new ArrayList<>();
        while (matcher.find()) {
            userNames.add(matcher.group());
        }

        int prevNameLength = userNames.get(0).length();
        int bestLength = 0;
        int bestIndex = 0;
        for (int i = 1; i < userNames.size(); i++) {
            int currentLength = userNames.get(i).length();

            if (prevNameLength + currentLength > bestLength) {
                bestLength = prevNameLength + currentLength;
                bestIndex = i - 1;
            }

            prevNameLength = currentLength;
        }

        System.out.println(userNames.get(bestIndex));
        System.out.println(userNames.get(bestIndex + 1));
    }
}
