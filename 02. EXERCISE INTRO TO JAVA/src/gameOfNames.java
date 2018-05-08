import java.util.*;

public class gameOfNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int players = Integer.parseInt(scanner.nextLine());

        HashMap<String, Integer> allPoints = new HashMap<>();

        for (int i = 0; i < players; i++) {
            String name = scanner.nextLine();
            Integer initialPoints = Integer.parseInt(scanner.nextLine());

            for (int j = 0; j < name.length(); j++) {
                int asciiCode = (int) name.charAt(j);

                if (asciiCode % 2 == 0) {
                    initialPoints += asciiCode;
                } else {
                    initialPoints -= asciiCode;
                }
            }

            allPoints.put(name, initialPoints);
        }

        HashMap.Entry<String, Integer> winner = allPoints
                .entrySet()
                .stream()
                .sorted((p1, p2) -> Integer.compare(p2.getValue(), p1.getValue()))
                .iterator().next();

        System.out.printf("The winner is %s - %d points", winner.getKey(), winner.getValue());
    }
}
