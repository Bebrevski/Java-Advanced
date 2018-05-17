import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SplitByWordCasing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String delimiter = "[,\\\\;:\\/.\\[\\]!\\(\\)\"' ]+";
        String[] words = scanner.nextLine().split(delimiter);

        List<String> lowerCaseWords = new ArrayList<>();
        List<String> mixedCaseWords = new ArrayList<>();
        List<String> upperCaseWords = new ArrayList<>();

        distributeWords(words, lowerCaseWords, upperCaseWords, mixedCaseWords);

        printResult(lowerCaseWords, mixedCaseWords, upperCaseWords);
    }

    private static void printResult(List<String> lowerCaseWords, List<String> mixedCaseWords, List<String> upperCaseWords) {
        System.out.print("Lower-case: ");
        printCurrentCollection(lowerCaseWords);

        System.out.print("Mixed-case: ");
        printCurrentCollection(mixedCaseWords);

        System.out.print("Upper-case: ");
        printCurrentCollection(upperCaseWords);
    }

    private static void printCurrentCollection(List<String> collection) {
        for (int i = 0; i < collection.size(); i++) {
            System.out.print(collection.get(i));
            if (i != collection.size() - 1) {
                System.out.print(", ");
                continue;
            }
            System.out.println();
        }
    }

    private static void distributeWords(String[] words, List<String> lowerCaseWords, List<String> upperCaseWords, List<String> mixedCaseWords) {
        for (String word : words) {

            int lowerCount = 0;
            int upperCount = 0;

            for (int i = 0; i < word.length(); i++) {
                if (Character.isLowerCase(word.charAt(i))) {
                    lowerCount++;
                } else if (Character.isUpperCase(word.charAt(i))) {
                    upperCount++;
                }
            }

            if (lowerCount == word.length()) {
                lowerCaseWords.add(word);
            } else if (upperCount == word.length()) {
                upperCaseWords.add(word);
            } else {
                mixedCaseWords.add(word);
            }
        }
    }
}
