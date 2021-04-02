import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtils {

    private static long filesSumLength = 0;

    public static long calculateFolderSize(String path) {

        Path folder = Paths.get(path);

        System.out.println("\nСписок папок и файлов в папке " + path + " -\n");
        recursionModule(folder);
        return filesSumLength;
    }

    public static Path recursionModule(Path folder) {
        try {
        DirectoryStream<Path> files = Files.newDirectoryStream(folder);
            for (Path path : files) {
                System.out.println(path);
                filesSumLength += Files.size(Path.of(String.valueOf(path)));
                if (Files.isDirectory(Path.of(String.valueOf(path)))) {
                    folder = path;
                    recursionModule(folder);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Message of Exception - " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Message of Exception - " + e.getMessage());
        }
        return folder;
    }
}