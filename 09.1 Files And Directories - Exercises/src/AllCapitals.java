import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AllCapitals {
    public static void main(String[] args) {
        Path inputPath = Paths.get("E:\\SoftUni\\Java Advanced\\09.1 Files And Directories - Exercises\\Exercises-Resources\\input.txt");
        Path outputPath = Paths.get("E:\\SoftUni\\Java Advanced\\09.1 Files And Directories - Exercises\\Exercises-Resources\\output.txt");

        try (BufferedReader reader = Files.newBufferedReader(inputPath);
             BufferedWriter writer = Files.newBufferedWriter(outputPath)) {

            String line;
            while ((line = reader.readLine()) != null) {
                line = line.toUpperCase();
                writer.write(line);
                writer.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
