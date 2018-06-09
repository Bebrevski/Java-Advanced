import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TheSwanStation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> theNumbers = Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String[] line = reader.readLine().split(" ");
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (String s : line) {
            queue.offer(Integer.parseInt(s));
        }

        List<Integer> outputNums = new ArrayList<>();
        while (outputNums.size() < 6) {
            int first = queue.poll();
            int second = theNumbers.get(0);

            if (first % second != 0) {
                queue.offer(++first);
                continue;
            }

            outputNums.add(first);
            theNumbers.remove(0);
        }

        System.out.printf("%s", outputNums.toString().replaceAll("[\\[\\]]", ""));
    }
}
