import java.util.Scanner;

public class Main {

  private static String[] wordArray;
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

      fullNameFormatter(input);

      if (wordArray[0].equals("") || wordArray[1].equals("") || wordArray[2].equals("") || wordArray.length > 3) {
        System.out.println("Введенная строка не является ФИО");
        return;
      }

      System.out.println("Фамилия: " + wordArray[0]);
      System.out.println("Имя: " + wordArray[1]);
      System.out.println("Отчество: " + wordArray[2]);
    }
  }

    public static void fullNameFormatter (String input) {
    input = input.trim();
    wordArray = input.split("\\s+");
    }
}