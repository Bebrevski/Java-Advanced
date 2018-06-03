import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CustomComparator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = Arrays.stream(reader.readLine().trim().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        Comparator<Integer> evenBeforeOdd = (n1, n2) -> {
            if ((n1 % 2 == 0) == (n2 % 2 == 0)) {
                return n1.compareTo(n2);
            } else if (n1 % 2 == 0) {
                return -1;
            } else {
                return 1;
            }
        };

        numbers.sort(evenBeforeOdd);

        System.out.println(numbers.toString().replaceAll("[,\\]\\[]", ""));
    }
}
