import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ToTheStars {
    public static void main(String[] args) {

        List<StarSystem> galaxy = new LinkedList<>();

        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");

        while (tokens.length > 2) {

            String name = tokens[0];
            double x = Double.parseDouble(tokens[1]);
            double y = Double.parseDouble(tokens[2]);
            galaxy.add(new StarSystem(name, x, y));

            tokens = scanner.nextLine().split("\\s+");
        }

        double shipX = Double.parseDouble(tokens[0]);
        double shipY = Double.parseDouble(tokens[1]);
        int shipMoves = scanner.nextInt();

        while (shipMoves-- >= 0) {
            boolean inStarSystem = false;

            for (StarSystem starSystem : galaxy) {
                if (starSystem.isWithin(shipX, shipY)) {
                    System.out.println(starSystem.getName());
                    inStarSystem = true;
                    break;
                }
            }

            shipY++;

            if (!inStarSystem) {
                System.out.println("space");
            }
        }
    }

    private static class StarSystem {

        private final String name;
        private final double x;
        private final double y;

        StarSystem(String name, double x, double y) {
            this.name = name.toLowerCase();
            this.x = x - 1d;
            this.y = y - 1d;
        }

        String getName() {
            return this.name;
        }

        boolean isWithin(double x, double y) {
            return x >= this.x && x <= this.x + 2d &&
                    y >= this.y && y <= this.y + 2d;
        }
    }
}
