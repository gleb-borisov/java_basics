import java.util.Scanner;

public class Main {

  private static String nameFamily = "";
  private static String nameFirst = "";
  private static String nameSecond = "";

  public static void main(String[] args) {

    System.out.println("Введите Фамилию Имя и Отчество через пробел:");

    Scanner scanner = new Scanner(System.in);
    while (true) {
      String input = scanner.nextLine();
      if (input.equals("0")) {
        break;
      }

      for (int i = 0; i < input.length(); i++) {
        Character digitChar = input.charAt(i);
        if (digitChar.isDigit(digitChar)) {
          System.out.println("Введенная строка не является ФИО");
          return;
        }
      }

      input = input.trim();
      int lenght = input.length();

      for (int a = 0; a < 3; a++) {
        int substring = input.indexOf(" ");
        if (substring == -1) {
          substring = lenght;
        }
        if (a == 0) {
          nameFamily = input.substring(0,substring);
        }
        if (a == 1) {
          nameFirst = input.substring(0,substring);
        }
        if (a == 2) {
          nameSecond = input.substring(0,substring);
        }
        input = input.substring(substring,lenght);
        input = input.trim();
        lenght = input.length();
      }

      if (nameFamily == "" || nameFirst == "" || nameSecond == "") {
        System.out.println("Введенная строка не является ФИО");
        return;
      }

      System.out.println("Фамилия: " + nameFamily);
      System.out.println("Имя: " + nameFirst);
      System.out.println("Отчество: " + nameSecond);
    }
  }
}