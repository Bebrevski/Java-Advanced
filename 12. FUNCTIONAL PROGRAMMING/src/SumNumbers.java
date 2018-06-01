import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class SumNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();

        Function<int[], Integer> getCount = arr -> arr.length;

        int count = getCount.apply(numbers);

        Function<int[], Integer> getSum = arr -> Arrays.stream(arr).reduce(0, (a, b) -> a + b);

        int sum = getSum.apply(numbers);

        System.out.println("Count = " + count);
        System.out.println("Sum = " + sum);
    }
}
