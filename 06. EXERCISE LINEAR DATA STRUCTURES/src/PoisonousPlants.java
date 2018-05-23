import java.util.*;

public class PoisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] plants = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> indexes = new ArrayDeque<>();
        indexes.push(0);

        int[] days = new int[n];

        for (int i = 1 ; i < n; i++)
        {
            int maxDays = 0;
            while (indexes.size() > 0 && plants[indexes.peek()] >= plants[i])
            {
                maxDays = Math.max(maxDays, days[indexes.pop()]);
            }

            if (indexes.size() > 0)
            {
                days[i] = maxDays + 1;
            }

            indexes.push(i);
        }

        System.out.println(Arrays.stream(days).max().getAsInt());
    }
}
