import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Optional;

public class MinEvenNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Optional<Double> num = Arrays.stream(reader.readLine().split("\\s+"))
                .filter(x -> !x.isEmpty())
                .map(Double::parseDouble)
                .filter(x -> x % 2 == 0)
                .sorted()
                .findFirst();

        if (num.isPresent()) {
            System.out.printf("%.2f", num.get());
        } else {
            System.out.println("No match");
        }

    }
}
