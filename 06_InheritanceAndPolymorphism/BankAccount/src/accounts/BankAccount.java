package accounts;

public class BankAccount {

    private double sumTotal = 100000;
    protected final double COMMISSION_ORDINARY = 1;
    protected final double COMMISSION_DEPOSIT = 1;
    protected final double COMMISSION_CARD = 1.01;

    public double getSumTotal() {
        return sumTotal;
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

    public double withdrawAmount (double sum, String choice) {
        sumTotal = sumTotal - sum * COMMISSION_ORDINARY;
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
