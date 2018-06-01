import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AddVAT {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Double> input = Arrays.stream(reader.readLine().split(", "))
                .map(Double::parseDouble).collect(Collectors.toList());

        Function<List<Double>, List<Double>> addVAT = inputNums -> {
            List<Double> converted = new ArrayList<>();
            for (Double num : inputNums) {
                converted.add(num * 1.2);
            }

            return converted;
        };

        List<Double> withVAT = addVAT.apply(input);

        Consumer<List<Double>> print = nums -> {
            System.out.println("Prices with VAT:");
            nums.forEach(n -> System.out.printf("%.2f%n", n));
        };

        print.accept(withVAT);
    }
}
