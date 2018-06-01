import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FilterbyAge {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(reader.readLine());

        Map<String, Integer> people = new LinkedHashMap<>();

        for (int i = 0; i < count; i++) {
            String[] input = reader.readLine().split(", ");
            String name = input[0];
            Integer age = Integer.parseInt(input[1]);

            people.putIfAbsent(name, age);
        }

        String condition = reader.readLine();
        Integer ageLimit = Integer.parseInt(reader.readLine());
        String format = reader.readLine();

        Predicate<Integer> filter = buildPredicate(condition, ageLimit);

        for (Map.Entry<String, Integer> person : people.entrySet()) {
            if (filter.test(person.getValue())) {
                print(format).accept(person);
            }
        }
    }

    private static Consumer<Map.Entry<String, Integer>> print(String format) {
        if ("name".equals(format)) {
            return e -> System.out.printf("%s%n", e.getKey());
        } else if ("age".equals(format)) {
            return e -> System.out.printf("%d%n", e.getValue());
        } else {
            return e -> System.out.printf("%s - %d%n", e.getKey(), e.getValue());
        }
    }

    private static Predicate<Integer> buildPredicate(String condition, Integer ageLimit) {
        if ("younger".equals(condition)) {
            return x -> x < ageLimit;
        } else {
            return x -> x >= ageLimit;
        }
    }
}
