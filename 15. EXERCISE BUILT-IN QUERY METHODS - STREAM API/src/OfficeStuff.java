import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class OfficeStuff {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Map<String, Integer>> companiesData = new TreeMap<>();

        int lines = Integer.parseInt(reader.readLine().trim());

        while (lines-- > 0) {
            String[] data = reader.readLine().replaceAll("\\|", "").trim().split(" - ");

            companiesData.putIfAbsent(data[0], new LinkedHashMap<>());
            companiesData.get(data[0]).putIfAbsent(data[2], 0);
            companiesData.get(data[0]).put(data[2], companiesData.get(data[0]).get(data[2]) + Integer.parseInt(data[1]));
        }

        for (Map.Entry mapEntry : companiesData.entrySet()) {
            System.out.printf("%s: %s%n", mapEntry.getKey(),
                    mapEntry.getValue().toString()
                            .replaceAll("[{}]", "")
                            .replaceAll("=", "-"));
        }
    }
}
