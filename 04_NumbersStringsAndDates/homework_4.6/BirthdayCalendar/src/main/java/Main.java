import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        int day = 31;
        int month = 12;
        int year = 1990;

        System.out.println(collectBirthdays(year, month, day));
    }

    public static StringBuilder collectBirthdays(int year, int month, int day) {
        int monthTemp = --month;
        Calendar calendar = new GregorianCalendar(year,monthTemp,day);
        Date date = calendar.getTime();
        Date dateToday = new Date();
        SimpleDateFormat formater = new SimpleDateFormat("dd.MM.yyyy - E", Locale.ENGLISH);
        StringBuilder birthCalendar = new StringBuilder();

        for (int i = 0; date.before(dateToday); i++ ) {
            birthCalendar.append(i + " - " + formater.format(date) + "\n");
            calendar.add(Calendar.YEAR, 1);
            date = calendar.getTime();
        }
        return birthCalendar;
    }
}
