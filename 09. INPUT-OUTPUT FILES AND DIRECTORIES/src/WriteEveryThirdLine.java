import java.io.*;

public class WriteEveryThirdLine {
    public static void main(String[] args) {
        final String inputFile = "E:\\SoftUni\\Java Advanced\\09. INPUT-OUTPUT FILES AND DIRECTORIES\\input.txt";
        final String outputFile = "E:\\SoftUni\\Java Advanced\\09. INPUT-OUTPUT FILES AND DIRECTORIES\\output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {

            int counter = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                if (++counter % 3 == 0) {
                    writer.println(line);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
