import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CopyBytes {
    public static void main(String[] args) {
        final String inputFile = "E:\\SoftUni\\Java Advanced\\09. INPUT-OUTPUT FILES AND DIRECTORIES\\input.txt";
        final String outputFile = "E:\\SoftUni\\Java Advanced\\09. INPUT-OUTPUT FILES AND DIRECTORIES\\output.txt";

        final Set<Character> special = new HashSet<>(Arrays.asList(' ', '\n'));

        try (InputStream inputStream = new FileInputStream(inputFile);
             OutputStream outputStream = new FileOutputStream(outputFile)) {

            int oneByte;
            while ((oneByte = inputStream.read()) >= 0) {
                if (!special.contains((char) oneByte)) {
                    char[] digits = String.valueOf(oneByte).toCharArray();
                    for (char digit : digits) {
                        outputStream.write(digit);
                    }
                } else {
                    outputStream.write(oneByte);
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
