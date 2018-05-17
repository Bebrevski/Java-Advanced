import java.util.*;

public class EncryptArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countNames = Integer.parseInt(scanner.nextLine());
        String[] names = new String[countNames];

        getNames(names, scanner);

        int[] encryptedArray = encryptNames(names);

        printArray(encryptedArray);
    }

    private static void getNames(String[] names, Scanner scanner) {
        for (int i = 0; i < names.length; i++) {
            names[i] = scanner.nextLine();
        }
    }

    private static void printArray(int[] encryptedArray) {
        for (int i = 0; i < encryptedArray.length; i++) {
            System.out.println(encryptedArray[i]);
        }
    }

    private static int[] encryptNames(String[] names) {
        List<Character> vowels = new ArrayList<>();
        Collections.addAll(vowels, 'a', 'o', 'e', 'i', 'u', 'A', 'O', 'E', 'I', 'U');

        int[] results = new int[names.length];

        for (int i = 0; i < names.length; i++) {

            int currentResult = 0;

            for (int j = 0; j < names[i].length(); j++) {
                char currentChar = names[i].charAt(j);

                if (vowels.contains(currentChar)) {
                    currentResult += currentChar * names[i].length();
                } else {
                    currentResult += currentChar / names[i].length();
                }
            }

            results[i] = currentResult;
        }

        Arrays.sort(results);

        return results;

    }
}
