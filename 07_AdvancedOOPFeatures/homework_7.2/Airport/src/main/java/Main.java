import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Airport airport = Airport.getInstance();
        System.out.println(findPlanesLeavingInTheNextTwoHours(airport));
    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        //TODO Метод должден вернуть список рейсов вылетающих в ближайшие два часа.
        Date date = new Date();
        return airport.getTerminals().stream()
                .map(flightStream -> flightStream.getFlights())
                .flatMap(flightStream -> flightStream.stream())
                .filter(x -> x.getDate().getHours() > date.getHours() - 2
                && x.getDate().getHours() < date.getHours())
                .collect(Collectors.toList());
    }
}