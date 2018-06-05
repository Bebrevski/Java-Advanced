import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class FilterStudentsByPhone {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> record = new ArrayList<>();

        String input = reader.readLine();
        while (!input.equals("END")) {
            record.add(input);
            input = reader.readLine();
        }

        record.stream()
                .map(s -> s.split(" "))
                .filter(p -> p[2].startsWith("02") || p[2].startsWith("+3592"))
                .map(p -> p[0] + " " + p[1])
                .forEachOrdered(System.out::println);
    }
}
