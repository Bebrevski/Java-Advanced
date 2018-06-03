import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> names = Arrays.stream(reader.readLine().split(" "))
                .collect(Collectors.toList());

        boolean[] hidden = new boolean[names.size()];

        String input = reader.readLine();
        while (!"Print".equals(input)) {
            String[] tokens = input.split(";");
            String command = tokens[0];
            String criteria = tokens[1];
            String argument = tokens[2];

            Predicate<String> filter = getPredicate(criteria, argument);

            boolean hide = "Add filter".equals(command);

            for (int i = 0; i < names.size(); i++) {
                if (filter.test(names.get(i))) {
                    hidden[i] = hide;
                }
            }

            input = reader.readLine();
        }

        for (int i = 0; i < names.size(); i++) {
            if (!hidden[i]) {
                System.out.printf("%s ", names.get(i));
            }
        }
    }

    private static Predicate<String> getPredicate(String criteria, String argument) {
        switch (criteria) {
            case "Starts with":
                return name -> name.startsWith(argument);
            case "Ends with":
                return name -> name.endsWith(argument);
            case "Length":
                return name -> name.length() == Integer.parseInt(argument);
            case "Contains":
                return name -> name.contains(argument);
            default:
                return null;
        }
    }
}
