import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Robotics {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = reader.readLine().split(";");
        String[] names = new String[inputs.length];

        int[] processingTimes = new int[inputs.length];
        int[] robotTimes = new int[inputs.length];

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < inputs.length; i++) {
            String[] data = inputs[i].split("-");
            String name = data[0];
            int time = Integer.parseInt(data[1]);
            names[i] = name;
            processingTimes[i] = time;
        }

        inputs = reader.readLine().split(":");
        int hours = Integer.parseInt(inputs[0]);
        int minutes = Integer.parseInt(inputs[1]);
        int seconds = Integer.parseInt(inputs[2]);

        ArrayDeque<String> products = new ArrayDeque<>();
        String product = reader.readLine();

        while (!product.equals("End")) {
            products.add(product);
            product = reader.readLine();
        }

        while (!products.isEmpty()) {
            seconds++;
            if (seconds == 60) {
                seconds = 0;
                minutes++;
                if (minutes == 60) {
                    minutes = 0;
                    hours++;
                    if (hours == 24) {
                        hours = 0;
                    }
                }
            }
            String productToProcess = products.poll();
            boolean processed = false;
            for (int i = 0; i < names.length; i++) {
                if (robotTimes[i] <= 0 && !processed) {
                    robotTimes[i] = processingTimes[i] - 1;
                    processed = true;
                    sb.append(String.format("%s - %s [%02d:%02d:%02d]", names[i], productToProcess,
                            hours, minutes, seconds)).append(System.lineSeparator());
                } else {
                    robotTimes[i]--;
                }
            }
            if (!processed) {
                products.offer(productToProcess);
            }
        }
        System.out.println(sb);
    }
}