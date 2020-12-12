import clients.Client;
import clients.IndividualBusinessman;
import clients.LegalPerson;
import clients.PhysicalPerson;

import java.util.HashMap;
import java.util.Scanner;

public class Menu {

    private String choice;
    private String command;
    private int numberAccount;
    private Double sum;
    private HashMap<Integer, PhysicalPerson> listOfPhysicalPersonAccount = new HashMap<>();
    private HashMap <Integer, LegalPerson> listOfLegalPersonAccount = new HashMap<>();
    private HashMap <Integer, IndividualBusinessman> listOfIndividualBusinessmanAccount = new HashMap<>();
    private Client person;
    private HashMap[] listsArray = new HashMap[] {listOfPhysicalPersonAccount,
            listOfLegalPersonAccount, listOfIndividualBusinessmanAccount};
    private String[] listsNames = new String[] {"физических лиц", "юридических лиц", "индивидуальных предпринимателей"};

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

    public Client createNewPersonAccount (String choice) {
        if (choice.equals("1")) {
            person = new PhysicalPerson();
        }
        if (choice.equals("2")) {
            person = new LegalPerson();
        }
        if (choice.equals("3")) {
            person = new IndividualBusinessman();
        }
        return person;
    }

    public void newAccountCreation() {
        System.out.println("\nВы выбрали создание счета для " + listsNames[Integer.parseInt(choice) - 1] + ".");
        System.out.print("Введите имя клиента - ");
        person.setClientName(inName.nextLine());
        System.out.print("Введите сумму на счету клиента - ");
        person.setClientAccount(inSum.nextDouble());
        listsArray[Integer.parseInt(choice) - 1].put(listsArray[Integer.parseInt(choice) - 1].size() + 1, person);
        System.out.println("Счет на имя " + person.getClientName() + " создан.\n");
        System.out.println("Выйти из меню создания счета для " + listsNames[Integer.parseInt(choice) - 1] + " (введите 0)");
        command = inCommand.nextLine();
    }

    public void depositAccount () {
        System.out.println("\nВы выбрали занесение денег на счета " + listsNames[Integer.parseInt(choice) - 1] + ".");
        System.out.print("Введите номер счета клиента - ");
        numberAccount = inNumberAccount.nextInt();
        person = (Client) listsArray[Integer.parseInt(choice) - 1].get(numberAccount);
        System.out.println("Клиент - " + person.getClientName() + "\n" +
                "Номер счета - " + numberAccount + "\n" +
                "Сумма на счету - " + person.getClientAccount());
        System.out.print("Введите зачисляемую сумму - ");
        sum = inSum.nextDouble();
        person.depositAccount(sum);
        System.out.println("На счету клиента " + person.getClientName() + " - " + person.getClientAccount() + " руб.");
        System.out.println("Выйти из меню занесения денег на счета для " + listsNames[Integer.parseInt(choice) - 1] + " (введите 0)");
        command = inCommand.nextLine();
    }

    public void withdrawAccount () {
        System.out.println("\nВы выбрали снятие денег со счетов " + listsNames[Integer.parseInt(choice) - 1] + ".");
        System.out.print("Введите номер счета клиента - ");
        numberAccount = inNumberAccount.nextInt();
        person = (Client) listsArray[Integer.parseInt(choice) - 1].get(numberAccount);
        System.out.println("Клиент - " + person.getClientName() + "\n" +
                "Номер счета - " + numberAccount + "\n" +
                "Сумма на счету - " + person.getClientAccount());
        System.out.print("Введите снимаемую сумму - ");
        sum = inSum.nextDouble();
        person.withdrawAccount(sum);
        System.out.println("На счету клиента " + person.getClientName() + " - " + person.getClientAccount() + " руб.");
        System.out.println("Выйти из меню снятия денег со счетов " + listsNames[Integer.parseInt(choice) - 1] + " (введите 0)");
        command = inCommand.nextLine();
    }

    public void printListAccounts () {
        System.out.println("\nСписок счетов:");
        for (int i = 0; i < 3; i++) {
            System.out.println("\n\tСписок счетов " + listsNames[i] + " :" + "\n\tНомер счета - Имя клиента - Сумма");
            if (listsArray[i].isEmpty()) {
                System.out.println("\tСчета " + listsNames[i] + " отсутствуют.");
            }
            for (Object key : listsArray[i].keySet()) {
                person = (Client) listsArray[i].get(key);
                System.out.println("\t\t" + key + " - " + person.getClientName() + " - " + person.getClientAccount() + " руб.");
            }
        }
    }
}
