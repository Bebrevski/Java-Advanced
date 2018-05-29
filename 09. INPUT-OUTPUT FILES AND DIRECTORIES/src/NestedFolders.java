import java.io.File;
import java.util.ArrayDeque;

public class NestedFolders {
    public static void main(String[] args) {
        final String path = "E:\\SoftUni\\Java Advanced\\09. INPUT-OUTPUT FILES AND DIRECTORIES\\Files-and-Streams";
        File root = new File(path);

        ArrayDeque<File> folders = new ArrayDeque<>();
        folders.offer(root);

        int foldersCount = 0;

        while (!folders.isEmpty()) {
            File current = folders.poll();
            System.out.println(current.getName());
            foldersCount++;

            File[] files = current.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        folders.offer(file);
                    }
                }
            }
        }

        System.out.printf("%d folders%n", foldersCount);
    }
}
