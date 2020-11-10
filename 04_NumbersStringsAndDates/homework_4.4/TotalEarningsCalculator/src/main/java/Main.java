public class Main {

  public static void main(String[] args) {

    String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
    String textDigit = "";
    int earning = 0;
    int sum = 0;

    for (int i = 0; i < text.length(); i++) {
      Character digitChar = text.charAt(i);
      if (digitChar.isDigit(digitChar)) {
        earning = text.indexOf(' ',i);
        textDigit = text.substring(i,earning);
        sum = sum + Integer.parseInt(textDigit);
        i = earning;
      }
    }
    System.out.println("Сумма заработков друзей составила - " + sum + " рублей");
  }
}