import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class LogsAggregator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(reader.readLine());

        Map<String, Integer> userDuration = new TreeMap<>();
        Map<String, Set<String>> userIPs = new TreeMap<>();

        for (int i = 0; i < count; i++) {
            String[] tokens = reader.readLine().split(" ");
            String username = tokens[1];
            String IP = tokens[0];
            Integer duration = Integer.parseInt(tokens[2]);

            if (!userDuration.containsKey(username)) {
                userDuration.put(username, 0);
                userIPs.put(username, new TreeSet<>());
            }

            userDuration.put(username, userDuration.get(username) + duration);
            userIPs.get(username).add(IP);
        }

        for (Map.Entry<String, Integer> userDur : userDuration.entrySet()) {
            System.out.printf("%s: %d [%s]%n"
                    , userDur.getKey()
                    , userDur.getValue()
                    , String.join(", ", userIPs.get(userDur.getKey())));
        }
    }
}
