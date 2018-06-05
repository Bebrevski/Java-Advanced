import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FirstName {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> names = Arrays.stream(reader.readLine().split("\\s+"))
                .collect(Collectors.toList());

        List<String> letters = Arrays.stream(reader.readLine().split("\\s+"))
                .map(String::toLowerCase)
                .collect(Collectors.toList());

        Optional<String> name = names.stream()
                .sorted()
                .filter(x -> letters.contains(String.valueOf(x.charAt(0)).toLowerCase()))
                .findFirst();

        if (name.isPresent()) {
            System.out.println(name.get());
        } else {
            System.out.println("No match");
        }
    }
}
