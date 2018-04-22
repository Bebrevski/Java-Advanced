import java.util.Scanner;

public class readInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstWord = scanner.next("\\w+");
        String secondwWord = scanner.next("\\w+");

        int firstInt = scanner.nextInt();
        int secondInt = scanner.nextInt();
        int thirdInt = scanner.nextInt();

        scanner.nextLine();
        String thirdWord = scanner.nextLine();

        int sum = firstInt+ secondInt + thirdInt;

        System.out.printf("%s %s %s %d", firstWord, secondwWord, thirdWord, sum);
    }
}
