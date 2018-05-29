import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CountCharacterTypes {
    public static void main(String[] args) {
        Path inputPath = Paths.get("E:\\SoftUni\\Java Advanced\\09.1 Files And Directories - Exercises\\Exercises-Resources\\input.txt");
        Path outputPath = Paths.get("E:\\SoftUni\\Java Advanced\\09.1 Files And Directories - Exercises\\Exercises-Resources\\output.txt");

        int vowels = 0;
        int punctuation = 0;
        int consonants = 0;

        try (BufferedReader reader = Files.newBufferedReader(inputPath);
             BufferedWriter writer = Files.newBufferedWriter(outputPath)) {

            String line;
            while ((line = reader.readLine()) != null) {
                char[] currentLine = line.toCharArray();

                for (char c : currentLine) {
                    if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                        vowels++;
                    } else if (c == '!' || c == '?' || c == '.' || c == ',') {
                        punctuation++;
                    } else if (c == ' ') {
                        continue;
                    } else {
                        consonants++;
                    }
                }
            }

            writer.write("Vowels: " + vowels);
            writer.newLine();
            writer.write("Consonants: " + consonants);
            writer.newLine();
            writer.write("Punctuation: " + punctuation);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
