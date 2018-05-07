import java.util.Scanner;

public class rectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Double sideA = scanner.nextDouble();
        Double sideB = scanner.nextDouble();
        scanner.nextLine();

        Double area = sideA * sideB;

        System.out.printf("%.2f", area);
    }
}
