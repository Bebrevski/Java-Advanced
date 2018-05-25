import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> record = new HashMap<>();

        String person = scanner.nextLine();

        while (!"search".equals(person)) {
            String[] tokens = person.split("-");

            String name = tokens[0];
            String number = tokens[1];

            if (!record.containsKey(name)) {
                record.put(name, number);
            }

            person = scanner.nextLine();
        }

        person = scanner.nextLine();
        while (!"stop".equals(person)) {
            if (record.containsKey(person)) {
                System.out.printf("%s -> %s%n", person, record.get(person));
            } else {
                System.out.printf("Contact %s does not exist.%n", person);
            }

            person = scanner.nextLine();
        }
    }
}
