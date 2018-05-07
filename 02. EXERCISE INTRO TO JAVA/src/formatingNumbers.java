import java.util.Scanner;

public class formatingNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        scanner.nextLine();

        String part1 = String.format("%-10X", a);
        String part2 = String.format("%10s", Integer.toBinaryString(a)).replace(' ', '0');
        String part3 = String.format("%10.2f", b);
        String part4 = String.format("%-10.3f", c);

        System.out.printf("|%s|%s|%s|%s|%n", part1, part2, part3, part4);
    }
}
