import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StudentsByFirstAndLastName {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        List<Person> record = new ArrayList<>();

        String input = reader.readLine();
        while (!"END".equals(input)) {
            String[] tokens = input.split("\\s+");
            String firstName = tokens[0];
            String lastName = tokens[1];

            Person current = new Person();
            current.setFirstName(firstName);
            current.setLastName(lastName);

            record.add(current);

            input = reader.readLine();
        }

        record.stream()
                .filter(p -> p.getFirstName().compareTo(p.getLastName()) < 0)
                .map(p -> p.getFirstName() + " " + p.getLastName())
                .forEachOrdered(System.out::println);
    }
}
