import java.util.*;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> record = new TreeMap<>();

        String input = scanner.nextLine();

        while (!"end".equals(input)) {

            String[] tokens = input.split(" ");
            String IP = tokens[0].substring(3);
            String username = tokens[2].substring(5);

            if (!record.containsKey(username)) {
                record.put(username, new LinkedHashMap<>());
            }
            if (!record.get(username).containsKey(IP)) {
                record.get(username).put(IP, 0);
            }

            record.get(username).put(IP, record.get(username).get(IP) + 1);

            input = scanner.nextLine();
        }

        for (Map.Entry<String, Map<String, Integer>> usernameAndIP : record.entrySet()) {
            System.out.printf("%s:%n", usernameAndIP.getKey());

            List<String> output = new ArrayList<>();
            for (Map.Entry<String, Integer> IPAndCount : usernameAndIP.getValue().entrySet()) {
                String joined = IPAndCount.getKey() + " => " + IPAndCount.getValue();

                output.add(joined);
            }

            System.out.printf("%s.%n", String.join(", ", output));
        }
    }
}
