import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LineNumbers {
    public static void main(String[] args) {
        Path inputPath = Paths.get("E:\\SoftUni\\Java Advanced\\09.1 Files And Directories - Exercises\\Exercises-Resources\\inputLineNumbers.txt");
        Path outputPath = Paths.get("E:\\SoftUni\\Java Advanced\\09.1 Files And Directories - Exercises\\Exercises-Resources\\output.txt");

        try (BufferedReader reader = Files.newBufferedReader(inputPath);
             BufferedWriter writer = Files.newBufferedWriter(outputPath)) {

            int lineCounter = 1;
            String line;
            while ((line = reader.readLine()) != null) {
                String currentLine = String.format("%d. %s%n", lineCounter, line);
                writer.write(currentLine);
                lineCounter++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
