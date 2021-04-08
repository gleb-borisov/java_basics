import java.io.IOException;

public class Main {

    private static final String BANK_STATEMENT = "src/main/resources/movementList.csv";

    public static void main(String[] args) throws IOException {

        Movements movements = new Movements(BANK_STATEMENT);

        System.out.println("Сумма доходов - " + movements.getIncomeSum() + " руб.");
        System.out.println("Сумма расходов - " + movements.getExpenseSum() + " руб.");
        movements.makeMovementList();
    }
}
