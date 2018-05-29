import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TextFilter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] bannedWords = reader.readLine().split(", ");
        String text = reader.readLine();

        for (String bannedWord : bannedWords) {
            String stars = getStars(bannedWord);
            text = text.replaceAll(bannedWord, stars);
        }

        System.out.println(text);
    }

    private static String getStars(String bannedWord) {
        StringBuilder stars = new StringBuilder(bannedWord.length());
        for (int i = 0; i < bannedWord.length(); i++) {
            stars.append("*");
        }

        return stars.toString();
    }
}
