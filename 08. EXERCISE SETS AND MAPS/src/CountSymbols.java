import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<Character, Integer> record = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (!record.containsKey(currentChar)) {
                record.put(currentChar, 0);
            }

            record.put(currentChar, record.get(currentChar) + 1);
        }

        for (Map.Entry<Character, Integer> kvp : record.entrySet()) {
            System.out.printf("%s: %d time/s%n", kvp.getKey(), kvp.getValue());
        }
    }
}
