import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StudentResults {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("[- ,]+");

        String name = input[0];
        Double grade1 = Double.parseDouble(input[1]);
        Double grade2 = Double.parseDouble(input[2]);
        Double grade3 = Double.parseDouble(input[3]);

        Double average = (grade1 + grade2 + grade3) / 3;

        System.out.printf("%1$-10s|%2$7s|%3$7s|%4$7s|%5$7s|%n"
                , "Name", "JAdv", "JavaOOP", "AdvOOP", "Average");

        System.out.printf("%1$-10s|%2$7.2f|%3$7.2f|%4$7.2f|%5$7.4f|"
                , name, grade1, grade2, grade3, average);
    }
}
