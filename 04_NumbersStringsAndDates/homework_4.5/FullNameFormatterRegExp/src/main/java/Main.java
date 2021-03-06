import java.util.Scanner;

public class Main {

  private static String[] wordArray;
  private static String input;
  private static boolean isNameCorrect;

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

      isNameCorrect = true;
      fullNameFormatter(input);
      checkName();

      if (isNameCorrect) {
        System.out.println("Фамилия: " + wordArray[0]);
        System.out.println("Имя: " + wordArray[1]);
        System.out.print("Отчество: " + wordArray[2]);
        if (wordArray.length > 3) {
          System.out.println(" " + wordArray[3]);
        }
      }
    }
  }

    private static void fullNameFormatter (String input) {
    input = input.trim();
    wordArray = input.split("\\s+");
    }

    private static void checkName () {
    for (int i = 0; i < 3; i++) {
      if (wordArray[i].matches("[А-Я][А-Яа-я-]+") == false || wordArray.length < 3 || wordArray.length > 4) {
        System.out.println("Введенная строка не является ФИО");
        isNameCorrect = false;
        return;
      }
    }
  }
}