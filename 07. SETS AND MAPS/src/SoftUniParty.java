import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> guests = new TreeSet<>();
        String input = scanner.nextLine();

        while (!"PARTY".equals(input)) {
            guests.add(input);

            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        while (!"END".equals(input)) {
            guests.remove(input);

            input = scanner.nextLine();
        }

        System.out.println(guests.size());
        for (String person : guests) {
            System.out.println(person);
        }
    }
}
