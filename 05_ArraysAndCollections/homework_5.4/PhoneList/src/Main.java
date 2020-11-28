import java.util.*;

public class Main {

    private static Long phoneNumber;

    public static void main(String[] args) {

        HashMap<Long, String> phoneList = new HashMap<>() {{
                put(79502464585l, "Маша");
                put(89425684597l, "Коля");
                put(79375263879l, "Света");
                put(89354753815l, "Женя");
                put(79422548624l, "Коля");
                put(79305329947l, "Света");
                put(89428465829l, "Коля");
        }};

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.print("Введите имя и номер абонента - ");
            String text = scanner.nextLine();
            String name = text.replaceAll("\\+?\\s?\\(?\\)?\\s?\\-?\\d+", "");
            name = name.trim();
            numberCheck(text);

            if (phoneNumber == -1) {
                continue;
            }

            if (text.equals("LIST")) {
                printList(phoneList);
                continue;
            }

            if (phoneList.containsKey(phoneNumber)) {
                System.out.println(phoneList.get(phoneNumber) + " - " + phoneNumber);
                continue;
            }

            if (phoneList.containsValue(name)) {
                for (Long key : phoneList.keySet()) {
                    if (phoneList.get(key).equals(name)) {
                        System.out.println(phoneList.get(key) + " - " + key);
                    }
                }
                continue;
            }

            if (phoneNumber == 0) {
                 System.out.print("Неизвестный абонент.\nВведите номер телефона - ");
                 numberCheck(scanner.nextLine());
                 phoneList.put(phoneNumber, name);
                 continue;
            }

            if (phoneList.containsKey(phoneNumber) == false && name == "") {
                 System.out.println("Неизвестный номер телефона.\nВведите имя абонента - ");
                 name = scanner.nextLine();
                 phoneList.put(phoneNumber, name);
                 continue;
            }
            phoneList.put(phoneNumber, name);
        }
    }

    private static void printList (HashMap <Long, String> map) {
        TreeSet<String> phoneListString = new TreeSet<>();
        for (Long key : map.keySet()) {
            phoneListString.add(map.get(key) + " - " + key);
        }
        for (String x : phoneListString) {
            System.out.println(x);
        }
    }

    private static Long numberCheck (String text) {
        String[] wordDigit = text.split("\\D+");
        StringBuilder phoneNumberString = new StringBuilder();
        phoneNumber = 0l;

        if (wordDigit.length == 0) {
            return phoneNumber = 0l;
        }
        for (String wordOne : wordDigit) {
            phoneNumberString.append(wordOne);
        }
        if (phoneNumberString.length() != 11 || (phoneNumberString.charAt(0) != '7' && phoneNumberString.charAt(0) != '8')) {
            System.out.println("Не правильный формат телефонного номера!");
            return phoneNumber = -1l;
        }
        return phoneNumber = Long.parseLong(phoneNumberString.toString());
    }
}
