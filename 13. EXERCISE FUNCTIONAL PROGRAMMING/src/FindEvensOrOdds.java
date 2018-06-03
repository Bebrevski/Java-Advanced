import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Predicate;

public class FindEvensOrOdds {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] boundaries = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int start = boundaries[0];
        int end = boundaries[1];

        String requirement = reader.readLine();

        print(start, end, getPredicate(requirement));
    }

    private static void print(int start, int end, Predicate<Integer> predicate) {
        for (int i = start; i <= end; i++) {
            if(predicate.test(i)) {
                System.out.print(i + " ");
            }
        }
    }

    public static Predicate<Integer> getPredicate(String req) {
        if ("even".equals(req)) {
            return x -> x % 2 == 0;
        } else {
            return x -> x % 2 != 0;
        }
    }
}
