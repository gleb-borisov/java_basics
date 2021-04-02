import java.util.Scanner;

public class Main {

    private static final long DENOMINATOR_KB = 1024L;
    private static final long DENOMINATOR_MB = 1024*1024L;
    private static final long DENOMINATOR_GB = 1024*1024*1024L;
    private static final long DENOMINATOR_TB = 1024*1024*1024*1024L;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите путь до исследуемой папки - ");
        String path = scanner.nextLine();

        FileUtils fileUtils = new FileUtils();
        long filesTotalSize = fileUtils.calculateFolderSize(path);

        System.out.println("\nРазмер файлов размещенных на диске D:\n" +
                "\n\tВ байтах - " + String.format("%,d", filesTotalSize) + " Byte (B)" +
                "\n\tВ килобайтах - " + String.format("%,.3f", (double)filesTotalSize/DENOMINATOR_KB) + " KByte (KB)" +
                "\n\tВ мегабайтах - " + String.format("%,.3f", (double)filesTotalSize/DENOMINATOR_MB) + " MByte (MB)" +
                "\n\tВ гигабайтах - " + String.format("%,.3f", (double)filesTotalSize/DENOMINATOR_GB) + " GByte (GB)" +
                "\n\tВ террабайтах - " + String.format("%,.3f", (double)filesTotalSize/DENOMINATOR_TB) + " TByte (TB)" + "\n");
    }
}
