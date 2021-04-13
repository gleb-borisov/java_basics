import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    private static String pathMovementsCsv;
    private Transaction transaction;

    public Parser(String pathMovementsCsv) {
        this.pathMovementsCsv = pathMovementsCsv;
    }

    public ArrayList<Transaction> parseTransaction () throws IOException {
        ArrayList<Transaction> transactions = new ArrayList<>();
        List<String> lines = Files.readAllLines(Paths.get(pathMovementsCsv));
        lines.remove(0);
        lines.forEach(e -> {
            String[] fragments1 = e.split("\\s{2,}");
            String[] fragments2 = e.split("\\s{4}");
            String[] fragments3 = fragments1[fragments1.length - 1].split(",\"|\",|\"|,(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
            String[] fragments4 = fragments2[1].split("\\\\|/");
            boolean isTransaction = false;
            for (Transaction a : transactions){
                if (a.getCounterparty().equals(fragments4[fragments4.length - 1])) {
                    transaction = a;
                    isTransaction = true;
                    break;
                }
            }
            if (!isTransaction) {
                transaction = new Transaction();
                transactions.add(transaction);
                transaction.setCounterparty(fragments4[fragments4.length - 1]);
            }
            transaction.setIncome(transaction.getIncome() + Double.parseDouble(fragments3[1].replace(',', '.')));
            transaction.setExpense(transaction.getExpense() + Double.parseDouble(fragments3[2].replace(',', '.')));
        });
        return transactions;
    }
}
