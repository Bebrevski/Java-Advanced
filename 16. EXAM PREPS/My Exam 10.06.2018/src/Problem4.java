import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Problem4 {

    private static final String END_OF_CONTESTS = "end of contests";
    private static final String END_OF_SUBMISSIONS = "end of submissions";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> courses = new HashMap<>();
        Map<String, Map<String, Integer>> candidates = new TreeMap<>();

        String input = reader.readLine();
        while (!END_OF_CONTESTS.equals(input)) {
            String[] tokens = input.split(":");
            String course = tokens[0];
            String password = tokens[1];

            courses.putIfAbsent(course, password);

            input = reader.readLine();
        }

        input = reader.readLine();
        while (!END_OF_SUBMISSIONS.equals(input)) {
            String[] tokens = input.split("[=>]+");
            String course = tokens[0];
            String pass = tokens[1];
            String name = tokens[2];
            Integer points = Integer.parseInt(tokens[3]);

            if (!(courses.containsKey(course) && courses.get(course).equals(pass))) {
                input = reader.readLine();
                continue;
            }

            candidates.putIfAbsent(name, new LinkedHashMap<>());
            candidates.get(name).putIfAbsent(course, 0);
            candidates.get(name).put(course, Math.max(candidates.get(name).get(course), points));

            input = reader.readLine();
        }

        int maxResult = Integer.MIN_VALUE;
        String name = "";
        for (Map.Entry<String, Map<String, Integer>> student : candidates.entrySet()) {
            int result = 0;
            for (Map.Entry<String, Integer> c : student.getValue().entrySet()) {
                result += c.getValue();
            }

            if (result > maxResult) {
                maxResult = result;
                name = student.getKey();
            }
        }

        StringBuilder sb = new StringBuilder();
        sb
                .append("Best candidate is ")
                .append(name).append(" with total ")
                .append(maxResult).append(" points.")
                .append(System.lineSeparator())
                .append("Ranking:")
                .append(System.lineSeparator());

        candidates.entrySet().stream()
                .forEach(s -> {

                    sb.append(s.getKey()).append(System.lineSeparator());

                    s.getValue().entrySet().stream()
                            .sorted((c1, c2) -> c2.getValue().compareTo(c1.getValue()))
                            .forEach(c -> sb
                                    .append("#  ")
                                    .append(c.getKey())
                                    .append(" -> ")
                                    .append(c.getValue())
                                    .append(System.lineSeparator())
                            );
                });

        System.out.println(sb);
    }
}
