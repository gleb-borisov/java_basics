package accounts;

public class CardAccount extends BankAccount{

    private double sumTotalCard;

    public double getSumTotalCard() {
        return sumTotalCard;
    }

    public double depositAmount (double sum, String choice) {
        super.setSumTotal(sumTotalCard);
        sumTotalCard = super.depositAmount(sum, choice);
        System.out.println("Вы внесли - " + sum + " руб.");
        System.out.println("На Вашем карточном счете - " + sumTotalCard + " руб.");
        return sumTotalCard;
    }

    public double depositAmount (double sum) {
        super.setSumTotal(sumTotalCard);
        sumTotalCard = super.depositAmount(sum);
        System.out.println("Вы внесли - " + sum + " руб.");
        System.out.println("На Вашем карточном счете - " + sumTotalCard + " руб.");
        return sumTotalCard;
    }

    public double withdrawAmount (double sum, double COMMISSION, String choice) {
        super.setSumTotal(sumTotalCard);
        sumTotalCard = super.withdrawAmount(sum, COMMISSION, choice);
        System.out.println("Вы сняли - " + sum + " руб.");
        System.out.println("Процент за снятие - 1%.");
        System.out.println("На Вашем карточном счете - " + sumTotalCard + " руб.");
        return sumTotalCard;
    }

    public void balanceAccount () {
        System.out.println("Остаток на Вашем карточном счете сотавляет - " + sumTotalCard + " руб.");
    }
}
