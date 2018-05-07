import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class oddAndEvenPairs {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] nums = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        if (nums.length % 2 != 0) {
            System.out.println("invalid length");
            return;
        }

        for (int i = 0; i < nums.length; i += 2) {
            boolean first = nums[i] % 2 == 0;
            boolean second = nums[i + 1] % 2 == 0;

            if (first && second) {
                System.out.printf("%d, %d -> both are even%n", nums[i], nums[i + 1]);
            } else if (!first && !second) {
                System.out.printf("%d, %d -> both are odd%n", nums[i], nums[i + 1]);
            } else {
                System.out.printf("%d, %d -> different%n", nums[i], nums[i + 1]);
            }
        }
    }
}
