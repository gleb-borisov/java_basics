public class Transaction {

    private String counterparty;
    private Double income = 0.0;
    private Double expense = 0.0;

    public Transaction () {
    }

    public void setCounterparty(String counterparty) {
        this.counterparty = counterparty;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public void setExpense(Double expense) {
        this.expense = expense;
    }

    public String getCounterparty() {
        return counterparty;
    }

    public Double getIncome() {
        return income;
    }

    public Double getExpense() {
        return expense;
    }
}
