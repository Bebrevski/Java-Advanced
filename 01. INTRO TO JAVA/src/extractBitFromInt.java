import java.util.Scanner;

public class extractBitFromInt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();
        int index = scanner.nextInt();

        int bit = (number >> index) & 1;
        System.out.println(bit);
    }
}
