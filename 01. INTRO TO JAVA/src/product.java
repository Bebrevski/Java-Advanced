import java.math.BigInteger;
import java.util.Scanner;

public class product {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = scanner.nextInt();
        int secondNum = scanner.nextInt();

        BigInteger result = new BigInteger("1");
        for (int i = firstNum; i <= secondNum; i++) {
            result = result.multiply(new BigInteger(Integer.toString(i)));
        }

        System.out.printf("product[%d..%d] = %d", firstNum, secondNum, result);
    }
}
