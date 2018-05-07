import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class getFirstOddOrEvenElements {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        String[] command = reader.readLine().split("\\s+");
        int count = Integer.parseInt(command[1]);
        String type = command[2];


        if (type.equals("even")) {
            numbers = Arrays.stream(numbers).filter(n -> n % 2 == 0).toArray();
        } else if (type.equals("odd")) {
            numbers = Arrays.stream(numbers).filter(n -> n % 2 != 0).toArray();
        }

        for (int i = 0; i < count; i++) {
            if (i >= numbers.length) {
                break;
            }

            System.out.print("" + numbers[i] + " ");
        }
    }
}
