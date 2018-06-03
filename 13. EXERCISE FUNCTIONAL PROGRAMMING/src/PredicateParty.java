import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //Commands -> Remove, Double
        //Criteria -> StartsWith, EndsWith, Length

        List<String> names = Arrays.stream(reader.readLine().split(" "))
                .collect(Collectors.toList());

        String input = reader.readLine();

        while (!"Party!".equals(input)) {
            String[] tokens = input.split(" ");
            String command = tokens[0];
            String criteria = tokens[1];
            String argument = tokens[2];

            Predicate<String> filter = getPredicate(criteria, argument);

            if ("Remove".equals(command)) {
                names.removeIf(filter);
            } else if ("Double".equals(command)) {
                for (int i = 0; i < names.size(); i++) {
                    if (filter.test(names.get(i))) {
                        names.add(i, names.get(i));
                        i++;
                    }
                }
            }

            input = reader.readLine();
        }

        if (names.size() > 0) {
            System.out.printf("%s are going to the party!", names.toString().replaceAll("[\\[\\]]", ""));
        } else {
            System.out.println("Nobody is going to the party!");
        }
    }

    private static Predicate<String> getPredicate(String criteria, String argument) {
        switch (criteria) {
            case "StartsWith":
                return name -> name.startsWith(argument);
            case "EndsWith":
                return name -> name.endsWith(argument);
            case "Length":
                return name -> name.length() == Integer.parseInt(argument);
            default:
                return null;
        }
    }
}
