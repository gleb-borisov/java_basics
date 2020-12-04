package accounts;

public class CardAccount extends BankAccount{

    private double sumTotalCard;

    public double getSumTotalCard() {
        return sumTotalCard;
    }

    public void depositAmount (double sum) {
        sumTotalCard = sumTotalCard + sum;
        System.out.println("Вы внесли - " + sum + " руб.");
        System.out.println("На Вашем карточном счете - " + sumTotalCard + " руб.");
    }

    public void withdrawAmount (double sum) {
        sumTotalCard = sumTotalCard - sum * 1.01;
        System.out.println("Вы сняли - " + sum + " руб.");
        System.out.println("Процент за снятие - 1%.");
        System.out.println("На Вашем карточном счете - " + sumTotalCard + " руб.");
    }

    public void balanceAccount () {
        System.out.println("Остаток на Вашем карточном счете сотавляет - " + sumTotalCard + " руб.");
    }
}
