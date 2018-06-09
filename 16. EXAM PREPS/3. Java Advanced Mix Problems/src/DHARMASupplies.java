import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DHARMASupplies {

    private static final String END_COMMAND = "Collect";
    private static final String NO_SUPPLIES_FOUND = "No supplies found!";
    private static final String NUMBER_OF_SUPPLY_CRATES = "Number of supply crates: %d%n";
    private static final String AMOUNT_OF_FOOD_COLLECTED = "Amount of food collected: %d%n";
    private static final String AMOUNT_OF_DRINKS_COLLECTED = "Amount of drinks collected: %d%n";

    private static final Pattern CRATE_PATTERN = Pattern.compile("\\[.*?]");
    private static final Pattern DRINKS_PATTERN = Pattern.compile("\\[#([a-z]+)([0-9a-zA-Z\\s]+)#\\1]");
    private static final Pattern FOOD_PATTERN = Pattern.compile("\\[#(\\d+)([0-9a-zA-Z\\s]+)#\\1]");

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int cratesCount = 0;
        List<String> lines = new ArrayList<>();

        String input = reader.readLine();

        while (!END_COMMAND.equals(input)) {
            lines.add(input);

            Matcher matchCrate = CRATE_PATTERN.matcher(input);
            while (matchCrate.find()) {
                cratesCount++;
            }

            input = reader.readLine();
        }

        if (cratesCount == 0) {
            System.out.println(NO_SUPPLIES_FOUND);
            return;
        }

        int tagLength = cratesCount / lines.size();

        long foodAmount = 0L;
        long drinkAmount = 0L;
        int validSupply = 0;

        for (String line : lines) {

            Matcher foodMatch = FOOD_PATTERN.matcher(line);
            while (foodMatch.find()) {
                if (foodMatch.group(1).length() == tagLength) {
                    validSupply++;

                    long sum = foodMatch.group(2)
                            .chars()
                            .distinct()
                            .mapToLong(c -> c)
                            .sum();

                    foodAmount += sum * tagLength;
                }
            }

            Matcher drinkMatch = DRINKS_PATTERN.matcher(line);
            while (drinkMatch.find()) {
                if (drinkMatch.group(1).length() == tagLength) {
                    validSupply++;

                    long tagSum = drinkMatch.group(1)
                            .chars()
                            .mapToLong(c -> c)
                            .sum();

                    long sum = drinkMatch.group(2)
                            .chars()
                            .mapToLong(c -> c)
                            .sum();

                    drinkAmount += sum * tagSum;
                }
            }
        }

        if (validSupply > 0) {
            System.out.printf(NUMBER_OF_SUPPLY_CRATES, validSupply);
            System.out.printf(AMOUNT_OF_FOOD_COLLECTED, foodAmount);
            System.out.printf(AMOUNT_OF_DRINKS_COLLECTED, drinkAmount);
        } else {
            System.out.println(NO_SUPPLIES_FOUND);
        }
    }
}
