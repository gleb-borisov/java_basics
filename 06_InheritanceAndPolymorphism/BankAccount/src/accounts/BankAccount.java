package accounts;

public class BankAccount {

    private double sumTotal;

    public BankAccount () {
        this.sumTotal = 100000.00;
    }

    public double getSumTotal() {
        return sumTotal;
    }

    public void depositAmount (double sum) {
        sumTotal = sumTotal + sum;
        System.out.println("Вы внесли - " + sum + " руб.");
        System.out.println("На Вашем обычном счете - " + sumTotal + " руб.");
    }

    public void withdrawAmount (double sum) {
        sumTotal = sumTotal - sum;
        System.out.println("Вы сняли - " + sum + " руб.");
        System.out.println("На Вашем обычном счете - " + sumTotal + " руб.");
    }

    public void balanceAccount () {
        System.out.println("Остаток на Вашем обычном счете сотавляет - " + sumTotal + " руб.");
    }
}
