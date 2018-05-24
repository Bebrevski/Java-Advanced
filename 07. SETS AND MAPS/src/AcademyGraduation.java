import java.util.*;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int studentsCount = Integer.parseInt(scanner.nextLine());

        Map<String, double[]> record = new TreeMap<>();

        for (int i = 0; i < studentsCount; i++) {
            String currentStudent = scanner.nextLine();
            double[] graders = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToDouble(Double::parseDouble).toArray();

            if (!record.containsKey(currentStudent)) {
                record.put(currentStudent, graders);
            }
        }

        for (Map.Entry<String, double[]> student : record.entrySet()) {
            double averageGrade = getAverageGrade(student.getValue());

            System.out.printf("%s is graduated with %s%n", student.getKey(), averageGrade);
        }
    }

    private static double getAverageGrade(double[] scores) {
        double grade = 0;
        for (double g : scores) {
            grade += g;
        }

        return grade / scores.length;
    }
}
