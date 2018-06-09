import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NMS {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder line = new StringBuilder();
        String input = reader.readLine();
        while (!"---NMS SEND---".equals(input)) {
            line.append(input);

            input = reader.readLine();
        }

        String delimiter = reader.readLine();

        List<String> output = new ArrayList<>();
        List<String> chars = Arrays.stream(line.toString().split("")).collect(Collectors.toList());

        int fromIndex = 0;
        for (int i = 1; i < chars.size(); i++) {
            String first = chars.get(i - 1);
            String oneForward = chars.get(i);

            if(first.compareToIgnoreCase(oneForward) > 0) {
            output.add(String.join("", chars.subList(fromIndex, i)));
            fromIndex = i;
            }
        }
        output.add(String.join("", chars.subList(fromIndex, chars.size())));
        System.out.println(String.join(delimiter, output));
    }
}
