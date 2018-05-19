import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class MaximumElement {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int commands = Integer.parseInt(reader.readLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < commands; i++) {

            String[] input = reader.readLine().split(" ");
            String command = input[0];

            if (command.equals("1")) {
                int numToPush = Integer.parseInt(input[1]);
                stack.push(numToPush);
                if (max <= numToPush) {
                    max = numToPush;
                }
            } else if (command.equals("2")) {
                int poppedItem = stack.pop();
                if (poppedItem == max) {
                    max = Integer.MIN_VALUE;
                }
            } else {
                if (max == Integer.MIN_VALUE){
                    for (Integer num : stack) {
                        if (num > max) {
                            max = num;
                        }
                    }
                }
                sb.append(max).append(System.lineSeparator());
            }
        }
        System.out.println(sb);
    }
}
