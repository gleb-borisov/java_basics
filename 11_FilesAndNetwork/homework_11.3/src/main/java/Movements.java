import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

public class Movements {

    private static String pathMovementsCsv;
    private static List<String> lines;
    private static HashMap<String, Double> income = new HashMap<>();
    private static HashMap<String, Double> expense;
    private static Double sum;

    public Movements(String pathMovementsCsv) {
        this.pathMovementsCsv = pathMovementsCsv;
    }

    public static void makeMovementList () throws IOException {
        incomeList();
        System.out.println("\nСуммы доходов по организациям:\n");
        income.forEach((a,b)-> System.out.println(a + " - " + b));
        expenseList();
        System.out.println("\nСуммы расходов по организациям:\n");
        expense.forEach((a,b)-> System.out.println(a + " - " + b));
    }

    private static void companyLists () throws IOException {
        lines = Files.readAllLines(Paths.get(pathMovementsCsv));
        lines.remove(0);
        lines.forEach(e -> {String[] fragments = e.split("\\s{4}");
            income.put(fragments[1], 0.0);});
        expense = (HashMap<String, Double>) income.clone();
    }

    private static void incomeList () throws IOException {
        companyLists();
        lines.forEach(e -> {
            String[] fragments1 = e.split("\\s{2,}");
            String[] fragments2 = e.split("\\s{4}");
            String[] fragments3 = fragments1[fragments1.length - 1].split(",");
            if (fragments3.length > 3) {
                fragments3 = fragments1[fragments1.length - 1].split("\"");
                if (fragments3.length > 2) {
                    income.put(fragments2[1], income.get(fragments2[1])
                            + Double.parseDouble(fragments3[1].replace(',', '.')));
                }
            } else {
                income.put(fragments2[1], income.get(fragments2[1]) + Double.parseDouble(fragments3[1]));
            }
        });
    }

    private static void expenseList () throws IOException {
        companyLists();
        lines.forEach(e -> {
            String[] fragments1 = e.split("\\s{2,}");
            String[] fragments2 = e.split("\\s{4}");
            String[] fragments3 = fragments1[fragments1.length - 1].split(",");
            if (fragments3.length > 3) {
                fragments3 = fragments1[fragments1.length - 1].split("\"");
                expense.put(fragments2[1], expense.get(fragments2[1])
                        + Double.parseDouble(fragments3[1].replace(',', '.')));
            } else {
                expense.put(fragments2[1], expense.get(fragments2[1]) + Double.parseDouble(fragments3[2]));
            }
        });
    }

    public double getExpenseSum() throws IOException {
        expenseList();
        sum = 0.0;
        expense.forEach((a, b)-> sum += b);
        return sum;
    }

    public double getIncomeSum() throws IOException {
        incomeList();
        sum = 0.0;
        income.forEach((a, b)-> sum += b);
        return sum;
    }
}
