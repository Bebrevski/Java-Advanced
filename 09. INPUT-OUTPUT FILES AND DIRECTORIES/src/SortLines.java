import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class SortLines {
    public static void main(String[] args) {
        final Path inPath = Paths.get("E:\\SoftUni\\Java Advanced\\09. INPUT-OUTPUT FILES AND DIRECTORIES\\inputSort.txt");
        final Path outPath = Paths.get("E:\\SoftUni\\Java Advanced\\09. INPUT-OUTPUT FILES AND DIRECTORIES\\output.txt");

        try {
            List<String> lines = Files.readAllLines(inPath);
            Collections.sort(lines);
            Files.write(outPath, lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
