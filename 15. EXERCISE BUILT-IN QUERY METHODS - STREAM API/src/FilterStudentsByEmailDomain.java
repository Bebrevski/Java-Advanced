import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FilterStudentsByEmailDomain {
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
                .filter(p -> p[2].contains("@gmail.com"))
                .map(p -> p[0] + " " + p[1])
                .forEach(System.out::println);
    }
}
