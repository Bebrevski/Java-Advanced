import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MapDistricts {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] rec = reader.readLine().split("\\s+");
        Map<String, List<Integer>> record = new HashMap<>();
        for (String t : rec) {
            String[] townArgs = t.split(":");
            String town = townArgs[0];
            int population = Integer.parseInt(townArgs[1]);

            record.putIfAbsent(town, new ArrayList<>());
            record.get(town).add(population);
        }

        int minPopulation = Integer.parseInt(reader.readLine());

        record.entrySet().stream()
                .filter(kvp -> kvp.getValue().stream()
                        .mapToLong(Long::valueOf)
                        .sum() >= minPopulation)
                .sorted((kv1, kv2) -> Integer.compare(
                        kv2.getValue().stream().mapToInt(Integer::valueOf).sum(),
                        kv1.getValue().stream().mapToInt(Integer::valueOf).sum()))
                .forEach(kvp -> {
                    StringBuilder sb = new StringBuilder();
                    sb.append(kvp.getKey()).append(": ");
                    kvp.getValue().stream()
                            .sorted(Comparator.reverseOrder())
                            .limit(5)
                            .forEach(dp -> sb.append(dp).append(" "));
                    System.out.println(sb);
                });
    }
}
