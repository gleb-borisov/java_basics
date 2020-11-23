import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private  static ArrayList<String> toDo = new ArrayList<>(){{
        add("Сделать зарядку");
        add("Приготовить завтрак");
        add("Выбросить мусор");
        add("Выгулять собаку");
    }};

    private static String string;
    private static int listNumber;

    public static void main(String[] args) {

        while (toDo.size() != 0) {

            Scanner in = new Scanner(System.in);
            String command = in.nextLine();
            String[] commandArray = command.split("\\s+");
            listNumber = 0;

            stringPrepare(commandArray);
            controlUnit(commandArray);
        }
    }

    private static void stringPrepare (String[] commandArray) {
        StringBuilder stringBuilder = new StringBuilder();
        if (commandArray.length > 2) {
            if (commandArray[1].matches("[0-9]")) {
                for (int j = 2; j < commandArray.length; j++) {
                    stringBuilder.append(" " + commandArray[j]);
                }
                listNumber = Integer.parseInt(commandArray[1]) - 1;
                string = stringBuilder.toString().trim();
            } else {
                for (int j = 1; j < commandArray.length; j++) {
                    stringBuilder.append(" " + commandArray[j]);
                }
                string = stringBuilder.toString().trim();
            }
        }
    }

    private static void controlUnit (String[] commandArray) {
        if (commandArray[0].equals("LIST")) {
            System.out.println("Список дел:");
            for (int i = 0; i < toDo.size(); i++) {
                System.out.println((i + 1) + " - " + toDo.get(i));
            }
        }
        if (commandArray[0].equals("DELETE")) {
            int deleteIndex = Integer.parseInt(commandArray[1]);
            toDo.remove(deleteIndex - 1);
        }
        if (commandArray[0].equals("EDIT")) {
            toDo.set(listNumber, string);
        }
        if (commandArray[0].equals("ADD")) {
            if (listNumber == 0) {
                toDo.add(string);
            } else {
                toDo.add(listNumber, string);
            }
        }
    }
}
