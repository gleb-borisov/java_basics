public class Main {

    public static void main(String[] args) {
        String safe = searchAndReplaceDiamonds("Номер кредитной карты <4008> 1234 <5678> 8912", "***");
        System.out.println(safe);
    }

    public static String searchAndReplaceDiamonds(String text, String placeholder) {
        // TODO: реализовать метод, если в строке нет <> - вернуть строку без изменений
        if (text.indexOf("<") == -1 || text.lastIndexOf(">") == -1) {
            return text;
        }
        for (int i = 0; i < text.length(); i++) {
            if (text.indexOf("<") == -1 || text.indexOf(">") == -1) {
                break;
            }
            int bracketFirst = text.indexOf("<", i);
            int bracketSecond = text.indexOf(">", i) + 1;
            i = bracketSecond;
            String textReplace = text.substring(bracketFirst, bracketSecond);
            text = text.replaceAll(textReplace, placeholder);
        }
        return text;
    }
}