package clients;

public class IndividualBusinessman extends Client {

    public double withdrawAccount (double sum) {
        if (overDraw == 0) {
            super.withdrawAccount(sum);
            return clientAccount;
        } else {
            clientAccount = super.withdrawAccount(sum) - sum * COMMISSION_GENERAL;
            System.out.println("Комиссия за снятие денег со счета составит 1% от суммы снятия.");
            return clientAccount;
        }
    }

    public double depositAccount (double sum) {
        if (sum < 1000.0) {
            clientAccount = super.depositAccount(sum) - sum * COMMISSION_INDIVIDUAL_BUSINESSMEN_BEFORE_THOUSAND;
            System.out.println("Комиссия за пополнение счета составит 1% от суммы зачисления.");
        }
        if (sum >= 1000.0) {
            clientAccount = super.depositAccount(sum) - sum * COMMISSION_INDIVIDUAL_BUSINESSMEN_AFTER_THOUSAND;
            System.out.println("Комиссия за пополнение счета составит 0,5% от суммы зачисления.");
        }
        return clientAccount;
    }
}
