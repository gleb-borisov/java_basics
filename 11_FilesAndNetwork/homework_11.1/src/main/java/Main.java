import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите путь до исследуемой папки - ");
        String path = scanner.nextLine();

        FileUtils fileUtils = new FileUtils();
        long filesTotalSize = fileUtils.calculateFolderSize(path);

        System.out.println("\nРазмер файлов размещенных на диске D:\n" +
                "\n\tВ байтах - " + String.format("%,d", filesTotalSize) + " Byte (B)" +
                "\n\tВ килобайтах - " + String.format("%,.3f", (double)filesTotalSize/1024L) + " KByte (KB)" +
                "\n\tВ мегабайтах - " + String.format("%,.3f", (double)filesTotalSize/(1024*1024L)) + " MByte (MB)" +
                "\n\tВ гигабайтах - " + String.format("%,.3f", (double)filesTotalSize/(1024*1024*1024L)) + " GByte (GB)" +
                "\n\tВ террабайтах - " + String.format("%,.3f", (double)filesTotalSize/(1024*1024*1024*1024L)) + " TByte (TB)" + "\n");
    }
}
