import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Robotics {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] robots = reader.readLine().split("[-;]+");
        int[] start = Arrays.stream(reader.readLine().split(":"))
                .mapToInt(Integer::parseInt).toArray();
        int timeInSeconds = start[0] * 3600 + start[1] * 60 + start[2];

        String product = reader.readLine();
        while (!product.equals("END")) {

            product = reader.readLine();
        }
    }
}
