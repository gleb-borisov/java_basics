import accounts.BankAccount;
import accounts.CardAccount;
import accounts.DepositAccount;

import java.util.Scanner;

public class SessionWithAccount {

    public SessionWithAccount() {
    }

    private double sum;
    private String command;
    private String choice;
    private String commandTransfer;
    Scanner inCommand = new Scanner(System.in);
    Scanner inSum = new Scanner(System.in);
    Scanner inChoice = new Scanner(System.in);
    Scanner inCommandTransfer = new Scanner(System.in);
    BankAccount account = new BankAccount();
    DepositAccount depositAccount = new DepositAccount();
    CardAccount cardAccount = new CardAccount();

    public void choiceAccount () {
        System.out.println("Выберите тип счета:\n" +
                "Обычный счёт (введите 1)\n" +
                "Депозитный счёт (введите 2)\n" +
                "Карточный счёт (введите 3)\n" +
                "Конец работы (введите 0)");
        choice = inChoice.nextLine();
    }

    public String getChoice() {
        return choice;
    }

    public void commandDeposit (){
        System.out.print("Желаете внести деньги на Ваш счет (ДА/НЕТ) - ");
        command = inCommand.nextLine();
        if (command.equals("ДА")) {
            System.out.print("Внесите сумму - ");
            sum = inSum.nextDouble();
            if (choice.equals("1")) {
                account.depositAmount(sum, choice);
            }
            if (choice.equals("2")) {
                depositAccount.depositAmount(sum, choice);
            }
            if (choice.equals("3")) {
                cardAccount.depositAmount(sum, choice);
            }
        }
    }

    public void commandWithdraw () {
        System.out.print("Желаете снять деньги с Вашего счета (ДА/НЕТ) - ");
        command = inCommand.nextLine();
        if (command.equals("ДА")) {
            System.out.print("Снимите сумму - ");
            sum = inSum.nextDouble();
            withdraw();
        }
    }

    public void withdraw () {
        if (choice.equals("1")) {
            while (true) {
                if (sum > account.getSumTotal()) {
                    System.out.print("На Вашем счету недостаточно средств!\nВведите другую сумму - ");
                    sum = inSum.nextDouble();
                } else {
                    break;
                }
            }
            account.withdrawAmount(sum, choice);
        }
        if (choice.equals("2")) {
            while (true) {
                if (sum > depositAccount.getSumTotalDeposit()) {
                    System.out.print("На Вашем счету недостаточно средств!\nВведите другую сумму - ");
                    sum = inSum.nextDouble();
                } else {
                    break;
                }
            }
            depositAccount.withdrawAmount(sum, choice);
        }
        if (choice.equals("3")) {
            while (true) {
                if (sum > cardAccount.getSumTotalCard()) {
                    System.out.print("На Вашем счету недостаточно средств!\nВведите другую сумму - ");
                    sum = inSum.nextDouble();
                } else {
                    break;
                }
            }
            cardAccount.withdrawAmount(sum, choice);
        }
    }

    public void commandList () {
        System.out.print("Желаете узнать остаток на Вашем счете (ДА/НЕТ) - ");
        command = inCommand.nextLine();
        if (command.equals("ДА")) {
            if (choice.equals("1")) {
                account.balanceAccount();
            }
            if (choice.equals("2")) {
                depositAccount.balanceAccount();
            }
            if (choice.equals("3")) {
                cardAccount.balanceAccount();
            }
        }
    }

    public boolean commandEnd () {
        System.out.print("Желаете выйти из счета (ДА/НЕТ) - ");
        command = inCommand.nextLine();
        if (command.equals("ДА")) {
            return true;
        } else {
            return false;
        }
    }

    public void commandTransfer () {
        System.out.print("Желаете перевести деньги со счета (ДА/НЕТ) - ");
        command = inCommand.nextLine();
        if (command.equals("ДА")) {
            while (true) {
                System.out.println("На обычный счёт (введите 1)\n" +
                        "На депозитный счет (введите 2)\n" +
                        "На карточный счет (введите 3)");
                commandTransfer = inCommandTransfer.nextLine();
                if (commandTransfer.equals("1") || commandTransfer.equals("2") || commandTransfer.equals("3")) {
                    break;
                }
            }
            System.out.print("Введите сумму - ");
            sum = inSum.nextDouble();
            withdraw();
            if (depositAccount.getTimeLimit()) {
                return;
            }
            if (commandTransfer.equals("1")) {
                account.depositAmount(commandTransfer, sum);
            }
            if (commandTransfer.equals("2")) {
                depositAccount.depositAmount(sum);
            }
            if (commandTransfer.equals("3")) {
                cardAccount.depositAmount(sum);
            }
        }
    }
}
