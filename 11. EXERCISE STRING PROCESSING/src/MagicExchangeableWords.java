import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class MagicExchangeableWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        Set<Character> firstWord = input[0].chars().mapToObj(c -> (char)c).collect(Collectors.toCollection(LinkedHashSet::new));
        Set<Character> secondWord = input[1].chars().mapToObj(c -> (char)c).collect(Collectors.toCollection(LinkedHashSet::new));

        if (firstWord.size() == secondWord.size())
        {
            System.out.println("true");
        }
        else
        {
            System.out.println("false");
        }
    }
}
