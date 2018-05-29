import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VowelCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern pattern = Pattern.compile("[AEIOUYaeiouy]");
        Matcher matcher = pattern.matcher(scanner.nextLine());

        int count = 0;
        while (matcher.find()) {
            count++;
        }

        System.out.println("Vowels: " + count);
    }
}
