public class Main {
    public static void main(String[] args) {

        SessionWithAccount sessionWithAccount = new SessionWithAccount();

        while (true) {
            sessionWithAccount.choiceAccount();
            if (sessionWithAccount.getChoice().equals("1")) {
                System.out.println("Вы выбрали обычный счет.");
                while (true) {
                    sessionWithAccount.commandDeposit();
                    sessionWithAccount.commandWithdraw();
                    sessionWithAccount.commandTransfer();
                    sessionWithAccount.commandList();
                    if (sessionWithAccount.commandEnd()) {
                        break;
                    }
                }
                System.out.println("Конец работы с обычным счётом.");
            }
            if (sessionWithAccount.getChoice().equals("2")) {
                System.out.println("Вы выбрали депозитный счет.");
                while (true) {
                    sessionWithAccount.commandDeposit();
                    sessionWithAccount.commandWithdraw();
                    sessionWithAccount.commandTransfer();
                    sessionWithAccount.commandList();
                    if (sessionWithAccount.commandEnd()) {
                        break;
                    }
                }
                System.out.println("Конец работы с депозитным счетом.");
            }
            if (sessionWithAccount.getChoice().equals("3")) {
                System.out.println("Вы выбрали карточный счет.");
                while (true) {
                    sessionWithAccount.commandDeposit();
                    sessionWithAccount.commandWithdraw();
                    sessionWithAccount.commandTransfer();
                    sessionWithAccount.commandList();
                    if (sessionWithAccount.commandEnd()) {
                        break;
                    }
                }
                System.out.println("Конец работы с карточным счётом.");
            }
            if (sessionWithAccount.getChoice().equals("0")) {
                break;
            }
        }
        System.out.println("Конец работы. Спасибо за использование нашего терминала!");
    }
}