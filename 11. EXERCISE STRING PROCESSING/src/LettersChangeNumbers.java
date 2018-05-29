import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        List<Double> record = new ArrayList<>();

        for (String seq : input) {
            char firstLetter = seq.charAt(0);
            char secondLetter = seq.charAt(seq.length() - 1);
            double number = Double.parseDouble(seq.substring(1, seq.length() - 1));

            if (Character.isUpperCase(firstLetter)) {
                number /= firstLetter - '@';
            } else {
                number *= firstLetter - '`';
            }

            if (Character.isUpperCase(secondLetter)) {
                number -= secondLetter - '@';
            } else {
                number += secondLetter - '`';
            }

            record.add(number);
        }

        Double sum = record.stream().mapToDouble(Double::doubleValue).sum();

        System.out.printf("%.2f", sum);
    }
}
