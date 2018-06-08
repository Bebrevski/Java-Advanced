import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class LittleAlchemy {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] stones = reader.readLine().split(" ");

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (String stone : stones) {
            queue.offer(Integer.parseInt(stone));
        }

        String input = reader.readLine();
        Integer storage = 0;
        while (!"Revision".equals(input)) {
            String[] tokens = input.split(" ");
            String command = tokens[0];
            Integer count = Integer.parseInt(tokens[tokens.length - 1]);

            if ("Apply".equals(command)) {

                for (int i = 0; i < count; i++) {
                    if (queue.isEmpty()) break;

                    Integer currentStone = queue.poll() - 1;

                    if (currentStone > 0) {
                        queue.offer(currentStone);
                    } else {
                        storage++;
                    }
                }

            } else if ("Air".equals(command) && storage > 0) {
                storage--;
                queue.addLast(count);
            }

            input = reader.readLine();
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            sb.append(queue.poll()).append(" ");

            if (queue.isEmpty()) {
                sb.append(System.lineSeparator());
            }
        }
        sb.append(storage);
        System.out.println(sb);
    }
}
