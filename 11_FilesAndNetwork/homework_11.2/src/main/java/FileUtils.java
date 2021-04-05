import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class FileUtils {

    public static void copyFolder(String sourceDirectory, String destinationDirectory) {

        try {
            Files.walkFileTree(Paths.get(sourceDirectory), new FileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    System.out.println("Папка - " + dir.toString());
                    Path path = Paths.get(destinationDirectory).resolve(Paths.get(sourceDirectory).relativize(dir));
                    if (!Files.exists(path)) {
                        Files.createDirectory(path);
                    }
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    System.out.println("Файл - " + file.toString());
                    Files.copy(file, Paths.get(destinationDirectory).resolve(Paths.get(sourceDirectory).relativize(file)),
                            StandardCopyOption.REPLACE_EXISTING);
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
            System.out.print("Message of Exception - "  + e.getMessage());
        }
        System.out.println("Копирование завершено.");
    }
}
