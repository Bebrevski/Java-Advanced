import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadFile {
    public static void main(String[] args) {
        final String path = "E:\\SoftUni\\Java Advanced\\09. INPUT-OUTPUT FILES AND DIRECTORIES\\input.txt";

        try (InputStream fileStream = new FileInputStream(path)) {
            int oneByte = fileStream.read();
            while(oneByte >= 0 ) {
                System.out.printf("%s ", Integer.toBinaryString(oneByte));
                oneByte = fileStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
