package sources.oop.design.dzone.facade;

import java.util.ArrayList;
import java.util.Date;

public class FlightBooker {

    public ArrayList<Flight> getFlightsFor(Date from, Date to) {
        //returns flights available in the particular date range
        return new ArrayList<>();
    }

    static class Flight {

    }

}
