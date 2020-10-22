import com.skillbox.airport.*; // Подключил бибилиотеку

public class test {
    public static void main(String[] args) {

        Airport airport = Airport.getInstance(); // Создал обьект аэропорта
        System.out.println("Список самолётов в аэропорту:" + System.lineSeparator() + airport.getAllAircrafts()); // Напечатал список самолетов в аэропорту
        System.out.println("Кол-во самолетов в аэропорту = " + airport.getAllAircrafts().size()); // Напечатал кол-во самолётов в аэропорту

    }
}
