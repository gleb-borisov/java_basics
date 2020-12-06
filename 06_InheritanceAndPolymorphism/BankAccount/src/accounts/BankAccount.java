package accounts;

public class BankAccount {

    private double sumTotal = 100000;
    private final double COMMISSION_ORDINARY = 1;
    private final double COMMISSION_DEPOSIT = 1;
    private final double COMMISSION_CARD = 1.01;

    public double getSumTotal() {
        return sumTotal;
    }

    public double getCOMMISSION_ORDINARY() {
        return COMMISSION_ORDINARY;
    }

    public double getCOMMISSION_DEPOSIT() {
        return COMMISSION_DEPOSIT;
    }

    public double getCOMMISSION_CARD() {
        return COMMISSION_CARD;
    }

    public void setSumTotal(double sumTotal) {
        this.sumTotal = sumTotal;
    }

    public double depositAmount (double sum, String choice) {
        sumTotal = sumTotal + sum;
        if (choice.equals("1")) {
            System.out.println("Вы внесли - " + sum + " руб.");
            System.out.println("На Вашем обычном счете - " + sumTotal + " руб.");
        }
        return sumTotal;
    }

    public void depositAmount (String commandTransfer, double sum) {
        sumTotal = sumTotal + sum;
        System.out.println("Вы внесли - " + sum + " руб.");
        System.out.println("На Вашем обычном счете - " + sumTotal + " руб.");
    }

    public double depositAmount (double sum) {
        sumTotal = sumTotal + sum;
        return sumTotal;
    }

    public double withdrawAmount (double sum, double COMMISSION, String choice) {
        sumTotal = sumTotal - sum * COMMISSION;
        if (choice.equals("1")) {
            System.out.println("Вы сняли - " + sum + " руб.");
            System.out.println("На Вашем обычном счете - " + sumTotal + " руб.");
        }
        return sumTotal;
    }

    public void balanceAccount () {
        System.out.println("Остаток на Вашем обычном счете сотавляет - " + sumTotal + " руб.");
    }
}
