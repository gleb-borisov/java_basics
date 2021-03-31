import java.io.File;
import java.io.FileNotFoundException;

public class FileUtils extends Throwable {

    private static long filesSumLength = 0;

    public static long calculateFolderSize(String path) {
        File folder = new File(path);
        System.out.println("\nСписок папок и файлов в папке " + path + " -\n");
        try {
            recursionModule(folder);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return filesSumLength;
    }

    public static File recursionModule(File folder) throws FileNotFoundException {
        for (File file : folder.listFiles()) {
            System.out.println(file.getName());
            filesSumLength += file.length();
            if (file.isDirectory()) {
                folder = new File(file.getPath());
                recursionModule(folder);
            }
        }
        return folder;
    }
}
