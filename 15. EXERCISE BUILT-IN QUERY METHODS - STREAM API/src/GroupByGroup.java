import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GroupByGroup {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Person1> record = new ArrayList<>();

        String input = reader.readLine();
        while (!"END".equals(input)) {
            String[] tokens = input.split("\\s+");
            String firstName = tokens[0];
            String lastName = tokens[1];
            Integer group = Integer.parseInt(tokens[2]);

            Person1 current = new Person1();
            current.setName(firstName + " " + lastName);
            current.setGroup(group);

            record.add(current);

            input = reader.readLine();
        }

        record.stream()
                .collect(Collectors.groupingBy(p -> p.getGroup()))
                .forEach((k, v) -> {
                    List<String> names = v.stream()
                            .map(n -> n.getName())
                            .collect(Collectors.toList());
                    System.out.printf("%d - %s%n"
                            , k, String.join(", ", names));
                });
    }
}

class Person1 {
    private String Name;
    private Integer Group;

    void setName(String name) {
        this.Name = name;
    }

    String getName() {
        return this.Name;
    }

    void setGroup(Integer group) {
        this.Group = group;
    }

    Integer getGroup() {
        return this.Group;
    }
}
