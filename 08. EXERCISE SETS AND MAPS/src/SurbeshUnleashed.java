import java.util.*;
        import java.util.regex.Matcher;
        import java.util.regex.Pattern;

public class SurbeshUnleashed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Long>> record = new LinkedHashMap<>();

        String pattern = "^([\\w- ]+)(?:\\s@)([\\w- ]+)(?<=\\s)([0-9]+)\\s([0-9]+)$";

        String input = scanner.nextLine();

        while (!"End".equals(input)) {
            if(input.matches(pattern)) {
                Matcher m = Pattern.compile(pattern).matcher(input);

                String singer = "";
                String venue = "";
                Long totalMoney = 0L;
                while(m.find()) {
                    singer = m.group(1);
                    venue = m.group(2);
                    totalMoney = Long.parseLong(m.group(3)) * Long.parseLong(m.group(4));
                }

                record.putIfAbsent(venue, new LinkedHashMap<>());
                record.get(venue).putIfAbsent(singer, 0L);
                record.get(venue).put(singer, record.get(venue).get(singer) + totalMoney);
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, Map<String, Long>> kvp : record.entrySet()) {
            System.out.println(kvp.getKey());
            kvp.getValue().entrySet()
                    .stream()
                    .sorted((s1, s2) -> Long.compare(s2.getValue(), s1.getValue()))
                    .forEach(s -> System.out.printf("#  %s -> %d%n", s.getKey(), s.getValue()));
        }
    }
}
