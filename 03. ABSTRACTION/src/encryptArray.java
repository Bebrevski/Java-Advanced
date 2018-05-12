import java.lang.reflect.Array;
import java.util.*;

public class encryptArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countNames = Integer.parseInt(scanner.nextLine());
        String[] names = new String[countNames];

        for (int i = 0; i < countNames; i++) {
            names[i] = scanner.nextLine();
        }

        int[] encryptedArray = encryptNames(names);

        printArray(encryptedArray);
    }

    private static void printArray(int[] encryptedArray) {
        for (int i = 0; i < encryptedArray.length; i++) {
            System.out.println(encryptedArray[i]);
        }
    }

    private static int[] encryptNames(String[] names) {
        List<Character> vowels = new ArrayList<>();
        Collections.addAll(vowels, 'a', 'o', 'e', 'i', 'u');

        int[] result = new int[names.length];

        for (int i = 0; i < names.length; i++) {

            int currentResult = 0;

            for (int j = 0; j < names[i].length(); j++) {
                char currentChar = names[i].charAt(j);

                if (vowels.contains(currentChar)) {
                    currentResult += (int) currentChar * names[i].length();
                } else {
                    currentResult += (int) currentChar / names[i].length();
                }
            }

            result[i] = currentResult;
        }

        Arrays.sort(result);

        return result;

    }
}
