import java.util.Scanner;

public class modifyABit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();
        int index = scanner.nextInt();
        int value = scanner.nextInt();
        scanner.nextLine();

        int mask = (1 << index);

        if (value == 0) {
            number &= ~mask;
        } else {
            number |= mask;
        }

        System.out.println(number);
    }
}
