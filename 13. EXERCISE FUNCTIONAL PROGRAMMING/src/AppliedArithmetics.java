import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;

public class AppliedArithmetics {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        String command = reader.readLine();
        while (!"end".equals(command)) {
            doAction(numbers, command);

            command = reader.readLine();
        }
    }

    private static void doAction(int[] numbers, String command) {
        if ("print".equals(command)) {
            System.out.println(Arrays.toString(numbers).replaceAll("[,\\[\\]]", ""));
            return;
        }

        Function<Integer, Integer> action = getAction(command);

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = action.apply(numbers[i]);
        }
    }

    private static Function<Integer, Integer> getAction(String command) {
        if ("add".equals(command)) {
            return x -> x + 1;
        } else if ("multiply".equals(command)) {
            return x -> x * 2;
        } else {
            return x -> x - 1;
        }
    }
}
