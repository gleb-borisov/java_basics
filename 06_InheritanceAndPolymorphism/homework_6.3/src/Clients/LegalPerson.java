package Clients;

public class LegalPerson extends Client {

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
}