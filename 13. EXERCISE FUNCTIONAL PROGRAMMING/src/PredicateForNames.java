import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.BiPredicate;

public class PredicateForNames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int minLength = Integer.parseInt(reader.readLine());

        String[] names = reader.readLine().split(" ");

        BiPredicate<Integer, String> filter = (l, n) -> l >= n.length();

        for (String name : names) {
            if (filter.test(minLength, name)) {
                System.out.println(name);
            }
        }
    }
}
