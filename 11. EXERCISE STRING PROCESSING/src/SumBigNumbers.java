import java.util.Scanner;

public class SumBigNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder number1 = new StringBuilder(scanner.nextLine());
        removeLeadingZeroes(number1);
        StringBuilder number2 = new StringBuilder(scanner.nextLine());
        removeLeadingZeroes(number2);

        int leadZeroes = Math.max(number1.length(), number2.length()) -
                Math.min(number1.length(), number2.length());

        subordinateTheTwoNumbers(number1, number2, leadZeroes);

        StringBuilder result = new StringBuilder();
        int remainder = 0;
        int currentSum;
        for (int i = number1.length() - 1; i >= 0; i--) {
            currentSum = number1.charAt(i) + number2.charAt(i) - '0' + remainder;
            if (currentSum > '9') {
                result.insert(0, (char) (currentSum - '\n'));
                remainder = 1;
            } else {
                result.insert(0, (char) currentSum);
                remainder = 0;
            }

            if (i == 0 && remainder == 1) {
                result.insert(0, remainder);
            }
        }

        System.out.println(result);
    }

    private static void subordinateTheTwoNumbers(StringBuilder number1, StringBuilder number2, int leadZeroes) {
        if (number1.length() > number2.length()) {
            number2.insert(0, addZeroes(leadZeroes));
        } else if (number1.length() < number2.length()) {
            number1.insert(0, addZeroes(leadZeroes));
        }
    }

    private static String addZeroes(int leadZeroes) {
        StringBuilder zeroes = new StringBuilder();
        for (int i = 0; i < leadZeroes; i++) {
            zeroes.append("0");
        }

        return zeroes.toString();
    }

    private static void removeLeadingZeroes(StringBuilder number1) {
        while (number1.charAt(0) == '0') {
            number1.deleteCharAt(0);
        }
    }
}
