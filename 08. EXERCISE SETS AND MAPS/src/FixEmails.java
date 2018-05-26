import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class FixEmails {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> record = new LinkedHashMap<>();

        String input = reader.readLine();

        while (!"stop".equals(input)) {
            if (!record.containsKey(input)) {
                record.put(input, reader.readLine());
            }

            input = reader.readLine();
        }

        StringBuilder output = new StringBuilder();

        for (Map.Entry<String, String> kvp : record.entrySet()) {
            String email = kvp.getValue().toLowerCase();

            boolean forbidden = email.endsWith("us") ||
                                email.endsWith("uk") ||
                                email.endsWith("com");

            if (!forbidden) {
                output.append(kvp.getKey() + " -> " + kvp.getValue()).append(System.lineSeparator());
            }
        }

        System.out.println(output);
    }
}
