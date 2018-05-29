import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WordCount {
    public static void main(String[] args) {
        Path path = Paths.get("E:\\SoftUni\\Java Advanced\\09.1 Files And Directories - Exercises\\Exercises-Resources\\input.txt");

        final Map<String, Integer> wordsCount = new HashMap<>();
        final Map<String, String> originalWords = new HashMap<>();


        try (BufferedReader br = Files.newBufferedReader(path);
             BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            Arrays.stream(reader.readLine().split("\\s+"))
                    .forEach(word -> {
                        wordsCount.put(word.toLowerCase(), 0);
                        originalWords.put(word.toLowerCase(), word);
                    });

            br.lines()
                    .forEach(str -> Arrays.stream(str.split("\\s+"))
                            .forEach(word -> {
                                word = word.toLowerCase();
                                Integer oldCount = wordsCount.get(word);
                                if (oldCount != null) {
                                    wordsCount.put(word, oldCount + 1);
                                }
                            }));
        } catch (IOException e) {
            e.printStackTrace();
        }

        wordsCount.entrySet().stream()
                .sorted((w1, w2) -> w2.getValue().compareTo(w1.getValue()))
                .forEach(kvp -> System.out.printf("%s - %d%n",
                        originalWords.get(kvp.getKey()), kvp.getValue()));
    }
}
