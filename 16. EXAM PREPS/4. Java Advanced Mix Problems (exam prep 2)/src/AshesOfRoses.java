//    SOLUTION 2 WITH CLASS

public class AshesOfRoses {
    public static void main(String[] args) {

    }
}

//    SOLUTION 1 WITH NESTED MAPS

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//import java.util.stream.Collectors;
//
//public class AshesOfRoses {
//
//    private static final String PATTERN = "^Grow <[A-Z][a-z]+> <[a-zA-Z0-9]+> \\d+$";
//    private static final String END_COMMAND = "Icarus, Ignite!";
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        Map<String, Map<String, Long>> record = new TreeMap<>();
//
//        String input = reader.readLine();
//        while (!END_COMMAND.equals(input)) {
//            if (input.matches(PATTERN)) {
//                List<String> tokens = Arrays.stream(input.split("Grow |[<> ]+"))
//                        .filter(x -> !x.isEmpty())
//                        .collect(Collectors.toList());
//                String region = tokens.get(0);
//                String color = tokens.get(1);
//                Long amount = Long.parseLong(tokens.get(2));
//
//                record.putIfAbsent(region, new TreeMap<>());
//                record.get(region).putIfAbsent(color, 0L);
//                record.get(region).put(color, record.get(region).get(color) + amount);
//            }
//
//            input = reader.readLine();
//        }
//
//        StringBuilder sb = new StringBuilder();
//
//        record.entrySet().stream()
//                .sorted((kvp1, kvp2) -> {
//                    long kvp1Sum = kvp1.getValue().values().stream().reduce(0L, (a, b) -> a + b);
//                    long kvp2Sum = kvp2.getValue().values().stream().reduce(0L, (a, b) -> a + b);
//
//                    return Long.compare(kvp2Sum, kvp1Sum);
//                })
//                .forEach(kvp -> {
//                    sb.append(kvp.getKey()).append(System.lineSeparator());
//
//                    kvp.getValue().entrySet().stream()
//                            .sorted((kv1, kv2) -> {
//                                long kv1Sum = kv1.getValue();
//                                long kv2Sum = kv2.getValue();
//
//                                return Long.compare(kv1Sum, kv2Sum);
//                            })
//                            .forEach(c -> {
//                                sb
//                                        .append("*--")
//                                        .append(c.getKey())
//                                        .append(" | ")
//                                        .append(c.getValue())
//                                        .append(System.lineSeparator());
//                            });
//                });
//
//        System.out.println(sb);
//    }
//}
