import java.util.Scanner;

public class byteParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        short[] numbers = new short[count];

        for (int i = 0; i < count; i++) {
            numbers[i] = Short.parseShort(scanner.nextLine());
        }

        String command = scanner.nextLine();

        while (!(command.toLowerCase()).equals("party over")) {
            String[] splitCommand = command.split("\\s+");
            int action = Integer.parseInt(splitCommand[0]);
            int position = Integer.parseInt(splitCommand[1]);

            executeProgram(numbers, action, position);

            command = scanner.nextLine();
        }

        for (short num : numbers) {
            System.out.println(num);
        }
    }

    private static void executeProgram(short[] numbers, int action, int position) {
        switch (action) {
            case -1:
                flipBit(numbers, position);
                break;
            case 1:
                setBit(numbers, position);
                break;
            case 0:
                clearBit(numbers, position);
                break;
            default:
                break;
        }
    }

    private static void clearBit(short[] numbers, int position) {
        int mask = ~(1 << position); //NOT operator reverse the bits of shifted number
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] &= mask; // AND operator - returns 1 only if both operands are 1
        }
    }

    private static void setBit(short[] numbers, int position) {
        int mask = 1 << position;
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] |= mask; // OR operator - returns 0 only if both operands are 0
        }
    }

    private static void flipBit(short[] numbers, int position) {
        int mask = 1 << position;
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] ^= mask; //XOR operand - returns 1 only if both operands are different
        }
    }
}
