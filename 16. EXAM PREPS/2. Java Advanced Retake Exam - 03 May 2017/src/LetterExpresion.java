import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LetterExpresion {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        Pattern pattern = Pattern.compile("(\\D*)?(\\d+)");
        Matcher matches = pattern.matcher(input);

        ArrayDeque<Double> queueNums = new ArrayDeque<>();
        ArrayDeque<String> queueStrings = new ArrayDeque<>();

        while (matches.find()) {
            Double num = Double.parseDouble(matches.group(2));
            String symbols = matches.group(1);

            queueNums.offer(num);
            queueStrings.offer(symbols);
        }

        Double result = 0D;
        while (!queueNums.isEmpty() || !queueStrings.isEmpty()) {
            Double currentNum = queueNums.poll();
            String currentStr = queueStrings.poll();

            if (currentStr.length() % 2 == 0) {
                result += currentNum;
            } else {
                result -= currentNum;
            }
        }

        System.out.printf("%.0f", result);
    }
}
