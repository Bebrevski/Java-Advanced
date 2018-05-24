import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Set<String> record = new HashSet<>();

        while (!"END".equals(input)) {
            String[] tokens = input.split(", ");
            String direction = tokens[0];
            String carPlate = tokens[1];

            if ("IN".equals(direction)) {
                record.add(carPlate);
            } else if ("OUT".equals(direction)) {
                record.remove(carPlate);
            }

            input = scanner.nextLine();
        }

        if(record.isEmpty()) {
            System.out.println("Parking Lot is Empty");
            return;
        }

        for (String regNum : record) {
            System.out.println(regNum);
        }
    }
}
