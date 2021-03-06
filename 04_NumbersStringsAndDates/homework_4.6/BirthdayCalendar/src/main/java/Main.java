import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        int day = 27;
        int month = 8;
        int year = 1970;

        System.out.println(collectBirthdays(year, month, day));
    }

    public static String collectBirthdays(int year, int month, int day) {

        LocalDate birthday = LocalDate.of(year, month, day);
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy E", Locale.ENGLISH);
        StringBuilder birthdayStringBuilder = new StringBuilder();
        int i = 0;

        while (today.isAfter(birthday)) {
            birthdayStringBuilder.append(i + " - " + birthday.format(formatter) + "\n");
            birthday = birthday.plusYears(1);
            i++;
        }
        String birthdayString = birthdayStringBuilder.toString();
        return birthdayString;
    }
}
