import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem3 {

    private static final Pattern PATTERN = Pattern.compile("^([!@#$?a-z]+)(=\\d+)(--\\d+)(<<[a-z]+)");
    private static final String END = "Stop!";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> record = new HashMap<>();

        String input = reader.readLine();
        while (!END.equals(input)) {
            Matcher match = PATTERN.matcher(input);

            if (match.find()) {
                String nameOfGene = match.group(1).replaceAll("[!@#$?]+", "");
                Integer lengthOfName = Integer.parseInt(match.group(2).replaceAll("=", ""));
                Integer countOfGenes = Integer.parseInt(match.group(3).replaceAll("--", ""));
                String organism = match.group(4).replaceAll("<<", "");

                if (nameOfGene.length() != lengthOfName) {
                    input = reader.readLine();
                    continue;
                }

                record.putIfAbsent(organism, 0);
                record.put(organism, record.get(organism) + countOfGenes);
            }

            input = reader.readLine();
        }

        StringBuilder sb = new StringBuilder();
        record.entrySet().stream()
                .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                .forEach(o -> {
                    sb
                            .append(o.getKey())
                            .append(" has genome size of ")
                            .append(o.getValue())
                            .append(System.lineSeparator());
                });

        System.out.println(sb);
    }
}
