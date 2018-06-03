import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class ListOfPredicates {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int end = Integer.parseInt(reader.readLine());

        Set<Integer> dividers = Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toSet());

        BiPredicate<Set<Integer>, Integer> filter = (set, n) -> {
            for (Integer num : set) {
                if (n % num != 0) {
                    return false;
                }
            }
            return true;
        };

        for (int i = 1; i <= end; i++) {
            if (filter.test(dividers, i)) {
                System.out.print(i + " ");
            }
        }
    }
}
