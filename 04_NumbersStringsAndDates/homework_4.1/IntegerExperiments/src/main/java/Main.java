import java.lang.reflect.Array;
import java.util.stream.IntStream;

public class Main {

  public static void main(String[] args) {
    Container container = new Container();
    container.count += 7843;

    int sum = sumDigits(7843);

    System.out.println(sum);
  }

  /* Реализуйте метод sumDigits который возвращает сумму цифр числа, пример:
  передано 12345, метод должен вернуть 15
  если передано null, то должен вернуть -1

  Запустите тесты TestSumDigits для проверки корректности работы метода

  не меняйте название метода, его возвращаемое значение и модификаторы доступа (public).
  В противном случае тестовый метод не сможет проверить ваш код
   */

  public static int sumDigits(Integer number) {
    int x;
    if (number == null) {
      x = -1;
      return x;
    } else {
      String numberString = number.toString();
      int[] arrayOfNumbers = new int[numberString.length()];
      for (int i = 0; i < numberString.length(); i++) {
        Character oneOfSumChar = numberString.charAt(i);
        Integer oneOfSum = Integer.parseInt(oneOfSumChar.toString());
        arrayOfNumbers[i] = oneOfSum;
      }
      x = IntStream.of(arrayOfNumbers).sum();
      return x;
    }
  }
}
