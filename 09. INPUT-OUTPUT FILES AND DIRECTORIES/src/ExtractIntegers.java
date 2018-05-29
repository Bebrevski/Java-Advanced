import java.io.*;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) {
        final String inputFile = "E:\\SoftUni\\Java Advanced\\09. INPUT-OUTPUT FILES AND DIRECTORIES\\input.txt";
        final String outputFile = "E:\\SoftUni\\Java Advanced\\09. INPUT-OUTPUT FILES AND DIRECTORIES\\output.txt";

        try (Scanner scanner = new Scanner(new FileInputStream(inputFile));
             PrintWriter writer = new PrintWriter(new FileOutputStream(outputFile))) {

            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    writer.println(scanner.nextInt());
                }

                scanner.next();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
