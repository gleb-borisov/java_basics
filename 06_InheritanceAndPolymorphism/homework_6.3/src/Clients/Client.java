package Clients;

abstract class Client {

    protected String clientName;
    protected double clientAccount;
    protected final double COMMISSION_GENERAL = 0.01;
    protected final double COMMISSION_INDIVIDUAL_BUSINESSMEN_BEFORE_THOUSAND = 0.01;
    protected final double COMMISSION_INDIVIDUAL_BUSINESSMEN_AFTER_THOUSAND = 0.005;
    protected double overDraw;

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public double getClientAccount() {
        return clientAccount;
    }

    public void setClientAccount(double clientAccount) {
        this.clientAccount = clientAccount;
    }

    public double depositAccount (double sum) {
        clientAccount = clientAccount + sum;
        return clientAccount;
    }

    public double withdrawAccount (double sum) {
        overDraw = 1;
        if (sum > clientAccount) {
            System.out.println("На счету недостаточно средств.");
            return overDraw = 0;
        }
        clientAccount = clientAccount - sum;
        return clientAccount;
    }

}
