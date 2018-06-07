import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Highscore {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Long> playerAndResult = new HashMap<>();
        Map<String, List<String>> playerAgainstAndDiff = new HashMap<>();

        String input = reader.readLine();
        while (!"osu!".equals(input)) {
            String[] tokens = input.split("\\s+|<->");
            Long firstScore = Long.parseLong(tokens[0]);
            String firstName = tokens[1];
            String secondName = tokens[2];
            Long secondScore = Long.parseLong(tokens[3]);


            fillData(playerAndResult, playerAgainstAndDiff, firstScore, firstName, secondName, secondScore);
            fillData(playerAndResult, playerAgainstAndDiff, secondScore, secondName, firstName, firstScore);

            input = reader.readLine();
        }

        playerAndResult.entrySet().stream()
                .sorted((p1, p2) -> p2.getValue().compareTo(p1.getValue()))
                .forEach(p -> {
                    System.out.printf("%s - (%d)%n", p.getKey(), p.getValue());

                    List<String> against = playerAgainstAndDiff.get(p.getKey());
                    if (against != null) {
                        against.forEach(e -> System.out.printf("*   %s%n", e));
                    }
                });
    }

    private static void fillData(Map<String, Long> playerAndResult, Map<String, List<String>> playerAgainstAndDiff,
                                 Long firstScore, String firstName, String secondName, Long secondScore) {

        playerAndResult.putIfAbsent(firstName, 0L);
        playerAndResult.put(firstName, playerAndResult.get(firstName) + (firstScore - secondScore));

        playerAgainstAndDiff.putIfAbsent(firstName, new ArrayList<>());
        playerAgainstAndDiff.get(firstName).add(secondName + " <-> " + (firstScore - secondScore));
    }
}


//Not my solution. With class !!!

//        import java.io.BufferedReader;
//        import java.io.IOException;
//        import java.io.InputStreamReader;
//        import java.util.*;
//
//public class Pr04Highscore {
//
//    public static void main(String[] args) throws IOException {
//        Map<String, Player> players = new LinkedHashMap<>();
//
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        String input = reader.readLine();
//
//        while (!"osu!".equals(input.toLowerCase())) {
//            String[] tokens = input.split("\\s+");
//            Integer playerOneScore = Integer.valueOf(tokens[0]);
//            Integer playerTwoScore = Integer.valueOf(tokens[2]);
//            tokens = tokens[1].split("<->");
//            String playerOne = tokens[0];
//            String playerTwo = tokens[1];
//
//            if (playerOneScore > playerTwoScore) {
//                playerOneScore -= playerTwoScore;
//                playerTwoScore = -playerOneScore;
//            } else if (playerTwoScore > playerOneScore) {
//                playerTwoScore -= playerOneScore;
//                playerOneScore = -playerTwoScore;
//            } else {
//                playerOneScore = 0;
//                playerTwoScore = 0;
//            }
//
//            if (!players.containsKey(playerOne)) {
//                players.put(playerOne, new Player(playerOne));
//            }
//
//            if (!players.containsKey(playerTwo)) {
//                players.put(playerTwo, new Player(playerTwo));
//            }
//
//            players.get(playerOne).addGame(playerOneScore, playerTwo);
//            players.get(playerTwo).addGame(playerTwoScore, playerOne);
//
//            input = reader.readLine();
//        }
//
//
//        Object[] sorted = players.values().toArray();
//        Arrays.sort(sorted, Collections.reverseOrder());
//
//        for (Object o : sorted) {
//            System.out.print(o.toString());
//        }
//    }
//
//    private static class Player implements Comparable<Player> {
//        private String name;
//        private Long score;
//        private List<String> games;
//
//        Player(String name) {
//            this.name = name;
//            score = 0L;
//            games = new LinkedList<>();
//        }
//
//        void addGame(Integer score, String opponent) {
//            this.score += score;
//            games.add(String.format("*   %s <-> %d", opponent, score));
//        }
//
//        @Override
//        public String toString() {
//            StringBuilder sb = new StringBuilder();
//            sb.append(name).append(" - (").append(score).append(")").append(System.lineSeparator());
//            for (String game : games) {
//                sb.append(game).append(System.lineSeparator());
//            }
//            return sb.toString();
//        }
//
//        @Override
//        public int compareTo(Player other) {
//            return score.compareTo(other.score);
//        }
//    }
//}
