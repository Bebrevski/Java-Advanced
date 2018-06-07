import java.util.*;
import java.util.stream.Collectors;

public class FootballStats {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Game>> record = new HashMap<>();

        String input = scanner.nextLine();
        while (!"Season End".equals(input)) {
            String[] tokens = input.split(" - | result |:");
            String firstTeam = tokens[0];
            String secondTeam = tokens[1];
            Integer firstTeamScore = Integer.parseInt(tokens[2]);
            Integer secondTeamScore = Integer.parseInt(tokens[3]);

            fillData(record, firstTeam, secondTeam, firstTeamScore, secondTeamScore);
            fillData(record, secondTeam, firstTeam, secondTeamScore, firstTeamScore);

            input = scanner.nextLine();
        }

        List<String> teamsToShow = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        for (String team : teamsToShow) {
            record.get(team).stream()
                    .sorted(Game::compareTo)
                    .forEach(e -> System.out.println(e.toString()));
        }
    }

    private static void fillData(Map<String, List<Game>> record, String t1, String t2, Integer t1s, Integer t2s) {
        record.putIfAbsent(t1, new ArrayList<>());
        record.get(t1).add(new Game(t1, t1s, t2, t2s));
    }
}

class Game {
    private String Team1;
    private Integer Team1Score;
    private String Team2;
    private Integer Team2Score;

    Game(String t1, Integer t1s, String t2, Integer t2s) {
        this.Team1 = t1;
        this.Team1Score = t1s;
        this.Team2 = t2;
        this.Team2Score = t2s;
    }

    @Override
    public String toString() {
        String result = String.format("%s - %s -> %d:%d"
                , this.Team1
                , this.Team2
                , this.Team1Score
                , this.Team2Score);

        return result;
    }

    public int compareTo(Game other) {
        return this.Team2.compareTo(other.Team2);
    }
}
