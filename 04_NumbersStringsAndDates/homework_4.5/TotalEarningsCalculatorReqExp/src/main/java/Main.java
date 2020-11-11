public class Main {

  public static void main(String[] args) {

    String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
    System.out.println("Общий заработок составил - " + calculateSalarySum(text));

  }

  public static int calculateSalarySum(String text){

    String[] earningsString = text.split("\\D+");
    int[] earning = new int[earningsString.length];
    int earningSum = 0;

    for (int i = 1; i < earningsString.length; i++) {
      earning[i] = Integer.parseInt(earningsString[i]);
      earningSum += earning[i];
    }
    return earningSum;
  }

}