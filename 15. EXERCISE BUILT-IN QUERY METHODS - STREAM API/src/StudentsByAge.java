import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StudentsByAge {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Person> record = new ArrayList<>();

        String input = reader.readLine();
        fillData(reader, record, input);

        record.stream()
                .filter(p -> p.getGroup() >= 18 && p.getGroup() <= 24)
                .map(p -> p.getFirstName() + " " + p.getLastName() + " " + p.getGroup())
                .forEach(System.out::println);
    }

    static void fillData(BufferedReader reader, List<Person> record, String input) throws IOException {
        while (!"END".equals(input)) {
            String[] tokens = input.split("\\s+");
            String firstName = tokens[0];
            String lastName = tokens[1];
            Integer age = Integer.parseInt(tokens[2]);

            Person current = new Person();
            current.setFirstName(firstName);
            current.setLastName(lastName);
            current.setGroup(age);

            record.add(current);

            input = reader.readLine();
        }
    }
}
