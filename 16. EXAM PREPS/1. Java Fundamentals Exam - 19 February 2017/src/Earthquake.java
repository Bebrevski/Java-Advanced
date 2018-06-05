import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Earthquake {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(reader.readLine());

        ArrayDeque<List<Integer>> queue = new ArrayDeque<>();

        for (int i = 0; i < count; i++) {
            queue.offer(Arrays.stream(reader.readLine().split("\\s+"))
                    .map(Integer::parseInt).collect(Collectors.toList()));
        }

        ArrayDeque<Integer> outputQueue = new ArrayDeque<>();

        while (!queue.isEmpty()) {
            List<Integer> activity = queue.poll();

            int seismicity = activity.get(0);

            for (int i = 1; i < activity.size(); i++) {
                int wave = activity.get(i);

                if (seismicity < wave) {
                  queue.offer(activity.subList(i, activity.size()));
                  break;
                }
            }

            outputQueue.offer(seismicity);
        }

        System.out.println(outputQueue.size());
        StringBuilder sb = new StringBuilder();
        for (Integer num : outputQueue) {
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }
}


