import java.io.IOException;
import java.util.ArrayList;

public class Movements {

    private ArrayList<Transaction> transactions;
    private String pathMovementsCsv;
    private static Double sum;

    public Movements(String pathMovementsCsv) {
        this.pathMovementsCsv = pathMovementsCsv;
    }

    public double getExpenseSum() throws IOException {
        parseTextFile(pathMovementsCsv);
        sum = 0.0;
        transactions.forEach(e-> sum += e.getExpense());
        return sum;
    }

    public double getIncomeSum() throws IOException {
        parseTextFile(pathMovementsCsv);
        sum = 0.0;
        transactions.forEach(e-> sum += e.getIncome());
        return sum;
    }

    private ArrayList<Transaction> parseTextFile (String pathMovementsCsv) throws IOException {
        Parser parser = new Parser(pathMovementsCsv);
        return transactions = parser.parseTransaction();
    }

    public void getListTransaction () throws IOException {
        System.out.println("\nПриходы и расходы по организациям\n" +
                "Название организации --- Приход --- Расход\n" +
                "___________________________________________\n");
        parseTextFile(pathMovementsCsv).forEach(e-> {System.out.println(e.getCounterparty()
                + " --- " + e.getIncome() + " --- " + e.getExpense());});
    }
}
