import java.util.Scanner;

public class characterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstStr = scanner.next();
        String secondStr = scanner.next();
        scanner.nextLine();

        int index = 0;
        long result = 0L;

        while (true) {
            Integer firstStrChar = null;
            Integer secondStrChar = null;

            if (firstStr.length() > index) {
                firstStrChar = (int) firstStr.charAt(index);
            }
            if (secondStr.length() > index) {
                secondStrChar = (int) secondStr.charAt(index);
            }

            if (firstStrChar != null && secondStrChar != null) {
                result += firstStrChar * secondStrChar;
            } else if (firstStrChar != null) {
                result += firstStrChar;
            } else if (secondStrChar != null) {
                result += secondStrChar;
            } else {
                break;
            }

            index++;
        }

        System.out.println(result);
    }
}
