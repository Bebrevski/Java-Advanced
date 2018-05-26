import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> materials = new HashMap<>();
        materials.put("shards", 0);
        materials.put("fragments", 0);
        materials.put("motes", 0);

        Map<String, Integer> junk = new HashMap<>();

        String input = scanner.nextLine().toLowerCase();

        String legendary = "";

        while (true) {
            String[] tokens = input.split("\\s+");
            boolean found = false;

            for (int i = 0; i < tokens.length; i += 2) {
                Integer quantity = Integer.parseInt(tokens[i]);
                String material = tokens[i + 1];

                if (materials.containsKey(material)) {
                    materials.put(material, materials.get(material) + quantity);
                } else if (!junk.containsKey(material)) {
                    junk.put(material, quantity);
                } else {
                    junk.put(material, junk.get(material) + quantity);
                }

                if (materials.get("shards") >= 250 ||
                        materials.get("fragments") >= 250 ||
                        materials.get("motes") >= 250) {

                    legendary = material.equals("shards") ? "Shadowmourne"
                            : material.equals("fragments") ? "Valanyr"
                            : "Dragonwrath";

                    materials.put(material, materials.get(material) - 250);

                    found = true;

                    break;
                }
            }

            if (found) break;

            input = scanner.nextLine().toLowerCase();
        }

        System.out.printf("%s obtained!%n", legendary);

        materials.entrySet()
                .stream()
                .sorted((m1, m2) -> {
                    if (Integer.compare(m2.getValue(), m1.getValue()) == 0) {
                        return m1.getKey().compareTo(m2.getKey());
                    }
                    return Integer.compare(m2.getValue(), m1.getValue());
                })
                .forEach(e -> System.out.printf("%s: %d%n", e.getKey(), e.getValue()));

        junk.entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(e -> System.out.printf("%s: %d%n", e.getKey(), e.getValue()));
    }
}
