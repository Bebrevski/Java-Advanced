import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class BasicQueueOperations {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");
        int numsToAdd = Integer.parseInt(input[0]);
        int numsToRemove = Integer.parseInt(input[1]);
        int numToCheck = Integer.parseInt(input[2]);

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        int[] nums = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        addElements(queue, nums, numsToAdd);

        removeElements(queue, numsToRemove);

        boolean isPresent = checkIfNumIsPresent(queue, numToCheck);

        if (isPresent) {
            System.out.println("true");
            return;
        }

        int minNum = getMinNumberInQueue(queue);
        System.out.println(minNum);
    }

    private static int getMinNumberInQueue(ArrayDeque<Integer> queue) {
        if (queue.isEmpty()) {
            return 0;
        }

        int min = Integer.MAX_VALUE;

        for (Integer num : queue) {
            if (num < min) {
                min = num;
            }
        }

        return min;
    }

    private static boolean checkIfNumIsPresent(ArrayDeque<Integer> queue, int numToCheck) {
        for (Integer num : queue) {
            if (num == numToCheck) {
                return true;
            }
        }

        return false;
    }

    private static void removeElements(ArrayDeque<Integer> queue, int numsToRemove) {
        for (int i = 0; i < numsToRemove; i++) {
            queue.poll();
        }
    }

    private static void addElements(ArrayDeque<Integer> queue, int[] nums, int numsToAdd) {
        for (int i = 0; i < numsToAdd; i++) {
            queue.offer(nums[i]);
        }
    }
}
