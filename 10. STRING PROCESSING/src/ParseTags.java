import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ParseTags {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder(reader.readLine());

        final String upperOpenTag = "<upcase>";
        final String upperCloseTag = "</upcase>";

        int startIndex = sb.indexOf(upperOpenTag) + upperOpenTag.length();
        int endIndex = sb.indexOf(upperCloseTag);

        while (startIndex > -1 && endIndex > -1) {
            String substr = sb.substring(startIndex, endIndex).toUpperCase();

            sb.replace(startIndex - upperOpenTag.length(), endIndex + upperCloseTag.length(), substr);

            startIndex = sb.indexOf(upperOpenTag) + upperOpenTag.length();
            endIndex = sb.indexOf(upperCloseTag);
        }

        System.out.println(sb);
    }
}
