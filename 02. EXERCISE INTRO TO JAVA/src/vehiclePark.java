import java.util.*;

public class vehiclePark {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> vehicles = new ArrayList<>();

        Collections.addAll(vehicles, scanner.nextLine().split("\\s+"));

        int soldVehicles = 0;
        String input = scanner.nextLine();

        while (!input.equals("End of customers!")) {
            char type = input.toLowerCase().charAt(0);
            int seats = Integer.parseInt(input.replaceAll("\\D+", ""));

            String currentVehicle = "" + type + seats;

            if (vehicles.contains(currentVehicle)) {
                int price = type * seats;
                System.out.printf("Yes, sold for %d$%n", price);
                soldVehicles++;
                vehicles.remove(currentVehicle);
            } else {
                System.out.println("No");
            }

            input = scanner.nextLine();
        }

       printResult(vehicles, soldVehicles);
    }

    private static void printResult(List<String> vehicles, int soldVehicles) {
        System.out.print("Vehicles left: ");
        for (int e = 0; e < vehicles.size(); e++) {
            System.out.print(vehicles.get(e));

            if(e != vehicles.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
        System.out.printf("Vehicles sold: %d", soldVehicles);
    }
}
