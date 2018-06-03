import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        int divider = Integer.parseInt(reader.readLine());

        BiPredicate<Integer, Integer> filter = (n, d) -> n % d != 0;

        for (int i = numbers.size() - 1; i >= 0; i--) {
            if (filter.test(numbers.get(i), divider)) {
                System.out.print(numbers.get(i) + " ");
            }
        }
    }
}
