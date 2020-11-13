import java.util.Scanner;

public class Main {

  private static String[] phoneNumberArray;
  private static String number;

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    while (true) {
      String input = scanner.nextLine();
      if (input.equals("0")) {
        break;
      }

      number = "";
      cleanerPhoneNumber(input);

    if (phoneNumberArray[0].equals("7") || phoneNumberArray[0].equals("8")) {
        if (number.length() < 11 || number.length() > 11) {
            System.out.println("Номер телефона введён неверно");
        } else {
            System.out.println(number);
        }
    } else {
        System.out.println("Номер телефона введён неверно");
    }
    }
  }

  public static String cleanerPhoneNumber (String input) {
      phoneNumberArray = input.split("\\D*");
      if (phoneNumberArray[0].equals("8")) {
          phoneNumberArray[0] = "7";
      }
      for (String digit : phoneNumberArray) {
          number = number + digit;
      }
      if (number.length() == 10) {
          number = "7" + number;
      }
      phoneNumberArray = number.split("\\D*");
      return number;
  }
}
