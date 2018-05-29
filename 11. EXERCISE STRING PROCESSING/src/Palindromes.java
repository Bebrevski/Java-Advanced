import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Palindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        Pattern pattern = Pattern.compile("\\w+");
        Matcher match = pattern.matcher(text);

        Set<String> words = new TreeSet<>();

        while (match.find()) {
            String word = match.group();
            String reversed = reverseWord(word);
            if (word.equals(reversed)) {
                words.add(word);
            }
        }

        System.out.printf("[%s]", String.join(", ", words));
    }

    private static String reverseWord(String word) {
        StringBuilder newWord = new StringBuilder(word.length());
        for (int i = word.length() - 1; i >= 0; i--) {
            newWord.append(word.charAt(i));
        }

        return newWord.toString();
    }
}
