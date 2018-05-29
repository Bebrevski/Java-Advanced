import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WriteToFile {
    public static void main(String[] args) {
        final String inputFile = "E:\\SoftUni\\Java Advanced\\09. INPUT-OUTPUT FILES AND DIRECTORIES\\input.txt";
        final String outputFile = "E:\\SoftUni\\Java Advanced\\09. INPUT-OUTPUT FILES AND DIRECTORIES\\output.txt";

        final Set<Character> punctuation = new HashSet<>(Arrays.asList(',', '.', '!', '?'));

        try (InputStream inputStream = new FileInputStream(inputFile);
             OutputStream outputStream = new FileOutputStream(outputFile)) {

            int oneByte = inputStream.read();
            while (oneByte >= 0) {
                if (!punctuation.contains((char) oneByte)) {
                    outputStream.write(oneByte);
                }

                oneByte = inputStream.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
