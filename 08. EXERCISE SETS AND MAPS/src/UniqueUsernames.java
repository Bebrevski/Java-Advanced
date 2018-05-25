import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        Set<String> record = new LinkedHashSet<>();

        for (int i = 0; i < count; i++) {
            record.add(scanner.nextLine());
        }

        for (String person : record) {
            System.out.println(person);
        }
    }
}
