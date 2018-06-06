import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StudentsByEnrollmentYear {
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
                .filter(f -> f[0].endsWith("14") || f[0].endsWith("15"))
                .map(p -> {
                    StringBuilder sb = new StringBuilder();

                    sb
                            .append(p[1]).append(" ")
                            .append(p[2]).append(" ")
                            .append(p[3]).append(" ")
                            .append(p[4]).append(" ");
                    return sb.toString();
                })
                .forEach(System.out::println);
    }
}
