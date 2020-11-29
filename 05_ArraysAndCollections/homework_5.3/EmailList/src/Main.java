import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {

    private static TreeSet<String> emailList = new TreeSet<>() {{
        add("masha2000@gmail.com");
        add("dima-ivanov@yandex.ru");
        add("kirill_devyatkin@mail.ru");
        add("infoGRAD@1grad.su");
    }};
    private static String emailOne;
    private static int i;
    private static ArrayList<Domain> domainArrayList;

    public static void main(String[] args) {

        while (emailList.size() >= 0) {

            String[] emailListArray;
            domainArrayList = new ArrayList<>();

            for (String emailPart : emailList) {
                emailListArray = emailPart.split("@|\\.");
                domainArrayList.add(new Domain(emailListArray[0], emailListArray[1], emailListArray[2]));
            }

            Scanner in = new Scanner(System.in);
            System.out.println();
            System.out.print("LIST_NAME - вывод списка email адресов упорядоченных по имени.\n" +
                    "LIST_SLD - вывод email адресов упорядоченных по домену второго уровня.\n" +
                    "LIST_TLD - вывод email адресов упорядоченных по домену первого уровня.\n" +
                    "ADD xxx@xxx.xxx - ввод email адреса.\n" +
                    "Введите команду - ");
            String command = in.nextLine();
            System.out.println();
            String[] commandArray = command.split("\\s+");

            if (commandArray.length > 1 && commandArray.length < 3) {
                emailOne = commandArray[1];
                controlUnit(commandArray);
            } else {
                if (commandArray.length > 2) {
                System.out.println("E-mail введен неверно!");
                } else {
                    controlUnit(commandArray);
                }
            }
        }
    }

    private static void controlUnit (String[] commandArray) {

        if (commandArray[0].equals("LIST_NAME")) {
            DomainNameComparator domainNameComparator = new DomainNameComparator();
            domainArrayList.sort(domainNameComparator);
            for (i = 0; i < domainArrayList.size(); i++) {
                System.out.println(domainArrayList.get(i).getName() + "@" + domainArrayList.get(i).getSld() + "." + domainArrayList.get(i).getTld());
            }
        }
        if (commandArray[0].equals("LIST_SLD")) {
            DomainSldComparator domainSldComparator = new DomainSldComparator();
            domainArrayList.sort(domainSldComparator);
            for (i = 0; i < domainArrayList.size(); i++) {
                System.out.println(domainArrayList.get(i).getName() + "@" + domainArrayList.get(i).getSld() + "." + domainArrayList.get(i).getTld());
            }
        }
        if (commandArray[0].equals("LIST_TLD")) {
            DomainTldComparator domainTldComparator = new DomainTldComparator();
            domainArrayList.sort(domainTldComparator);
            for (i = 0; i < domainArrayList.size(); i++) {
                System.out.println(domainArrayList.get(i).getName() + "@" + domainArrayList.get(i).getSld() + "." + domainArrayList.get(i).getTld());
            }
        }
        if (commandArray[0].equals("ADD")) {
            if (emailOne.matches("[a-zA-Z0-9(_?,-?)]{3,}+(@)[a-z0-9]{3,}+(\\.)(ru)?(com)?(net)?")) {
                emailList.add(emailOne);
            } else {
                System.out.println("Неверный формат E-mail!");
            }
        }
    }
}
