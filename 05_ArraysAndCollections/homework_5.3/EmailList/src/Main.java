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

    public static void main(String[] args) {

        while (emailList.size() >= 0) {

            Scanner in = new Scanner(System.in);
            System.out.print("Введите команду - ");
            String command = in.nextLine();
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
        if (commandArray[0].equals("LIST")) {
            System.out.println("Список E-mail адресов:");
            for (String email : emailList) {
                System.out.println(email);
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
