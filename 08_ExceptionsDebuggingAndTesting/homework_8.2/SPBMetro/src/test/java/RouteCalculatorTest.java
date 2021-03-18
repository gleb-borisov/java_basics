import core.Line;
import core.Station;
import junit.framework.TestCase;
import java.util.*;

public class RouteCalculatorTest extends TestCase {

    List<Station> route;
    RouteCalculator calculator;
    StationIndex stationIndex = new StationIndex();
    Station from;
    Station to;
    ArrayList<Station> connections = new ArrayList<>();
    ArrayList<Station> routeTestWithoutConnection = new ArrayList<>();
    ArrayList<Station> routeTestViaOneConnection = new ArrayList<>();
    ArrayList<Station> routeTestViaTwoConnections = new ArrayList<>();

    @Override
    protected void setUp() throws Exception {

        Line line1 = new Line(1, "Овощная");
        Line line2 = new Line(2, "Фруктовая");
        Line line3 = new Line(3, "Ягодная");

        stationIndex.addLine(line1);
        stationIndex.addLine(line2);
        stationIndex.addLine(line3);

        line1.addStation(new Station("Морковная", line1));
        line1.addStation(new Station("Свекольная", line1)); // Первый переход
        line1.addStation(new Station("Картошечная", line1));
        line2.addStation(new Station("Яблочная", line2));
        line2.addStation(new Station("Персиковая", line2)); // Первый переход
        line2.addStation(new Station("Манговая", line2)); // Второй переход
        line3.addStation(new Station("Арбузная", line3));
        line3.addStation(new Station("Черничная", line3)); // Второй переход
        line3.addStation(new Station("Помидорная", line3));

        stationIndex.addStation(new Station("Морковная", line1));
        stationIndex.addStation(new Station("Свекольная", line1)); // Первый переход
        stationIndex.addStation(new Station("Картошечная", line1));
        stationIndex.addStation(new Station("Яблочная", line2));
        stationIndex.addStation(new Station("Персиковая", line2)); // Первый переход
        stationIndex.addStation(new Station("Манговая", line2)); // Второй переход
        stationIndex.addStation(new Station("Арбузная", line3));
        stationIndex.addStation(new Station("Черничная", line3));
        stationIndex.addStation(new Station("Помидорная", line3)); // Второй переход

        connections.add(stationIndex.getStation("Свекольная"));
        connections.add(stationIndex.getStation("Персиковая"));
        stationIndex.addConnection(connections);
        connections.clear();
        connections.add(stationIndex.getStation("Манговая"));
        connections.add(stationIndex.getStation("Черничная"));
        stationIndex.addConnection(connections);

        routeTestWithoutConnection.add(stationIndex.getStation("Морковная"));
        routeTestWithoutConnection.add(stationIndex.getStation("Свекольная"));
        routeTestWithoutConnection.add(stationIndex.getStation("Картошечная"));

        routeTestViaOneConnection.add(stationIndex.getStation("Морковная"));
        routeTestViaOneConnection.add(stationIndex.getStation("Свекольная"));
        routeTestViaOneConnection.add(stationIndex.getStation("Персиковая"));
        routeTestViaOneConnection.add(stationIndex.getStation("Манговая"));

        routeTestViaTwoConnections.add(stationIndex.getStation("Морковная"));
        routeTestViaTwoConnections.add(stationIndex.getStation("Свекольная"));
        routeTestViaTwoConnections.add(stationIndex.getStation("Персиковая"));
        routeTestViaTwoConnections.add(stationIndex.getStation("Манговая"));
        routeTestViaTwoConnections.add(stationIndex.getStation("Черничная"));
        routeTestViaTwoConnections.add(stationIndex.getStation("Помидорная"));

        calculator = new RouteCalculator(stationIndex);
    }

    public void testCalculateDurationWithoutConnection() {
        from = stationIndex.getStation("Морковная", 1);
        to = stationIndex.getStation("Картошечная", 1);
        route = calculator.getShortestRoute(from, to);
        double actual = calculator.calculateDuration(route);
        double expected = 5;
        assertEquals(expected, actual);
    }

    public void testCalculateDurationViaOneConnection() {
        from = stationIndex.getStation("Морковная");
        to = stationIndex.getStation("Манговая");
        route = calculator.getShortestRoute(from, to);
        double actual = calculator.calculateDuration(route);
        double expected = 8.5;
        assertEquals(expected, actual);
    }

    public void testCalculateDurationViaTwoConnections() {
        from = stationIndex.getStation("Морковная");
        to = stationIndex.getStation("Помидорная");
        route = calculator.getShortestRoute(from, to);
        double actual = calculator.calculateDuration(route);
        double expected = 14.5;
        assertEquals(expected, actual);
    }

    public void testGetShortestRouteWithoutConnection () {
        from = stationIndex.getStation("Морковная");
        to = stationIndex.getStation("Картошечная");
        List<Station> actual = calculator.getShortestRoute(from, to);
        List<Station> expected = routeTestWithoutConnection;
        assertEquals(expected, actual);
    }

    public void testGetShortestRouteViaOneConnection () {
        from = stationIndex.getStation("Морковная");
        to = stationIndex.getStation("Манговая");
        List<Station> actual = calculator.getShortestRoute(from, to);
        List<Station> expected = routeTestViaOneConnection;
        assertEquals(expected, actual);
    }

    public void testGetShortestRouteViaTwoConnections () {
        from = stationIndex.getStation("Морковная");
        to = stationIndex.getStation("Помидорная");
        List<Station> actual = calculator.getShortestRoute(from, to);
        List<Station> expected = routeTestViaTwoConnections;
        assertEquals(expected, actual);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
