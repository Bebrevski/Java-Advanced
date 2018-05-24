import java.util.*;

public class Voina {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> firstPlayer = new LinkedHashSet<>();
        Set<Integer> secondPlayer = new LinkedHashSet<>();

        fillCards(scanner, firstPlayer, secondPlayer);

        int round = 1;
        while (round != 50) {
            int card1 = firstPlayer.iterator().next();
            firstPlayer.remove(card1);

            int card2 = secondPlayer.iterator().next();
            secondPlayer.remove(card2);

            if (card1 > card2) {
                firstPlayer.add(card1);
                firstPlayer.add(card2);
            } else if (card1 < card2){
                secondPlayer.add(card1);
                secondPlayer.add(card2);
            }

            if (firstPlayer.isEmpty() || secondPlayer.isEmpty()) {
                System.out.println(firstPlayer.isEmpty() ? "Second player win!" : "First player win!");
                return;
            }

            round++;
        }

        System.out.println(firstPlayer.size() > secondPlayer.size() ?
                "First player win!" : firstPlayer.size() < secondPlayer.size() ?
                "Second player win!" : "Draw!");
    }

    private static void fillCards(Scanner scanner, Set<Integer> firstPlayer, Set<Integer> secondPlayer) {
        String[] firstPlayerNumbers = scanner.nextLine().split(" ");
        String[] secondPlayerNumbers = scanner.nextLine().split(" ");

        for (String card : firstPlayerNumbers) {
            firstPlayer.add(Integer.parseInt(card));
        }

        for (String card : secondPlayerNumbers) {
            secondPlayer.add(Integer.parseInt(card));
        }
    }
}
