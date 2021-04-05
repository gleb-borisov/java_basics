import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите путь и имя папки которую хотите скопировать - ");
        String sourceDirectory = scanner.nextLine();
        System.out.print("Введите путь и имя папки в которую хотите скопировать содержимое первой папки - ");
        String destinationDirectory = scanner.nextLine();

        FileUtils fileUtils = new FileUtils();
        fileUtils.copyFolder(sourceDirectory, destinationDirectory);
    }
}
