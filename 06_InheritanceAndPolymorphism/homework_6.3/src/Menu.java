import Clients.IndividualBusinessman;
import Clients.LegalPerson;
import Clients.PhysicalPerson;

import java.util.HashMap;
import java.util.Scanner;

public class Menu {

    private String choice;
    private String command;
    private int numberAccount;
    private Double sum;
    HashMap<Integer, PhysicalPerson> listOfPhysicalPersonAccount = new HashMap<>();
    HashMap <Integer, LegalPerson> listOfLegalPersonAccount = new HashMap<>();
    HashMap <Integer, IndividualBusinessman> listOfIndividualBusinessmanAccount = new HashMap<>();

    Scanner inChoice = new Scanner(System.in);
    Scanner inCommand = new Scanner(System.in);
    Scanner inName = new Scanner(System.in);
    Scanner inSum = new Scanner(System.in);
    Scanner inNumberAccount = new Scanner(System.in);

    public String getChoice() {
        return choice;
    }

    public String getCommand() {
        return command;
    }

    public void mainMenu(){
        System.out.println("\nВыберите действия:\n" +
                "Создать новый счет (введите 1)\n" +
                "Занести деньги на счет (введите 2)\n" +
                "Снять деньги со счета (введите 3)\n" +
                "Вывести список счетов (введите 4)\n" +
                "Выйти из программы (введите ДА)\n");
        command = inCommand.nextLine();
    }

    public void choiceAccount(){
        System.out.println("\nВыбрать тип счета:\n" +
                "Физическое лицо (введите 1)\n" +
                "Юридическое лицо (введите 2)\n" +
                "Индивидуальный предприниматель (введите 3)\n" +
                "Выйти из меню выбора счета (введите 0)");
        choice = inChoice.nextLine();
    }

    public void newAccountCreation() {
        if(choice.equals("1")) {
            System.out.println("\nВы выбрали создание счета физического лица.");
            PhysicalPerson physicalPerson = new PhysicalPerson();
            System.out.print("Введите имя клиента - ");
            physicalPerson.setClientName(inName.nextLine());
            System.out.print("Введите сумму на счету клиента - ");
            physicalPerson.setClientAccount(inSum.nextDouble());
            listOfPhysicalPersonAccount.put(listOfPhysicalPersonAccount.size() + 1, physicalPerson);
            System.out.println("Счет на имя " + physicalPerson.getClientName() + " создан.\n");
        }
        if(choice.equals("2")) {
            System.out.println("\nВы выбрали создание счета юридического лица.");
            LegalPerson legalPerson = new LegalPerson();
            System.out.print("Введите название юридического лица - ");
            legalPerson.setClientName(inName.nextLine());
            System.out.print("Введите сумму на счету юридического лица - ");
            legalPerson.setClientAccount(inSum.nextDouble());
            listOfLegalPersonAccount.put(listOfLegalPersonAccount.size() + 1, legalPerson);
            System.out.println("Счет на имя " + legalPerson.getClientName() + " создан.\n");
        }
        if(choice.equals("3")) {
            System.out.println("\nВы выбрали создание счета индивидуального предпринимателя.");
            IndividualBusinessman individualBusinessman = new IndividualBusinessman();
            System.out.print("Введите название индивидуального предпринимателя - ");
            individualBusinessman.setClientName(inName.nextLine());
            System.out.print("Введите сумму на счету индивидуального предпринимателя - ");
            individualBusinessman.setClientAccount(inSum.nextDouble());
            listOfIndividualBusinessmanAccount.put(listOfIndividualBusinessmanAccount.size() + 1, individualBusinessman);
            System.out.println("Счет на имя " + individualBusinessman.getClientName() + " создан.\n");
        }
        System.out.println("Выйти из меню создания счета (введите 0)");
        command = inCommand.nextLine();
    }

    public void depositAccount () {
        if (choice.equals("1")) {
            System.out.println("\nВы выбрали занесение денег на счет физического лица.");
            System.out.print("Введите номер счета клиента - ");
            numberAccount = inNumberAccount.nextInt();
            PhysicalPerson person = listOfPhysicalPersonAccount.get(numberAccount);
            System.out.println("Клиент - " + person.getClientName() + "\n" +
                    "Номер счета - " + numberAccount + "\n" +
                    "Сумма на счету - " + person.getClientAccount());
            System.out.print("Введите зачисляемую сумму - ");
            sum = inSum.nextDouble();
            person.depositAccount(sum);
            System.out.println("На счету клиента " + person.getClientName() + " - " + person.getClientAccount() + " руб.");
        }
        if (choice.equals("2")) {
            System.out.println("\nВы выбрали занесение денег на счет юридического лица.");
            System.out.print("Введите номер счета клиента - ");
            numberAccount = inNumberAccount.nextInt();
            LegalPerson person = listOfLegalPersonAccount.get(numberAccount);
            System.out.println("Клиент - " + person.getClientName() + "\n" +
                    "Номер счета - " + numberAccount + "\n" +
                    "Сумма на счету - " + person.getClientAccount());
            System.out.print("Введите зачисляемую сумму - ");
            sum = inSum.nextDouble();
            person.depositAccount(sum);
            System.out.println("На счету клиента " + person.getClientName() + " - " + person.getClientAccount() + " руб.");
        }
        if (choice.equals("3")) {
            System.out.println("\nВы выбрали занесение денег на счет индивидуального предпринимателя.");
            System.out.print("Введите номер счета клиента - ");
            numberAccount = inNumberAccount.nextInt();
            IndividualBusinessman person = listOfIndividualBusinessmanAccount.get(numberAccount);
            System.out.println("Клиент - " + person.getClientName() + "\n" +
                    "Номер счета - " + numberAccount + "\n" +
                    "Сумма на счету - " + person.getClientAccount());
            System.out.print("Введите зачисляемую сумму - ");
            sum = inSum.nextDouble();
            person.depositAccount(sum);
            System.out.println("На счету клиента " + person.getClientName() + " - " + person.getClientAccount() + " руб.");
        }
        System.out.println("Выйти из меню занесения денег на счет клиента (введите 0)");
        command = inCommand.nextLine();
    }

    public void withdrawAccount () {
        if (choice.equals("1")) {
            System.out.println("\nВы выбрали снятие денег со счета физического лица.");
            System.out.print("Введите номер счета клиента - ");
            numberAccount = inNumberAccount.nextInt();
            PhysicalPerson person = listOfPhysicalPersonAccount.get(numberAccount);
            System.out.println("Клиент - " + person.getClientName() + "\n" +
                    "Номер счета - " + numberAccount + "\n" +
                    "Сумма на счету - " + person.getClientAccount());
            System.out.print("Введите снимаемую сумму - ");
            sum = inSum.nextDouble();
            person.withdrawAccount(sum);
            System.out.println("На счету клиента " + person.getClientName() + " - " + person.getClientAccount() + " руб.");
        }
        if (choice.equals("2")) {
            System.out.println("\nВы выбрали снятие денег со счета юридического лица.");
            System.out.print("Введите номер счета клиента - ");
            numberAccount = inNumberAccount.nextInt();
            LegalPerson person = listOfLegalPersonAccount.get(numberAccount);
            System.out.println("Клиент - " + person.getClientName() + "\n" +
                    "Номер счета - " + numberAccount + "\n" +
                    "Сумма на счету - " + person.getClientAccount());
            System.out.print("Введите снимаемую сумму - ");
            sum = inSum.nextDouble();
            person.withdrawAccount(sum);
            System.out.println("На счету клиента " + person.getClientName() + " - " + person.getClientAccount() + " руб.");
        }
        if (choice.equals("3")) {
            System.out.println("\nВы выбрали снятие денег со счета индивидуального предпринимателя.");
            System.out.print("Введите номер счета клиента - ");
            numberAccount = inNumberAccount.nextInt();
            IndividualBusinessman person = listOfIndividualBusinessmanAccount.get(numberAccount);
            System.out.println("Клиент - " + person.getClientName() + "\n" +
                    "Номер счета - " + numberAccount + "\n" +
                    "Сумма на счету - " + person.getClientAccount());
            System.out.print("Введите снимаемую сумму - ");
            sum = inSum.nextDouble();
            person.withdrawAccount(sum);
            System.out.println("На счету клиента " + person.getClientName() + " - " + person.getClientAccount() + " руб.");
        }
        System.out.println("Выйти из меню занесения денег на счет клиента (введите 0)");
        command = inCommand.nextLine();
    }

    public void printListAccounts () {
        System.out.println("\nСписок счетов:");
        System.out.println("\tСписок счетов физических лиц:");
        System.out.println("\tНомер счета - Имя клиента - Сумма");
        if (listOfPhysicalPersonAccount.isEmpty()) {
            System.out.println("\tСчета физических лиц отсутствуют.");
        }
        for (Integer key : listOfPhysicalPersonAccount.keySet()) {
            PhysicalPerson person = listOfPhysicalPersonAccount.get(key);
            System.out.println("\t\t" + key + " - " + person.getClientName() + " - " + person.getClientAccount() + " руб.");
        }
        System.out.println("\tСписок счетов юридических лиц:");
        System.out.println("\tНомер счета - Имя клиента - Сумма");
        if (listOfLegalPersonAccount.isEmpty()) {
            System.out.println("\tСчета юридических лиц отсутствуют.");
        }
        for (Integer key : listOfLegalPersonAccount.keySet()) {
            LegalPerson person = listOfLegalPersonAccount.get(key);
            System.out.println("\t\t" + key + " - " + person.getClientName() + " - " + person.getClientAccount() + " руб.");
        }
        System.out.println("\tСписок счетов индивидуальных предпринимателей:");
        System.out.println("\tНомер счета - Имя клиента - Сумма");
        if (listOfIndividualBusinessmanAccount.isEmpty()) {
            System.out.println("\tСчета индивидуальных предпринимателей отсутствуют.");
        }
        for (Integer key : listOfIndividualBusinessmanAccount.keySet()) {
            IndividualBusinessman person = listOfIndividualBusinessmanAccount.get(key);
            System.out.println("\t\t" + key + " - " + person.getClientName() + " - " + person.getClientAccount() + " руб.");
        }
    }
}
