import java.util.Scanner;

public class xBits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbers = new String[8];

        for (int i = 0; i < 8; i++) {
            numbers[i] = String.format("%32s",
                    Integer.toBinaryString(Integer.parseInt(scanner.nextLine())))
                    .replace(' ', '0');
        }

        int count = 0;
        for (int row = 0; row < 8 - 2; row++) {
          for (int col = 0; col < 32 - 2; col++) {
              String a = numbers[row].substring(col, col + 3);
              String b = numbers[row + 1].substring(col, col + 3);
              String c = numbers[row + 2].substring(col, col + 3);

              if(a.equals("101") && b.equals("010") && c.equals("101")) {
              count++;
              }
          }
        }

        System.out.println(count);
    }
}
