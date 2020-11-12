import java.util.Scanner;

public class Main {

  private static String[] nameFull = new String[3];
  private static int lenght;
  private static String x;
  private static int substring;
  private static String input;

  public static void main(String[] args) {

    System.out.println("Введите Фамилию Имя и Отчество через пробел:");

    Scanner scanner = new Scanner(System.in);
    while (true) {
      input = scanner.nextLine();
      if (input.equals("0")) {
        break;
      }

      for (int i = 0; i < input.length(); i++) {
        Character digitChar = input.charAt(i);
        if (Character.isDigit(digitChar)) {
          System.out.println("Введенная строка не является ФИО");
          return;
        }
      }

      input = input.trim();
      lenght = input.length();

      for (int a = 0; a < 3; a++) {
        nameFull[a] = fullNameFormatter();
      }

      if (nameFull[0].equals("") || nameFull[1].equals("") || nameFull[2].equals("")  || input.length() != 0) {
        System.out.println("Введенная строка не является ФИО");
        return;
      }

      System.out.println("Фамилия: " + nameFull[0]);
      System.out.println("Имя: " + nameFull[1]);
      System.out.println("Отчество: " + nameFull[2]);
    }
  }

  public static String fullNameFormatter () {
    substring = input.indexOf(" ");
    if (substring == -1) {
      substring = lenght;
    }
    x = input.substring(0, substring);
    input = input.substring(substring, lenght);
    input = input.trim();
    lenght = input.length();
    return x;
  }
}