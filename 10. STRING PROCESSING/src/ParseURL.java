import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ParseURL {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(":\\/\\/");

        if (input.length != 2) {
            System.out.println("Invalid URL");
            return;
        }

        String protocol = input[0];
        String server = input[1].substring(0, input[1].indexOf("/"));
        String resources = input[1].substring(server.length() + 1);

        System.out.println("Protocol = " + protocol);
        System.out.println("Server = " + server);
        System.out.println("Resources = " + resources);
    }
}
