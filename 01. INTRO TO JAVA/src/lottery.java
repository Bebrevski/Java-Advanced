public class lottery {
    public static void main(String[] args) {
        final int endNumber = 10;

        for (int i = 1; i <= endNumber - 2; i++) {
            for (int j = i + 1; j <= endNumber - 1; j++) {
                for (int k = j + 1; k <= endNumber; k++) {
                    System.out.printf("%d %d %d%n", i, j, k);
                }
            }
        }
    }
}
