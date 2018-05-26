import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class PopulationCounter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Map<String, Long>> record = new LinkedHashMap<>();

        String input = reader.readLine();

        while (!"report".equals(input)) {
            String[] inputs = input.split("\\|");
            String city = inputs[0];
            String country = inputs[1];
            long population = Long.parseLong(inputs[2]);

            record.putIfAbsent(country, new LinkedHashMap<>());
            record.get(country).put(city, population);

            input = reader.readLine();
        }
        Map<String, Long> totalPopulations = new HashMap<>();
        for (String country : record.keySet()) {
            totalPopulations.put(country, record.get(country).values().stream().mapToLong(Long::valueOf).sum());
        }
        record.entrySet()
                .stream()
                .sorted((c1, c2) -> {
                    Long population1 = totalPopulations.get(c1.getKey());
                    Long population2 = totalPopulations.get(c2.getKey());

                    //return  population2.compareTo(population1);
                    return Long.compare(population2, population1);
                })
                .forEach(country -> {
                    System.out.printf("%s (total population: %d)%n", country.getKey(), totalPopulations.get(country.getKey()));
                    country.getValue().entrySet()
                            .stream()
                            .sorted((first, second) -> Long.compare(second.getValue(), first.getValue()))
                            .forEach(city -> System.out.printf("=>%s: %d%n", city.getKey(), city.getValue()));
                });
    }
}
