import java.util.*;
import java.util.stream.Collectors;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Set<String>> record = new LinkedHashMap<>();

        fillData(scanner, record);

        Map<String, Integer> points = new LinkedHashMap<>();
        for (Map.Entry<String, Set<String>> kvp : record.entrySet()) {
            points.put(kvp.getKey(), eachPlayerPoints(kvp.getValue()));
        }

        print(points);
    }

    private static void print(Map<String, Integer> points) {
        for (Map.Entry<String, Integer> kvp : points.entrySet()) {
            System.out.printf("%s: %d%n", kvp.getKey(), kvp.getValue());
        }
    }

    private static Integer eachPlayerPoints(Set<String> cards) {
        int sum = 0;
        for (String card : cards) {
            char power = card.charAt(0);
            char type = card.charAt(card.length() - 1);

            int p = Character.isDigit(power) ? power - '0' :
                    power == 'J' ? 11 :
                    power == 'Q' ? 12 :
                    power == 'K' ? 13 : 14;

            p = p == 1 ? 10 : p;

            int t = type == 'S' ? 4 :
                    type == 'H' ? 3 :
                    type == 'D' ? 2 : 1;

            sum += p * t;
        }

        return sum;
    }

    private static void fillData(Scanner scanner, Map<String, Set<String>> record) {
        String input = scanner.nextLine();

        while (!"JOKER".equals(input)) {
            String[] tokens = input.split(": ");
            String name = tokens[0];
            Set<String> cards = Arrays.stream(tokens[1].split(", ")).collect(Collectors.toSet());

            if (!record.containsKey(name)) {
                record.put(name, new HashSet<>());
            }

            record.get(name).addAll(cards);

            input = scanner.nextLine();
        }
    }
}
