import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Problem1 {

    private static final String PATTERN = "^([A-Z][a-z]+ [A-Z][a-z]+)$";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int problemCount = Integer.parseInt(reader.readLine());
        int candidatesCount = Integer.parseInt(reader.readLine());

        ArrayDeque<String> problems = new ArrayDeque<>();
        for (int i = 0; i < problemCount; i++) {
            problems.push(reader.readLine());
        }

        ArrayDeque<String> candidates = new ArrayDeque<>();
        for (int i = 0; i < candidatesCount; i++) {
            String name = reader.readLine();
            if (name.matches(PATTERN)) {
                candidates.offer(name);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (candidates.size() > 1 && problems.size() > 0) {
            String currentProblem = problems.poll();
            String currentCandidate = candidates.poll();

            boolean problemSolved = checkIfProblemIsPassed(currentCandidate, currentProblem);

            if (problemSolved) {
                sb
                        .append(currentCandidate)
                        .append(" solved ")
                        .append(currentProblem)
                        .append(".")
                        .append(System.lineSeparator());

                candidates.offer(currentCandidate);
            } else {
                sb
                        .append(currentCandidate)
                        .append(" failed ")
                        .append(currentProblem)
                        .append(".")
                        .append(System.lineSeparator());

                problems.offer(currentProblem);
            }
        }

        if (candidates.size() == 1) {
            sb.append(candidates.poll()).append(" gets the job!");
            System.out.println(sb);
            return;
        }

        if (problems.isEmpty()) {
            while (!candidates.isEmpty()) {
                sb.append(candidates.poll());

                if (!candidates.isEmpty()) {
                    sb.append(", ");
                }
            }
        }

        System.out.println(sb);
    }

    private static boolean checkIfProblemIsPassed(String currentCandidate, String currentProblem) {
        long problemCharsSum = currentProblem.chars().mapToLong(c -> c).sum();
        long candidateCharsSum = currentCandidate.chars().mapToLong(c -> c).sum();

        if (candidateCharsSum >= problemCharsSum) {
            return true;
        }
        return false;
    }
}
