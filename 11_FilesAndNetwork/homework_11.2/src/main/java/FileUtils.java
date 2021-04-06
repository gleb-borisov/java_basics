import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;

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
                    Path files = Paths.get(destinationDirectory).resolve(Paths.get(sourceDirectory).relativize(file));
                    if (Files.exists(files)){
                        System.out.println("Файл уже существует!");
                        System.out.print("Заменить файл (yes/no)? - ");
                        Scanner scanner = new Scanner(System.in);
                        String yesNoCopy = scanner.nextLine();
                        if (yesNoCopy.equals("no")) {
                            return FileVisitResult.CONTINUE;
                        } else {
                            Files.copy(file, Paths.get(destinationDirectory).resolve(Paths.get(sourceDirectory).relativize(file)),
                                    StandardCopyOption.REPLACE_EXISTING);
                        }
                    } else {
                        Files.copy(file, Paths.get(destinationDirectory).resolve(Paths.get(sourceDirectory).relativize(file)),
                                StandardCopyOption.REPLACE_EXISTING);
                    }
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
