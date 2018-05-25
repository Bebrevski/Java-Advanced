import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] lengths = reader.readLine().split(" ");
        int firstLength = Integer.parseInt(lengths[0]);
        int secondLength = Integer.parseInt(lengths[1]);

        Set<String> firstSet = new LinkedHashSet<>();
        Set<String> secondSet = new LinkedHashSet<>();

        for (int i = 0; i < firstLength + secondLength; i++) {
            if (i < firstLength) {
                firstSet.add(reader.readLine());
            } else {
                secondSet.add(reader.readLine());
            }
        }

        StringBuilder output = new StringBuilder();
        for (String e : firstSet) {
            if (secondSet.contains(e)) {
                output.append(e + " ");
            }
        }

        System.out.println(output);
    }
}
