import java.io.File;

public class ListFiles {
    public static void main(String[] args) {
        final String path = "E:\\SoftUni\\Java Advanced\\09. INPUT-OUTPUT FILES AND DIRECTORIES\\Files-and-Streams";

        File file = new File(path);
        if (file.exists() && file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    if (!f.isDirectory()) {
                        System.out.printf("%s: %d%n", f.getName(), f.length());
                    }
                }
            }
        }
    }
}
