import java.util.Scanner;

public class MelrahShake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder text = new StringBuilder(scanner.nextLine());
        StringBuilder pattern = new StringBuilder(scanner.nextLine());

        int firstIndex = text.indexOf(pattern.toString());
        int lastIndex = text.lastIndexOf(pattern.toString());
        while (pattern.length() > 0 && lastIndex > firstIndex) {
            text.delete(firstIndex, firstIndex + pattern.length());
            text.delete(lastIndex - pattern.length(), lastIndex);

            int indexToRemove = pattern.length() / 2;
            pattern.delete(indexToRemove, indexToRemove + 1);

            System.out.println("Shaked it.");

            firstIndex = text.indexOf(pattern.toString());
            lastIndex = text.lastIndexOf(pattern.toString());
        }

        System.out.println("No shake.");
        System.out.println(text);
    }
}
