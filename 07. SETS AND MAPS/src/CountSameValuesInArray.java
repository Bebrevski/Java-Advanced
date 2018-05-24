import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountSameValuesInArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        Map<String, Integer> record = new HashMap<>();

        for (String num : input) {
            if (!record.containsKey(num)) {
                record.put(num, 0);
            }

            record.put(num, record.get(num) + 1);
        }

        for (Map.Entry<String, Integer> kvp : record.entrySet()) {
            System.out.printf("%s - %d times%n", kvp.getKey(), kvp.getValue());
        }
    }
}
