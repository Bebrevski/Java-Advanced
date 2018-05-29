import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SumBytes {
    public static void main(String[] args) {
        Path path = Paths.get("E:\\SoftUni\\Java Advanced\\09.1 Files And Directories - Exercises\\Exercises-Resources\\input.txt");

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line = reader.readLine();
            BigInteger sum = new BigInteger("0");
            while (line != null) {
                char[] charArr = line.toCharArray();
                for (char c : charArr) {
                    sum = sum.add(BigInteger.valueOf(c));
                }

                line = reader.readLine();
            }

            System.out.println(sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
