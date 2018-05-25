import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class AMinerTask {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Long> record = new LinkedHashMap<>();

        String input = reader.readLine();

        while (!"stop".equals(input)) {
            if (!record.containsKey(input)) {
                record.put(input, 0L);
            }

            record.put(input, record.get(input) + Long.parseLong(reader.readLine()));

            input = reader.readLine();
        }

        StringBuilder output = new StringBuilder();
        for (Map.Entry<String, Long> kvp : record.entrySet()) {
            output.append(kvp.getKey() + " -> " + kvp.getValue()).append(System.lineSeparator());
        }

        System.out.println(output);
    }
}
