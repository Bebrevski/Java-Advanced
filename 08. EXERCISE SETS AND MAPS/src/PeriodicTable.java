import java.util.Collections;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());

        Set<String> record = new TreeSet<>();

        for (int i = 0; i < lines; i++) {
            String[] tokens = scanner.nextLine().split(" ");

           Collections.addAll(record, tokens);
        }

        System.out.println(String.join(" ", record));
    }
}
