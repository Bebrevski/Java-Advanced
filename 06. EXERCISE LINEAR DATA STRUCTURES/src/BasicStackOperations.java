import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int numbersToPush = input[0];
        int numbersToPop = input[1];
        int numberToCheck = input[2];

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        fillStack(stack, numbers, numbersToPush);
        removeFromStack(stack, numbersToPop);

        //find if numberToCheck is present or print the smallest num
        printResult(stack, numbers, numbersToPush, numbersToPop, numberToCheck);
    }

    private static void printResult(ArrayDeque<Integer> stack, int[] numbers, int numbersToPush, int numbersToPop, int numberToCheck) {
        boolean isPresent = numberIsPresent(stack, numberToCheck);
        if (isPresent) {
            System.out.println("true");
            return;
        }

        stack.clear();
        fillStack(stack, numbers, numbersToPush);
        removeFromStack(stack, numbersToPop);
        int smallestNumInStack = getSmallestNum(stack);
        System.out.println(smallestNumInStack);
    }


    private static void removeFromStack(ArrayDeque<Integer> stack, int numbersToPop) {
        for (int i = 0; i < numbersToPop; i++) {
            stack.pop();
        }
    }

    private static void fillStack(ArrayDeque<Integer> stack, int[] numbers, int numbersToPush) {
        for (int i = 0; i < numbersToPush; i++) {
            stack.push(numbers[i]);
        }
    }

    private static int getSmallestNum(ArrayDeque<Integer> stack) {
        int smallest = Integer.MAX_VALUE;
        if (stack.isEmpty()) {
            return 0;
        }

        while (!stack.isEmpty()) {
            if (stack.peek() < smallest) {
                smallest = stack.pop();
            } else {
                stack.pop();
            }
        }

        return smallest;
    }

    private static boolean numberIsPresent(ArrayDeque<Integer> stack, int numberToCheck) {
        while (!stack.isEmpty()) {
            if (stack.pop() == numberToCheck) {
                return true;
            }
        }

        return false;
    }
}
