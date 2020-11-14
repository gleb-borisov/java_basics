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

    public static String collectBirthdays(int year, int month, int day) {
        month = --month;
        Calendar calendar = new GregorianCalendar(year,month,day);
        Date date = calendar.getTime();
        Date dateToday = new Date();
        SimpleDateFormat formater = new SimpleDateFormat("dd.MM.yyyy - E", Locale.ENGLISH);
        String birthCalendar = "";

        for (int i = 0; date.before(dateToday); i++ ) {
            birthCalendar = birthCalendar + "\n" + i + " - " + formater.format(date);
            calendar.add(Calendar.YEAR, 1);
            date = calendar.getTime();
        }
        return birthCalendar;
    }
}
