import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExtensions {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();

        String input = reader.readLine();
        while (!"Print".equals(input)) {

            Pattern pattern = Pattern.compile(getRegex(input));
            Matcher match = pattern.matcher(line);

            StringBuffer buffer = new StringBuffer();
            while(match.find()) {
                match.appendReplacement(buffer, Matcher.quoteReplacement(new StringBuilder(match.group()).reverse().toString()));
            }
            match.appendTail(buffer);
            line = buffer.toString();

            input = reader.readLine();
        }

        System.out.println(line);
    }

    private static String getRegex(String input) {
        final String specialSymbolReplacement = "\\S*";
        input = input.replaceAll("%+", "%");

        boolean addToStart = false;
        boolean addToEnd = false;

        if (input.startsWith("%")) {
            input = input.substring(1);
            addToStart = true;
        }

        if (input.endsWith("%")) {
            input = input.substring(0, input.length() - 1);
            addToEnd = true;
        }

        String[] parts = input.split("%");
        StringBuilder sb = new StringBuilder();

        if (addToStart) {
            sb.append(specialSymbolReplacement);
        }

        for (int i = 0; i < parts.length - 1; i++) {
            sb.append(Pattern.quote(parts[i]));
            sb.append(specialSymbolReplacement);
        }
        sb.append(Pattern.quote(parts[parts.length - 1]));

        if (addToEnd) {
            sb.append(specialSymbolReplacement);
        }

        return sb.toString();
    }
}
