import core.Line;
import core.Station;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Тесты класса")
class RouteCalculatorTest{

    List<Station> route;
    List<Station> routeFromOneLine;
    List<Station> routWithOneConnections;
    List<Station> routWithTwoConnections;

    List<Station> connections;
    List<Station> connectionsTwo;

    StationIndex stationIndex;
    RouteCalculator routeCalculator;

    @BeforeEach
    public void setUp(){
        route = new ArrayList<>();
        routeFromOneLine = new ArrayList<>();
        routWithOneConnections = new ArrayList<>();
        routWithTwoConnections = new ArrayList<>();

        connections = new ArrayList<>();
        connectionsTwo = new ArrayList<>();

        stationIndex = new StationIndex();

        Line line1 = new Line(1, "FirstLine");
        Line line2 = new Line(2, "SecondLine");
        Line line3 = new Line(3, "ThirdLine");

        Station station_1L_1S = new Station("Cucumber", line1);
        Station station_1L_2S = new Station("Pineapple", line1);
        Station station_1L_3S = new Station("Peach", line1);

        Station station_2L_1S = new Station("Blueberry", line2);
        Station station_2L_2S = new Station("Mango", line2);
        Station station_2L_3S = new Station("Blackberry", line2);
        Station station_2L_4S = new Station("Watermelon", line2);

        Station station_3L_1S = new Station("Lime", line3);
        Station station_3L_2S = new Station("Apple", line3);
        Station station_3L_3S = new Station("Guava", line3);

        line1.addStation(station_1L_1S);
        line1.addStation(station_1L_2S);
        line1.addStation(station_1L_3S);

        line2.addStation(station_2L_1S);
        line2.addStation(station_2L_2S);
        line2.addStation(station_2L_3S);
        line2.addStation(station_2L_4S);

        line3.addStation(station_3L_1S);
        line3.addStation(station_3L_2S);
        line3.addStation(station_3L_3S);

        route.add(station_1L_1S);
        route.add(station_1L_2S);
        route.add(station_2L_2S);
        route.add(station_2L_3S);

        routeFromOneLine.add(station_1L_1S);
        routeFromOneLine.add(station_1L_2S);
        routeFromOneLine.add(station_1L_3S);

        routWithOneConnections.add(station_1L_1S);
        routWithOneConnections.add(station_1L_2S);
        routWithOneConnections.add(station_2L_2S);
        routWithOneConnections.add(station_2L_3S);
        routWithOneConnections.add(station_2L_4S);

        routWithTwoConnections.add(station_1L_1S);
        routWithTwoConnections.add(station_1L_2S);
        routWithTwoConnections.add(station_2L_2S);
        routWithTwoConnections.add(station_2L_3S);
        routWithTwoConnections.add(station_3L_2S);
        routWithTwoConnections.add(station_3L_3S);

        stationIndex.addStation(station_1L_1S);
        stationIndex.addStation(station_1L_2S);
        stationIndex.addStation(station_1L_3S);

        stationIndex.addStation(station_2L_1S);
        stationIndex.addStation(station_2L_2S);
        stationIndex.addStation(station_2L_3S);
        stationIndex.addStation(station_2L_4S);

        stationIndex.addStation(station_3L_1S);
        stationIndex.addStation(station_3L_2S);
        stationIndex.addStation(station_3L_3S);

        stationIndex.addLine(line1);
        stationIndex.addLine(line2);
        stationIndex.addLine(line3);

        connections.add(station_1L_2S);
        connections.add(station_2L_2S);

        connectionsTwo.add(station_2L_3S);
        connectionsTwo.add(station_3L_2S);

        stationIndex.addConnection(connections);
        stationIndex.addConnection(connectionsTwo);

        routeCalculator = new RouteCalculator(stationIndex);
    }

    @Test
    @DisplayName("Время затраченное на 4 станции с одной пересадкой")
    void testCalculateDuration(){
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 8.5;

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка правельности вывода станций")
    void testGetShortestRoute(){
        List<Station> actual = routeCalculator.getShortestRoute(stationIndex.getStation("Cucumber"), stationIndex.getStation("Blackberry"));
        List<Station> expected = List.of(route.get(0), route.get(1), route.get(2), route.get(3));

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Соеденены ли станции")
    void testIsConnected(){
        assertTrue(connections.contains(new Station("Pineapple", new Line(1, "FirstLine"))));
    }

    @Test
    @DisplayName("Проезд по одной линии")
    void testGetRouteOnTheLine(){
        List<Station> actual = routeCalculator.getShortestRoute(routeFromOneLine.get(0), routeFromOneLine.get(2));
        List<Station> expected = stationIndex.getLine(1).getStations();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проез с 1 пересадкой")
    void testGetRouteWithOneConnection(){
        List<Station> actual = routeCalculator.getShortestRoute(stationIndex.getStation("Cucumber"), stationIndex.getStation("Watermelon"));
        List<Station> expected = List.of(routWithOneConnections.get(0),
                routWithOneConnections.get(1),
                routWithOneConnections.get(2),
                routWithOneConnections.get(3),
                routWithOneConnections.get(4));

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проезд с 2 пересадками")
    void testGetRouteWithTwoConnections(){
        List<Station> actual = routeCalculator.getShortestRoute(stationIndex.getStation("Cucumber"), stationIndex.getStation("Guava"));
        List<Station> expected = List.of(routWithTwoConnections.get(0),
                routWithTwoConnections.get(1),
                routWithTwoConnections.get(2),
                routWithTwoConnections.get(3),
                routWithTwoConnections.get(4),
                routWithTwoConnections.get(5));

        assertEquals(expected, actual);
    }

    protected void tearDown() throws Exception {

    }
}
