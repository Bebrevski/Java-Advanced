import java.util.Scanner;

public class CountSubstringOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().toLowerCase();
        String sequenceToSearch = scanner.nextLine().toLowerCase();

        int count = 0;
        int index = input.indexOf(sequenceToSearch);

        while (index != -1)
        {
            count++;

            index = input.indexOf(sequenceToSearch, index + 1);
        }

        System.out.println(count);
    }
}
