package accounts;

import java.util.ArrayList;
import java.util.Date;

public class DepositAccount extends BankAccount {

    private double sumTotalDeposit;
    private Boolean timeLimit = false;
    private ArrayList<Date> depositDate = new ArrayList<>();
    private ArrayList<Double> depositSum = new ArrayList<>();

    public double getSumTotalDeposit() {
        return sumTotalDeposit;
    }

    public Boolean getTimeLimit() {
        return timeLimit;
    }

    public double depositAmount (double sum, String choice) {
        super.setSumTotal(sumTotalDeposit);
        sumTotalDeposit = super.depositAmount(sum, choice);
        System.out.println("Вы внесли - " + sum + " руб.");
        System.out.println("На Вашем депозитном счете - " + sumTotalDeposit + " руб.");
        depositDate.add(new Date());
        depositSum.add(sum);
        return sumTotalDeposit;
    }

    public double depositAmount (double sum) {
        super.setSumTotal(sumTotalDeposit);
        sumTotalDeposit = super.depositAmount(sum);
        System.out.println("Вы внесли - " + sum + " руб.");
        System.out.println("На Вашем депозитном счете - " + sumTotalDeposit + " руб.");
        depositDate.add(new Date());
        depositSum.add(sum);
        return sumTotalDeposit;
    }

    public double withdrawAmount (double sum, double COMMISSION, String choice) {
        super.setSumTotal(sumTotalDeposit);
        Date today = new Date();
        Double sumCanWithdraw = 0.0;
        for (int i = 0; i < depositDate.size(); i++) {
            if (depositDate.get(i).getDay() + 30 < today.getDay()) {
                sumCanWithdraw = sumCanWithdraw + depositSum.get(i);
            }
        }
        if (sumCanWithdraw < sum && sumCanWithdraw > 0) {
            System.out.println("Сумма доступная для снятия со счёта - " + sumCanWithdraw + " руб.");
            sum = sumCanWithdraw;
        }
        if (sumCanWithdraw <= 0) {
            System.out.println("Вы не можете снять деньги с депозитного счета\n" +
                    "т.к на счету нет суммы внесенной более месяца назад.");
            timeLimit = true;
            return sumTotalDeposit;
        }
        sumTotalDeposit = super.withdrawAmount(sum, COMMISSION, choice);
        System.out.println("Вы сняли - " + sum + " руб.");
        System.out.println("На Вашем депозитном счете - " + sumTotalDeposit + " руб.");
        return sumTotalDeposit;
    }

    public void balanceAccount () {
        System.out.println("Остаток на Вашем депозитном счете сотавляет - " + sumTotalDeposit + " руб.");
    }
}
