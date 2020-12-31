import com.skillbox.airport.Aircraft;
import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Airport airport = Airport.getInstance();
        System.out.println(findPlanesLeavingInTheNextTwoHours(airport));
    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        //TODO Метод должден вернуть список рейсов вылетающих в ближайшие два часа.
        Date date = new Date();
        Stream <Flight> flightStream = null;
        for (Terminal terminal : airport.getTerminals()) {
            flightStream = terminal.getFlights().stream();
        }
        return flightStream.filter(x -> x.getDate().getHours() > date.getHours() - 2
                && x.getDate().getHours() < date.getHours())
                .collect(Collectors.toList());
    }
}