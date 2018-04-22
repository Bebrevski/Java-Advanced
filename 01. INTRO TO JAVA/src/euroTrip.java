import java.math.BigDecimal;
import java.util.Scanner;

public class euroTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final double pricePerKilo = 1.20d;
        final BigDecimal exchangeRate = new BigDecimal("4210500000000");

        double quantity = scanner.nextDouble();

        BigDecimal priceInLevs = new BigDecimal(pricePerKilo * quantity);
        BigDecimal marks = exchangeRate.multiply(priceInLevs);

        System.out.printf("%.2f marks", marks);
    }
}
