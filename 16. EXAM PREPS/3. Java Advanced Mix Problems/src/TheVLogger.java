import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TheVLogger {

    private static final String END_COMMAND = "Statistics";
    private static final String JOINED = "joined";
    private static final String FOLLOWED = "followed";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, VLogger> record = new HashMap<>();

        String input = reader.readLine();
        while (!END_COMMAND.equals(input)) {
            String[] tokens = input.split(" ");
            String firstAccount = tokens[0];
            String action = tokens[1];

            if (JOINED.equals(action)) {
                record.putIfAbsent(firstAccount, new VLogger(firstAccount));
            } else if (record.containsKey(firstAccount) && FOLLOWED.equals(action)) {
                String secondAccount = tokens[2];

                if (record.containsKey(secondAccount) && !firstAccount.equals(secondAccount)) {
                    record.get(secondAccount).Followers.add(firstAccount);
                    record.get(firstAccount).Following.add(secondAccount);
                }
            }

            input = reader.readLine();
        }

        System.out.printf("The V-Logger has a total of %d vloggers in its logs.%n"
                , record.size());

        final int[] count = {1};
        record.entrySet().stream()
                .sorted((v1, v2) -> {
                    if (v1.getValue().Followers.size() == v2.getValue().Followers.size()) {
                        return Integer.compare(v1.getValue().Following.size(), v2.getValue().Following.size());
                    }

                    return Integer.compare(v2.getValue().Followers.size(), v1.getValue().Followers.size());
                })
                .forEach(v -> {
                    if (count[0] == 1) {
                        System.out.printf("%d%s"
                                , count[0]
                                , v.getValue().printWithFollowers());
                    } else {
                        System.out.printf("%d%s"
                                , count[0]
                                , v.getValue().printWithoutFollowers());
                    }
                    count[0]++;
                });
    }
}

class VLogger {
    String Name;
    Set<String> Followers;
    Set<String> Following;

    VLogger(String name) {
        this.Name = name;
        Followers = new TreeSet<>();
        Following = new HashSet<>();
    }

    String printWithFollowers() {
        StringBuilder sb = new StringBuilder();

        String line = String.format(". %s : %d followers, %d following%n"
                , this.Name
                , this.Followers.size()
                , this.Following.size());

        sb.append(line);

        for (String follower : Followers) {
            sb.append("*  ").append(follower).append(System.lineSeparator());
        }

        return sb.toString();
    }

    String printWithoutFollowers() {

        return String.format(". %s : %d followers, %d following%n"
                , this.Name
                , this.Followers.size()
                , this.Following.size());
    }
}
