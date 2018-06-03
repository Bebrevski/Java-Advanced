import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        Function<List<Integer>, Integer> func = list -> {
            int minNum = Integer.MAX_VALUE;
            int index = list.get(list.size() - 1);

            for (int i = list.size() - 1; i >= 0; i--) {
                if (list.get(i) < minNum) {
                    minNum = list.get(i);
                    index = i;
                }
            }

            return index;
        };

        System.out.println(func.apply(numbers));
    }
}
