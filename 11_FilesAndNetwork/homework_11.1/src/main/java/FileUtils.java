import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class FileUtils {

    private static long filesSumLength = 0;

    public static long calculateFolderSize(String path) {

        try {
            Files.walkFileTree(Paths.get(path), new FileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
                    System.out.println("Папка - " + dir.toString());
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    System.out.println("Файл - " + file.toString());
                    filesSumLength += Files.size(Path.of(String.valueOf(file)));
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) {
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (FileNotFoundException e) {
            System.out.println("Message of Exception - " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Message of Exception - " + e.getMessage());
        }
        return filesSumLength;
    }
}