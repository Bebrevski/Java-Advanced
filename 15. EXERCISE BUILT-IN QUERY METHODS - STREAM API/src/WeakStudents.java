import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WeakStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> record = new ArrayList<>();

        String input = reader.readLine();
        while (!input.equals("END")) {
            record.add(input);
            input = reader.readLine();
        }

        record.stream()
                .map(s -> s.split("\\s+"))
                .filter(p -> Arrays.stream(p)
                        .skip(2)
                        .map(Integer::parseInt)
                        .filter(sc -> sc <= 3)
                        .count() >= 2)
                .map(p -> p[0] + " " + p[1])
                .forEach(System.out::println);
    }
}
