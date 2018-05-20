import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class SimpleTextEditor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        StringBuilder str = new StringBuilder();
        StringBuilder output = new StringBuilder();

        ArrayDeque<String> stack = new ArrayDeque<>();
        stack.push("");

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");
            String command = input[0];

            if (command.equals("1")) {
                String text = input[1];
                str.append(text);
                stack.push(str.toString());
            } else if (command.equals("2")) {
                int removeCount = Integer.parseInt(input[1]);
                str.delete(str.length() - removeCount, str.length());
                stack.push(str.toString());
            } else if (command.equals("3")) {
                int index = Integer.parseInt(input[1]);
                output.append(str.charAt(index - 1)).append(System.lineSeparator());
            } else {
                stack.pop();
                str = new StringBuilder(stack.peek());
            }
        }

        System.out.println(output);
    }
}
