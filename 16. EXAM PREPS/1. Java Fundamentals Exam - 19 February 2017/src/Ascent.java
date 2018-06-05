import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ascent {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        Map<String, String> memorized = new LinkedHashMap<>();

        String regex = "[,_][a-zA-Z]+[0-9]";
        Pattern pattern = Pattern.compile(regex);

        String input = reader.readLine();
        while (!"ascend".equals(input.toLowerCase())) {
            for (String memory : memorized.keySet()) {
                input = input.replaceAll(memory, memorized.get(memory));
            }

            StringBuffer buffer = new StringBuffer();
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                String match = matcher.group();
                String replacement = getReplacement(match);
                memorized.put(match, replacement);

                matcher.appendReplacement(buffer, replacement);
            }
            matcher.appendTail(buffer);

            result.append(buffer.toString()).append(System.lineSeparator());

            input = reader.readLine();
        }

        System.out.print(result);
    }

    private static String getReplacement(String match) {
        char[] message = match.toCharArray();
        int change = message[message.length - 1] - '0';

        if (message[0] == '_') {
            change = -change;
        }

        for (int i = 1; i < message.length - 1; i++) {
            message[i] += change;
        }

        return new String(message, 1, message.length - 2);
    }
}