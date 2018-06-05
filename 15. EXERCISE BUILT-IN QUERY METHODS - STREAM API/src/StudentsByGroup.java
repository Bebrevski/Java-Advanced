import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentsByGroup {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Person> record = new ArrayList<>();

        String input = reader.readLine();
        StudentsByAge.fillData(reader, record, input);

        record.stream()
                .filter(p -> p.getGroup() == 2)
                .sorted(Comparator.comparing(Person::getFirstName))
                .forEach(p -> System.out.println(p.getFirstName() + " " + p.getLastName()));
    }
}

class Person {
    private String FirstName;
    private String LastName;
    private Integer Group;

    void setFirstName(String name) {
        this.FirstName = name;
    }

    String getFirstName() {
        return this.FirstName;
    }

    void setLastName(String name) {
        this.LastName = name;
    }

    String getLastName() {
        return this.LastName;
    }

    void setGroup(Integer group) {
        this.Group = group;
    }

    Integer getGroup() {
        return this.Group;
    }
}
