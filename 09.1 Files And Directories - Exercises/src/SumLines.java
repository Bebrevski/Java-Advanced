import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SumLines {
    public static void main(String[] args) {
        Path path = Paths.get("E:\\SoftUni\\Java Advanced\\09.1 Files And Directories - Exercises\\Exercises-Resources\\input.txt");

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line = reader.readLine();
            while (line != null) {
                long sum = 0L;
                char[] charArr = line.toCharArray();
                for (char c : charArr) {
                    sum += c;
                }

                System.out.println(sum);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
