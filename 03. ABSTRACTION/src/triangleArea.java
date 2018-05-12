import java.util.Scanner;

public class triangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        double base = Double.parseDouble(input[0]);
        double height = Double.parseDouble(input[1]);

        double area = calculateArea(base, height);

        printArea(area);
    }

    private static void printArea(double area) {
        System.out.printf("Area = %.02f", area);
    }

    private static double calculateArea(double base, double height) {
        return base * height / 2;
    }
}
