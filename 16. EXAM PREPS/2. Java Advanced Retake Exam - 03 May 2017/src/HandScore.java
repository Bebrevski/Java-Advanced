import java.util.ArrayDeque;
import java.util.Scanner;

public class HandScore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] cards = scanner.nextLine().split(" ");

        Integer sum = 0;
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < cards.length; i++) {
            String currentCard = cards[i];

            String nextCard = " ";
            if(i != cards.length - 1) {
                nextCard = cards[i + 1];
            }

            stack.push(currentCard);

            if (currentCard.charAt(currentCard.length() - 1) != nextCard.charAt(nextCard.length() - 1)) {
                Integer currentSum = 0;

                for (String card : stack) {
                    int currentValue = card.charAt(0) == 'A' ? 15 :
                                       card.charAt(0) == 'K' ? 14 :
                                       card.charAt(0) == 'Q' ? 13 :
                                       card.charAt(0) == 'J' ? 12 :
                                       card.charAt(0) == '1' ? 10 :
                                       card.charAt(0) - '0';

                    currentSum += currentValue;
                }

                sum += currentSum * stack.size();
                stack.clear();
            }
        }

        System.out.println(sum);
    }
}
